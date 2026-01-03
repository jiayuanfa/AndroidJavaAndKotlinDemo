@echo off
chcp 65001 >nul
:: 恢复正常网络（移除VPN路由）

echo ========================================
echo 恢复正常网络路由
echo ========================================
echo.

:: 检查管理员权限
net session >nul 2>&1
if %errorLevel% neq 0 (
    echo [错误] 请以管理员身份运行此脚本！
    pause
    exit /b 1
)

echo [1] 删除VPN默认路由...
route delete 0.0.0.0 mask 0.0.0.0 26.26.26.7 >nul 2>&1
route delete 0.0.0.0 mask 0.0.0.0 26.26.26.1 >nul 2>&1
echo    已删除VPN路由
echo.

echo [2] 恢复WLAN默认路由...
for /f "tokens=2 delims=:" %%a in ('ipconfig ^| findstr /i /c:"IPv4" /c:"WLAN"') do (
    set LOCAL_IP=%%a
    goto :found_local
)
:found_local

:: 获取默认网关
for /f "tokens=2 delims=:" %%a in ('ipconfig ^| findstr /i /c:"默认网关" /c:"Default Gateway"') do (
    set GATEWAY=%%a
    goto :found_gateway
)
:found_gateway

echo    本地网关: %GATEWAY%
route add 0.0.0.0 mask 0.0.0.0 %GATEWAY% metric 35 >nul 2>&1
echo    已恢复WLAN默认路由
echo.

echo [3] 验证路由...
route print | findstr "0.0.0.0"
echo.

echo ========================================
echo 网络已恢复正常
echo ========================================
pause

