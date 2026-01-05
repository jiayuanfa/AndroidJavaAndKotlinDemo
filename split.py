# -*- coding: utf-8 -*-
import sys

file_path = r'app\src\main\java\com\example\androidjavaandkotlindemo\data\KnowledgeDetailsRepository.kt'

# 读取文件内容
with open(file_path, 'r', encoding='utf-8') as f:
    content = f.read()

# 找到 Java 部分开始位置
java_marker = '// ========== Java 基础语法 =========='
java_start = content.find(java_marker)

if java_start == -1:
    print('错误：找不到 Java 部分')
    sys.exit(1)

# 找到列表开始位置
list_start_marker = 'private val allKnowledgeDetails = listOf('
list_start = content.find(list_start_marker) + len(list_start_marker)

# 找到列表结束位置（最后一个 ) 在 } 之前）
# 列表在 object 结束之前结束，所以找到最后一个 )\n} 模式
last_brace_pos = content.rfind('\n}')
if last_brace_pos == -1:
    last_brace_pos = content.rfind('}')
list_end_marker = '    )\n}'
list_end = content.rfind(list_end_marker, last_brace_pos - 200)
if list_end == -1:
    # 如果找不到，使用简单的方法
    list_end = content.rfind('\n    )\n}', last_brace_pos - 200)
if list_end != -1:
    list_end += len(list_end_marker)
else:
    list_end = len(content) - 2  # 回退到简单的方法

# 分割内容
header = content[:list_start]
kotlin_data = content[list_start:java_start]
java_data = content[java_start:list_end]

# 创建 Kotlin 仓库
kotlin_header = header.replace('知识详情数据仓库', 'Kotlin 知识详情数据仓库')
kotlin_header = kotlin_header.replace('object KnowledgeDetailsRepository', 'object KotlinKnowledgeDetailsRepository')
kotlin_content = kotlin_header + kotlin_data + '    )\n}\n'

kotlin_file = r'app\src\main\java\com\example\androidjavaandkotlindemo\data\KotlinKnowledgeDetailsRepository.kt'
with open(kotlin_file, 'w', encoding='utf-8') as f:
    f.write(kotlin_content)
print(f'已创建: {kotlin_file}')

# 创建 Java 仓库
java_header = header.replace('知识详情数据仓库', 'Java 知识详情数据仓库')
java_header = java_header.replace('object KnowledgeDetailsRepository', 'object JavaKnowledgeDetailsRepository')
java_content = java_header + java_data + '\n}'

java_file = r'app\src\main\java\com\example\androidjavaandkotlindemo\data\JavaKnowledgeDetailsRepository.kt'
with open(java_file, 'w', encoding='utf-8') as f:
    f.write(java_content)
print(f'已创建: {java_file}')

print('完成！')

