@echo off
chcp 65001 >nul
:: LetsVPN 专用全局路由配置脚本

echo ========================================
echo LetsVPN 全局路由配置工具
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

echo [步骤1] 检查LetsVPN连接状态...
ipconfig | findstr /i "LetsTAP"
if %errorLevel% neq 0 (
    echo    [警告] 未检测到LetsVPN适配器
    echo    请确保LetsVPN已连接！
    echo.
    pause
)
echo.

echo [步骤2] 获取网络信息...
:: 获取VPN适配器IP
for /f "tokens=2" %%a in ('ipconfig ^| findstr /i /c:"IPv4" /c:"26.26.26"') do (
    set VPN_IP=%%a
    goto :got_vpn_ip
)
:got_vpn_ip

:: 获取WLAN信息
for /f "tokens=2" %%a in ('ipconfig ^| findstr /i /c:"IPv4" /c:"WLAN" /c:"192.168"') do (
    set WLAN_IP=%%a
    goto :got_wlan_ip
)
:got_wlan_ip

set WLAN_GATEWAY=192.168.3.1
for /f "tokens=2" %%a in ('ipconfig ^| findstr /i /c:"默认网关" /c:"Default Gateway"') do (
    set WLAN_GATEWAY=%%a
    goto :got_gateway
)
:got_gateway

echo    VPN适配器IP: %VPN_IP%
echo    WLAN IP: %WLAN_IP%
echo    WLAN网关: %WLAN_GATEWAY%
echo.

echo [步骤3] 查找LetsVPN服务器IP...
echo    提示: LetsVPN使用TAP适配器，服务器IP需要从客户端获取
echo.
echo    方法1: 打开LetsVPN客户端，查看当前连接的服务器信息
echo    方法2: 查看LetsVPN的日志或连接详情
echo    方法3: 尝试使用VPN适配器的网关IP
echo.

:: 尝试从路由表查找可能的网关
set VPN_GATEWAY=
for /f "tokens=3" %%a in ('route print ^| findstr "26.26.26" ^| findstr "0.0.0.0"') do (
    set VPN_GATEWAY=%%a
    goto :found_gateway
)

:: 如果没找到，使用常见的VPN网关
echo    未在路由表中找到VPN网关，尝试常见值...
set VPN_GATEWAY=26.26.26.7

:found_gateway
echo    检测到的可能网关: %VPN_GATEWAY%
echo.

echo [步骤4] 配置路由...
echo    删除旧的默认路由...
route delete 0.0.0.0 mask 0.0.0.0 %WLAN_GATEWAY% >nul 2>&1
route delete 0.0.0.0 mask 0.0.0.0 %VPN_GATEWAY% >nul 2>&1
echo    ✓ 已清理
echo.

echo    添加VPN默认路由...
route add 0.0.0.0 mask 0.0.0.0 %VPN_GATEWAY% metric 1
if %errorLevel% equ 0 (
    echo    ✓ VPN路由添加成功（使用: %VPN_GATEWAY%）
) else (
    echo    ✗ 使用 %VPN_GATEWAY% 失败
    echo.
    echo    [重要] 需要手动指定LetsVPN服务器IP
    echo.
    set /p VPN_GATEWAY="请输入LetsVPN服务器IP地址: "
    if "%VPN_GATEWAY%"=="" (
        echo    [错误] 未输入服务器IP，退出
        pause
        exit /b 1
    )
    route delete 0.0.0.0 mask 0.0.0.0 %VPN_GATEWAY% >nul 2>&1
    route add 0.0.0.0 mask 0.0.0.0 %VPN_GATEWAY% metric 1
    if %errorLevel% neq 0 (
        echo    ✗ 路由添加失败，请检查IP是否正确
        pause
        exit /b 1
    )
    echo    ✓ VPN路由添加成功（使用: %VPN_GATEWAY%）
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
echo    ✓ DNS已设置为 8.8.8.8 和 8.8.4.4
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
    echo    [警告] 网络连接测试失败
)
echo.

echo ========================================
echo 配置完成！
echo ========================================
echo.
echo 重要提示：
echo 1. 访问 https://whatismyipaddress.com/ 验证IP是否改变
echo 2. 如果IP没有改变，说明VPN服务器IP不正确
echo 3. 请打开LetsVPN客户端，查看当前连接的服务器IP
echo 4. 然后运行"手动配置VPN.bat"并输入正确的服务器IP
echo.
echo 当前使用的VPN网关: %VPN_GATEWAY%
echo.
pause


