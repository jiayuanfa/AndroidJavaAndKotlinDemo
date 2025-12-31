# Android Studio 终端 Git 配置说明

## ✅ 已完成的配置

1. **PowerShell 用户配置文件** - 已创建在 `C:\Users\jiayu\Documents\WindowsPowerShell\Microsoft.PowerShell_profile.ps1`
   - 每次打开 PowerShell 终端时会自动加载 Git 路径
   - 适用于所有 PowerShell 终端（包括 Android Studio）

2. **项目级配置脚本** - `.git-env.ps1`
   - 可在 Android Studio 终端中手动运行以刷新环境变量

## 🚀 使用方法

### 方法 1：自动加载（推荐）

**重启 Android Studio** 后，打开终端，Git 应该已经可以使用了。

如果还是不行，在 Android Studio 终端中运行：
```powershell
. .git-env.ps1
```

### 方法 2：手动刷新

在 Android Studio 终端中运行：
```powershell
$env:Path = [System.Environment]::GetEnvironmentVariable("Path","Machine") + ";" + [System.Environment]::GetEnvironmentVariable("Path","User")
```

### 方法 3：使用完整路径（临时方案）

如果上述方法都不行，可以直接使用完整路径：
```powershell
& "C:\Program Files\Git\cmd\git.exe" status
```

## 🔍 验证配置

运行以下命令验证 Git 是否可用：
```powershell
git --version
git status
```

## 📝 注意事项

- 如果重启 Android Studio 后仍然无法使用，请检查 Android Studio 的终端设置：
  - `File` → `Settings` → `Tools` → `Terminal`
  - 确保 Shell path 设置为 PowerShell 或 CMD
  - 确保 Environment variables 中包含 Git 路径

- PowerShell 配置文件会在每次打开新的 PowerShell 会话时自动执行
- 如果修改了系统环境变量，需要重启 Android Studio 才能生效

