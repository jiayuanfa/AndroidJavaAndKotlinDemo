@echo off
chcp 65001 >nul
echo ========================================
echo VPN路由诊断工具
echo ========================================
echo.

echo [1] 检查网络适配器状态...
netsh interface show interface
echo.

echo [2] 检查默认路由...
route print | findstr "0.0.0.0"
echo.

echo [3] 检查VPN适配器IP...
ipconfig | findstr /i "LetsTAP TAP"
echo.

echo [4] 检查DNS设置...
ipconfig /all | findstr /i "DNS"
echo.

echo [5] 测试网络连接...
ping -n 2 8.8.8.8
echo.

echo [6] 测试DNS解析...
nslookup google.com | findstr "Address"
echo.

echo ========================================
echo 诊断完成
echo ========================================
pause

