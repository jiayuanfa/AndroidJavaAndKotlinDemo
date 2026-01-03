# 项目级别的 Git 环境配置
# 在 Android Studio 终端中运行: . .git-env.ps1

# 刷新环境变量
$env:Path = [System.Environment]::GetEnvironmentVariable("Path","Machine") + ";" + [System.Environment]::GetEnvironmentVariable("Path","User")

# 确保 Git 路径在 PATH 中
$gitPath = "C:\Program Files\Git\cmd"
if ($env:Path -notlike "*$gitPath*") {
    $env:Path = "$gitPath;$env:Path"
}

# 验证 Git
if (Get-Command git -ErrorAction SilentlyContinue) {
    Write-Host "Git configured successfully!" -ForegroundColor Green
    git --version
} else {
    Write-Host "Git not found" -ForegroundColor Red
}

