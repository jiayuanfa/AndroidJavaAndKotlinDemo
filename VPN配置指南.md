# Windows 11 全局VPN配置指南

## 📋 目录
1. [方法一：使用自动配置脚本（推荐）](#方法一使用自动配置脚本推荐)
2. [方法二：手动配置路由](#方法二手动配置路由)
3. [方法三：VPN客户端设置](#方法三vpn客户端设置)
4. [常见问题解决](#常见问题解决)

---

## 方法一：使用自动配置脚本（推荐）

### 步骤：

1. **以管理员身份运行** `setup_global_vpn.bat`
   - 右键点击脚本 → 选择"以管理员身份运行"

2. **脚本会自动：**
   - 检测VPN适配器
   - 配置默认路由指向VPN
   - 保持本地网络访问
   - 验证配置

3. **恢复网络：**
   - 运行 `restore_normal_network.bat` 恢复原网络

---

## 方法二：手动配置路由

### 步骤：

1. **以管理员身份打开 PowerShell 或 CMD**

2. **查看当前网络配置：**
```powershell
ipconfig
route print
```

3. **找到VPN适配器信息：**
   - VPN适配器名称：`LetsTAP` 或 `TAP-Windows Adapter V9`
   - VPN适配器IP：例如 `26.26.26.1`
   - VPN网关IP：通常是VPN服务器IP（需要从VPN客户端获取）

4. **删除WLAN的默认路由：**
```powershell
route delete 0.0.0.0 mask 0.0.0.0 192.168.3.1
```

5. **添加VPN默认路由（优先级更高）：**
```powershell
route add 0.0.0.0 mask 0.0.0.0 <VPN网关IP> metric 1
```

6. **添加本地网络路由（保持访问本地设备）：**
```powershell
route add 192.168.0.0 mask 255.255.0.0 192.168.3.1 metric 10
```

7. **验证配置：**
```powershell
route print | findstr "0.0.0.0"
ping 8.8.8.8
```

---

## 方法三：VPN客户端设置

### 常见VPN客户端配置：

#### 1. **Clash for Windows**
- 打开 Clash
- 进入 **Settings** → **General**
- 启用：
  - ✅ **System Proxy**（系统代理）
  - ✅ **Start with Windows**（开机启动）
- 进入 **Connections**
  - 选择 **Global** 模式
  - 启用 **Allow LAN**（允许局域网）

#### 2. **V2RayN**
- 右键系统托盘图标
- 选择 **系统代理** → **自动配置系统代理**
- 或选择 **系统代理** → **清除系统代理** 后手动配置路由

#### 3. **Shadowsocks**
- 右键系统托盘图标
- 选择 **系统代理模式** → **全局模式**
- 启用 **允许来自局域网的连接**

#### 4. **Windows内置VPN**
1. 打开 **设置** → **网络和Internet** → **VPN**
2. 点击你的VPN连接 → **高级选项**
3. 启用：
   - ✅ **自动连接**
   - ✅ **使用VPN时允许本地网络上的设备访问**

---

## 常见问题解决

### ❌ 问题1：VPN连接后无法访问本地网络

**解决方案：**
```powershell
# 添加本地网络路由
route add 192.168.0.0 mask 255.255.0.0 <本地网关> metric 10
route add 10.0.0.0 mask 255.0.0.0 <本地网关> metric 10
```

### ❌ 问题2：VPN路由被重置

**解决方案：**
1. 检查是否有其他网络管理软件干扰
2. 使用脚本定期检查并修复路由
3. 在VPN客户端中启用"保持连接"选项

### ❌ 问题3：DNS泄漏

**解决方案：**
```powershell
# 设置VPN DNS
netsh interface ip set dns "LetsTAP" static 8.8.8.8
netsh interface ip add dns "LetsTAP" 8.8.4.4 index=2
```

### ❌ 问题4：VPN断开后无法上网

**解决方案：**
运行 `restore_normal_network.bat` 恢复网络

---

## 🔍 验证VPN是否生效

### 1. 检查IP地址
访问：https://whatismyipaddress.com/
- 应该显示VPN服务器的IP，而不是你的真实IP

### 2. 检查路由表
```powershell
route print | findstr "0.0.0.0"
```
- 默认路由应该指向VPN网关

### 3. 测试DNS
```powershell
nslookup google.com
```
- 应该使用VPN的DNS服务器

### 4. 测试连接
```powershell
ping 8.8.8.8
tracert 8.8.8.8
```

---

## 📝 注意事项

1. ⚠️ **必须使用管理员权限**运行路由配置命令
2. ⚠️ **VPN网关IP**需要根据你的VPN服务商提供的信息填写
3. ⚠️ **本地网络路由**需要根据你的实际网络环境调整（192.168.x.x 或 10.x.x.x）
4. ⚠️ 某些VPN客户端会自动管理路由，手动配置可能冲突
5. ⚠️ 配置后如果出现问题，运行恢复脚本

---

## 🛠️ 高级配置

### 创建VPN监控脚本（自动修复路由）

可以创建一个定时任务，定期检查VPN路由，如果失效则自动修复。

### 批量添加路由规则

如果需要排除某些IP不走VPN：
```powershell
# 添加直连路由（不走VPN）
route add <目标IP> mask 255.255.255.255 <本地网关> metric 5
```

---

## 📞 需要帮助？

如果遇到问题：
1. 运行 `check_vpn_routes.bat` 诊断
2. 检查VPN客户端日志
3. 查看Windows事件查看器中的网络相关错误


