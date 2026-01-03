@echo off
chcp 65001 >nul
:: 手动配置VPN路由 - 需要用户输入VPN服务器IP

echo ========================================
echo 手动配置VPN全局路由
echo ========================================
echo.

:: 检查管理员权限
net session >nul 2>&1
if %errorLevel% neq 0 (
    echo [错误] 请以管理员身份运行此脚本！
    pause
    exit /b 1
)

echo [重要] 需要知道VPN服务器的IP地址
echo.
echo 如何查找VPN服务器IP：
echo 1. 打开VPN客户端
echo 2. 查看"服务器地址"、"Server IP"或"Remote Address"
echo 3. 或者查看VPN连接日志
echo.
set /p VPN_SERVER_IP="请输入VPN服务器IP地址（例如: 1.2.3.4）: "

if "%VPN_SERVER_IP%"=="" (
    echo [错误] 未输入VPN服务器IP！
    pause
    exit /b 1
)

echo.
echo [1] 配置路由...
echo    使用VPN服务器IP: %VPN_SERVER_IP%
echo.

:: 获取WLAN网关
set WLAN_GATEWAY=192.168.3.1
for /f "tokens=2" %%a in ('ipconfig ^| findstr /i /c:"默认网关" /c:"Default Gateway"') do (
    set WLAN_GATEWAY=%%a
    goto :got_gateway
)
:got_gateway

echo    当前WLAN网关: %WLAN_GATEWAY%
echo.

:: 删除旧路由
echo [2] 删除旧的默认路由...
route delete 0.0.0.0 mask 0.0.0.0 %WLAN_GATEWAY% >nul 2>&1
route delete 0.0.0.0 mask 0.0.0.0 %VPN_SERVER_IP% >nul 2>&1
echo    ✓ 已清理
echo.

:: 添加VPN路由
echo [3] 添加VPN默认路由...
route add 0.0.0.0 mask 0.0.0.0 %VPN_SERVER_IP% metric 1
if %errorLevel% equ 0 (
    echo    ✓ VPN路由添加成功！
) else (
    echo    ✗ 路由添加失败，请检查VPN服务器IP是否正确
    echo    提示: VPN服务器IP应该是VPN客户端的"服务器地址"
    pause
    exit /b 1
)
echo.

:: 添加本地网络路由
echo [4] 添加本地网络路由...
for /f "tokens=2" %%a in ('ipconfig ^| findstr /i /c:"IPv4" /c:"WLAN" /c:"192.168"') do (
    set WLAN_IP=%%a
    goto :got_wlan_ip
)
:got_wlan_ip

for /f "tokens=1,2 delims=." %%a in ("%WLAN_IP%") do (
    route add %%a.%%b.0.0 mask 255.255.0.0 %WLAN_GATEWAY% metric 10 >nul 2>&1
)
echo    ✓ 本地网络路由已添加
echo.

:: 配置DNS
echo [5] 配置DNS...
netsh interface ip set dns "LetsTAP" static 8.8.8.8 >nul 2>&1
netsh interface ip add dns "LetsTAP" 8.8.4.4 index=2 >nul 2>&1
echo    ✓ DNS已配置
echo.

:: 验证
echo [6] 验证配置...
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
echo 请访问 https://whatismyipaddress.com/ 验证IP是否改变
echo 如果IP没有改变，说明VPN服务器IP可能不正确
echo.
pause


