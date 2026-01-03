@echo off
chcp 65001 >nul
:: 智能VPN路由修复工具 - 自动检测并配置

echo ========================================
echo 智能VPN路由修复工具
echo ========================================
echo.

:: 检查管理员权限
net session >nul 2>&1
if %errorLevel% neq 0 (
    echo [错误] 请以管理员身份运行此脚本！
    pause
    exit /b 1
)

echo [步骤1] 检查VPN适配器...
set VPN_FOUND=0
for /f "tokens=*" %%a in ('ipconfig ^| findstr /i /c:"LetsTAP" /c:"TAP"') do (
    echo    找到VPN适配器
    set VPN_FOUND=1
)

if %VPN_FOUND%==0 (
    echo    [错误] 未找到VPN适配器，请先连接VPN！
    pause
    exit /b 1
)
echo.

echo [步骤2] 获取网络信息...
:: 获取VPN IP
for /f "tokens=2" %%a in ('ipconfig ^| findstr /i /c:"IPv4" /c:"26.26.26"') do (
    set VPN_IP=%%a
    goto :got_vpn_ip
)
:got_vpn_ip

:: 获取WLAN IP和网关
for /f "tokens=2" %%a in ('ipconfig ^| findstr /i /c:"IPv4" /c:"WLAN" /c:"192.168"') do (
    set WLAN_IP=%%a
    goto :got_wlan_ip
)
:got_wlan_ip

for /f "tokens=2" %%a in ('ipconfig ^| findstr /i /c:"默认网关" /c:"Default Gateway" /c:"192.168.3.1"') do (
    set WLAN_GATEWAY=%%a
    goto :got_wlan_gateway
)
:got_wlan_gateway
set WLAN_GATEWAY=192.168.3.1

echo    VPN IP: %VPN_IP%
echo    WLAN IP: %WLAN_IP%
echo    WLAN网关: %WLAN_GATEWAY%
echo.

echo [步骤3] 查找VPN服务器IP...
echo    提示: 如果自动检测失败，请查看VPN客户端中的"服务器地址"
echo.

:: 尝试从路由表查找
set VPN_GATEWAY=
for /f "tokens=3" %%a in ('route print ^| findstr "26.26.26" ^| findstr "0.0.0.0"') do (
    set VPN_GATEWAY=%%a
    goto :found_gateway
)

:: 如果没找到，尝试常见的VPN网关
set VPN_GATEWAY=26.26.26.7

:found_gateway
echo    尝试使用网关: %VPN_GATEWAY%
echo.

echo [步骤4] 配置路由...
echo    删除旧的默认路由...
route delete 0.0.0.0 mask 0.0.0.0 %WLAN_GATEWAY% >nul 2>&1
route delete 0.0.0.0 mask 0.0.0.0 %VPN_GATEWAY% >nul 2>&1
echo    ✓ 已清理旧路由
echo.

echo    添加VPN默认路由...
route add 0.0.0.0 mask 0.0.0.0 %VPN_GATEWAY% metric 1
if %errorLevel% neq 0 (
    echo    [警告] 使用 %VPN_GATEWAY% 失败，尝试使用VPN适配器IP...
    route add 0.0.0.0 mask 0.0.0.0 %VPN_IP% metric 1
    if %errorLevel% equ 0 (
        set VPN_GATEWAY=%VPN_IP%
        echo    ✓ 使用VPN适配器IP成功
    ) else (
        echo    [错误] 路由配置失败！
        echo    请检查VPN是否正常连接，或手动指定VPN服务器IP
        pause
        exit /b 1
    )
) else (
    echo    ✓ VPN路由添加成功
)
echo.

echo    添加本地网络路由...
for /f "tokens=1,2 delims=." %%a in ("%WLAN_IP%") do (
    route add %%a.%%b.0.0 mask 255.255.0.0 %WLAN_GATEWAY% metric 10 >nul 2>&1
)
echo    ✓ 本地网络路由已添加
echo.

echo [步骤5] 配置DNS...
netsh interface ip set dns "LetsTAP" static 8.8.8.8 >nul 2>&1
netsh interface ip add dns "LetsTAP" 8.8.4.4 index=2 >nul 2>&1
echo    ✓ DNS已配置
echo.

echo [步骤6] 验证配置...
echo    当前默认路由:
route print | findstr "0.0.0.0"
echo.

echo [步骤7] 测试连接...
ping -n 2 8.8.8.8
if %errorLevel% equ 0 (
    echo    ✓ 网络连接正常
) else (
    echo    [警告] 网络连接测试失败，但路由已配置
    echo    可能需要检查VPN服务器IP是否正确
)
echo.

echo ========================================
echo 配置完成！
echo ========================================
echo.
echo 重要提示：
echo 1. 如果仍然无法上网，VPN服务器IP可能不正确
echo 2. 请查看VPN客户端中的"服务器地址"或"Server IP"
echo 3. 然后修改脚本中的 VPN_GATEWAY 变量
echo 4. 访问 https://whatismyipaddress.com/ 验证IP是否改变
echo.
echo 当前使用的VPN网关: %VPN_GATEWAY%
echo.
pause


