# -*- coding: utf-8 -*-
import sys
import os

file_path = r'app\src\main\java\com\example\androidjavaandkotlindemo\data\KnowledgeDetailsRepository.kt'

print(f'正在读取文件: {file_path}')
print(f'文件是否存在: {os.path.exists(file_path)}')

try:
    with open(file_path, 'r', encoding='utf-8') as f:
        content = f.read()
    print(f'文件大小: {len(content)} 字符')
except Exception as e:
    print(f'读取文件失败: {e}')
    sys.exit(1)

# 找到 Java 部分开始位置
java_marker = '// ========== Java 基础语法 =========='
java_start = content.find(java_marker)
print(f'Java 标记位置: {java_start}')

if java_start == -1:
    print('错误：找不到 Java 部分')
    sys.exit(1)

# 找到列表开始位置
list_start_marker = 'private val allKnowledgeDetails = listOf('
list_start_pos = content.find(list_start_marker)
if list_start_pos == -1:
    print('错误：找不到列表开始标记')
    sys.exit(1)
list_start = list_start_pos + len(list_start_marker)
print(f'列表开始位置: {list_start}')

# 分割内容
header = content[:list_start]
kotlin_data = content[list_start:java_start]
java_data_start = java_start

# 找到 Java 数据结束位置（列表结束）
# 找到最后一个 KnowledgeDetail 的结束，然后是列表结束
# 简单方法：找到文件末尾的 )\n}
end_marker = '    )\n}'
end_pos = content.rfind(end_marker)
if end_pos == -1:
    # 尝试另一种模式
    end_pos = content.rfind('\n    )\n}')
    if end_pos != -1:
        end_pos += 1  # 包含换行符
        end_marker = '\n    )\n}'

java_data = content[java_data_start:end_pos] if end_pos != -1 else content[java_data_start:]
print(f'Java 数据长度: {len(java_data)} 字符')
print(f'Kotlin 数据长度: {len(kotlin_data)} 字符')

# 创建 Kotlin 仓库
kotlin_header = header.replace('知识详情数据仓库', 'Kotlin 知识详情数据仓库')
kotlin_header = kotlin_header.replace('object KnowledgeDetailsRepository', 'object KotlinKnowledgeDetailsRepository')
kotlin_content = kotlin_header + kotlin_data + '    )\n}\n'

kotlin_file = r'app\src\main\java\com\example\androidjavaandkotlindemo\data\KotlinKnowledgeDetailsRepository.kt'
try:
    with open(kotlin_file, 'w', encoding='utf-8') as f:
        f.write(kotlin_content)
    print(f'✓ 已创建: {kotlin_file}')
except Exception as e:
    print(f'创建 Kotlin 文件失败: {e}')
    sys.exit(1)

# 创建 Java 仓库
java_header = header.replace('知识详情数据仓库', 'Java 知识详情数据仓库')
java_header = java_header.replace('object KnowledgeDetailsRepository', 'object JavaKnowledgeDetailsRepository')
java_content = java_header + java_data + '\n}'

java_file = r'app\src\main\java\com\example\androidjavaandkotlindemo\data\JavaKnowledgeDetailsRepository.kt'
try:
    with open(java_file, 'w', encoding='utf-8') as f:
        f.write(java_content)
    print(f'✓ 已创建: {java_file}')
except Exception as e:
    print(f'创建 Java 文件失败: {e}')
    sys.exit(1)

print('完成！')

