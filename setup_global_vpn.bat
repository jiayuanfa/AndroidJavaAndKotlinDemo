@echo off
chcp 65001 >nul
:: 需要管理员权限运行
:: 配置Windows 11全局VPN路由，让所有流量走VPN

echo ========================================
echo Windows 11 全局VPN路由配置工具
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
ipconfig | findstr /i "LetsTAP TAP"
echo.

:: 获取VPN适配器IP
for /f "tokens=2 delims=:" %%a in ('ipconfig ^| findstr /i /c:"IPv4" /c:"LetsTAP"') do (
    set VPN_IP=%%a
    goto :found_vpn
)
:found_vpn

echo [2] 当前VPN适配器IP: %VPN_IP%
echo.

:: 自动检测VPN网关
echo [3] 检测VPN网关...
:: 方法1: 从路由表查找VPN网段的网关
for /f "tokens=1,3" %%a in ('route print ^| findstr "26.26.26" ^| findstr "0.0.0.0"') do (
    set VPN_GATEWAY=%%b
    goto :found_gateway
)
:: 方法2: 如果VPN适配器IP是26.26.26.1，网关通常是26.26.26.7或26.26.26.2
set VPN_GATEWAY=26.26.26.7
:found_gateway
echo    检测到VPN网关: %VPN_GATEWAY%
echo    如果配置失败，请手动修改脚本中的VPN_GATEWAY变量
echo.

:: 获取本地网络接口IP（WLAN）
for /f "tokens=2 delims=:" %%a in ('ipconfig ^| findstr /i /c:"IPv4" /c:"WLAN"') do (
    set LOCAL_IP=%%a
    goto :found_local
)
:found_local

echo [4] 当前本地网络IP: %LOCAL_IP%
echo.

echo [5] 删除旧的默认路由...
route delete 0.0.0.0 mask 0.0.0.0 %LOCAL_IP% >nul 2>&1
echo    已删除WLAN默认路由
echo.

echo [6] 添加VPN默认路由（优先级更高）...
route delete 0.0.0.0 mask 0.0.0.0 %VPN_GATEWAY% >nul 2>&1
route add 0.0.0.0 mask 0.0.0.0 %VPN_GATEWAY% metric 1 if 5
if %errorLevel% equ 0 (
    echo    ✓ VPN默认路由添加成功
) else (
    echo    ✗ VPN默认路由添加失败，请检查VPN网关IP
)
echo.

echo [7] 添加本地网络路由（保持本地网络访问）...
for /f "tokens=1,2 delims=." %%a in ("%LOCAL_IP%") do set LOCAL_NET=%%a.%%b.0.0
route add %LOCAL_NET% mask 255.255.0.0 %LOCAL_IP% metric 10 >nul 2>&1
echo    已添加本地网络路由
echo.

echo [8] 验证路由配置...
echo    当前默认路由:
route print | findstr "0.0.0.0"
echo.

echo [9] 测试VPN连接...
ping -n 2 8.8.8.8
echo.

echo ========================================
echo 配置完成！
echo ========================================
echo.
echo 提示：
echo - 所有流量现在应该通过VPN
echo - 本地网络（192.168.x.x）仍然可以访问
echo - 如果VPN断开，请重新运行此脚本
echo.
pause

