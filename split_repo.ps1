$ErrorActionPreference = 'Stop'

$filePath = 'app\src\main\java\com\example\androidjavaandkotlindemo\data\KnowledgeDetailsRepository.kt'

Write-Host "Reading file..."
$content = [System.IO.File]::ReadAllText($filePath, [System.Text.Encoding]::UTF8)

Write-Host "Finding Java section..."
$javaMarker = '// ========== Java 基础语法 =========='
$javaPos = $content.IndexOf($javaMarker)
if ($javaPos -eq -1) {
    # Try with different encoding
    $javaMarker2 = "// ========== Java 基础语法 =========="
    $javaPos = $content.IndexOf($javaMarker2)
}
if ($javaPos -eq -1) {
    # Try finding just the pattern
    $javaPos = $content.IndexOf('Java 基础语法')
    if ($javaPos -gt 0) {
        # Find the start of the comment line
        $lineStart = $content.LastIndexOf("`n", $javaPos) + 1
        $javaPos = $lineStart
    }
}
if ($javaPos -eq -1 -or $javaPos -le 0) {
    Write-Host "Error: Java section not found. Content length: $($content.Length)"
    Write-Host "Searching for 'Java 基础语法'..."
    $testPos = $content.IndexOf('Java 基础语法')
    Write-Host "Found 'Java 基础语法' at: $testPos"
    exit 1
}
Write-Host "Java section starts at position: $javaPos"

$listStartMarker = 'private val allKnowledgeDetails = listOf('
$listStartPos = $content.IndexOf($listStartMarker)
$listStart = $listStartPos + $listStartMarker.Length

Write-Host "List starts at position: $listStart"

$header = $content.Substring(0, $listStart)
$kotlinData = $content.Substring($listStart, $javaPos - $listStart)
$javaDataFull = $content.Substring($javaPos)

$endMarker = "    )`n}"
$endPos = $javaDataFull.LastIndexOf($endMarker)
if ($endPos -eq -1) {
    $endMarker = "    )`r`n}"
    $endPos = $javaDataFull.LastIndexOf($endMarker)
}
if ($endPos -ne -1) {
    $javaData = $javaDataFull.Substring(0, $endPos + $endMarker.Length)
} else {
    $javaData = $javaDataFull
}

Write-Host "Creating Kotlin repository..."
$kotlinHeader = $header -replace '知识详情数据仓库', 'Kotlin 知识详情数据仓库'
$kotlinHeader = $kotlinHeader -replace 'object KnowledgeDetailsRepository', 'object KotlinKnowledgeDetailsRepository'
$kotlinContent = $kotlinHeader + $kotlinData + "    )`n}`n"

$kotlinFile = 'app\src\main\java\com\example\androidjavaandkotlindemo\data\KotlinKnowledgeDetailsRepository.kt'
[System.IO.File]::WriteAllText($kotlinFile, $kotlinContent, [System.Text.Encoding]::UTF8)
Write-Host "Created: $kotlinFile"

Write-Host "Creating Java repository..."
$javaHeader = $header -replace '知识详情数据仓库', 'Java 知识详情数据仓库'
$javaHeader = $javaHeader -replace 'object KnowledgeDetailsRepository', 'object JavaKnowledgeDetailsRepository'
$javaContent = $javaHeader + $javaData + "`n}"

$javaFile = 'app\src\main\java\com\example\androidjavaandkotlindemo\data\JavaKnowledgeDetailsRepository.kt'
[System.IO.File]::WriteAllText($javaFile, $javaContent, [System.Text.Encoding]::UTF8)
Write-Host "Created: $javaFile"

Write-Host "Done!"

