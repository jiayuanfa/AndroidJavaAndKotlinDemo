@echo off
chcp 65001 >nul
:: 修复VPN路由 - 强制让所有流量走VPN

echo ========================================
echo VPN路由修复工具
echo ========================================
echo.

:: 检查管理员权限
net session >nul 2>&1
if %errorLevel% neq 0 (
    echo [错误] 请以管理员身份运行此脚本！
    echo 右键点击脚本，选择"以管理员身份运行"
    pause
    exit /b 1
)

echo [1] 检查VPN适配器状态...
ipconfig | findstr /i "LetsTAP"
echo.

:: 获取VPN适配器IP
for /f "tokens=2" %%a in ('ipconfig ^| findstr /i /c:"IPv4" /c:"LetsTAP" /c:"26.26.26"') do (
    set VPN_IP=%%a
    goto :found_vpn_ip
)
:found_vpn_ip

echo [2] VPN适配器IP: %VPN_IP%
echo.

:: 尝试多个可能的VPN网关
echo [3] 尝试配置VPN路由...
echo.

:: 方法1: 使用26.26.26.7作为网关
set VPN_GATEWAY=26.26.26.7
echo    尝试网关: %VPN_GATEWAY%

:: 删除旧的默认路由
route delete 0.0.0.0 mask 0.0.0.0 192.168.3.1 >nul 2>&1
route delete 0.0.0.0 mask 0.0.0.0 %VPN_GATEWAY% >nul 2>&1

:: 添加VPN默认路由
route add 0.0.0.0 mask 0.0.0.0 %VPN_GATEWAY% metric 1
if %errorLevel% equ 0 (
    echo    ✓ 路由添加成功！
) else (
    echo    ✗ 路由添加失败，尝试其他方法...
    :: 方法2: 直接使用VPN适配器IP
    route add 0.0.0.0 mask 0.0.0.0 %VPN_IP% metric 1 >nul 2>&1
    if %errorLevel% equ 0 (
        echo    ✓ 使用VPN适配器IP作为网关成功
        set VPN_GATEWAY=%VPN_IP%
    ) else (
        echo    ✗ 配置失败，请检查VPN连接
        pause
        exit /b 1
    )
)
echo.

:: 添加本地网络路由
echo [4] 配置本地网络路由...
for /f "tokens=2" %%a in ('ipconfig ^| findstr /i /c:"IPv4" /c:"WLAN" /c:"192.168"') do (
    set LOCAL_IP=%%a
    goto :found_local_ip
)
:found_local_ip

echo    本地IP: %LOCAL_IP%
for /f "tokens=1,2 delims=." %%a in ("%LOCAL_IP%") do (
    set LOCAL_NET=%%a.%%b.0.0
    set LOCAL_GATEWAY=%%a.%%b.3.1
)
route add %LOCAL_NET% mask 255.255.0.0 %LOCAL_GATEWAY% metric 10 >nul 2>&1
echo    ✓ 本地网络路由已添加
echo.

:: 设置DNS（使用VPN DNS）
echo [5] 配置DNS...
netsh interface ip set dns "LetsTAP" static 8.8.8.8 >nul 2>&1
netsh interface ip add dns "LetsTAP" 8.8.4.4 index=2 >nul 2>&1
echo    ✓ DNS已设置为 8.8.8.8 和 8.8.4.4
echo.

:: 验证配置
echo [6] 验证路由配置...
echo    当前默认路由:
route print | findstr "0.0.0.0"
echo.

echo [7] 测试连接...
ping -n 2 8.8.8.8
echo.

echo ========================================
echo 配置完成！
echo ========================================
echo.
echo 提示：
echo - 默认路由现在指向: %VPN_GATEWAY%
echo - 所有流量应该通过VPN
echo - 访问 https://whatismyipaddress.com/ 验证IP
echo.
pause


