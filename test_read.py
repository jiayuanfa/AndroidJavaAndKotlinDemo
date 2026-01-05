# -*- coding: utf-8 -*-
import sys

file_path = r'app\src\main\java\com\example\androidjavaandkotlindemo\data\KnowledgeDetailsRepository.kt'

print('Testing file read...')
with open(file_path, 'r', encoding='utf-8') as f:
    # Read first 1000 chars to test
    test_content = f.read(1000)
    print(f'First 100 chars: {test_content[:100]}')
    
    # Now read full file
    f.seek(0)
    content = f.read()
    print(f'Total length: {len(content)}')
    
    # Find Java marker
    java_marker = '// ========== Java 基础语法 =========='
    pos = content.find(java_marker)
    print(f'Java marker position: {pos}')
    
    if pos > 0:
        print('SUCCESS: Found Java marker!')
        sys.exit(0)
    else:
        print('FAILED: Java marker not found')
        # Try alternative
        pos2 = content.find('Java 基础语法')
        print(f'Alternative search for "Java 基础语法": {pos2}')
        sys.exit(1)

