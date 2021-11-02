# This Script is a Powershell module.
# To learn more about Powershell visit : https://docs.microsoft.com/en-us/powershell/

if ((Test-Path -Path .\android) -eq $false) {
    Write-Output "Android Directory not found, please confirm this is a react native project."
    exit 1
}

if (!$args[0] -or
    !$args[0].Equals( "debug") -and
    !$args[0].Equals("release") ) {
    Write-Output "Please specify a build of type [release/debug]"
    exit 1
}
if ((Test-Path -Path .\apks) -eq $false
) {
    Write-Output "Creating 'apks' directory for storing outputs"
    mkdir .\apks | Out-Null
    mkdir .\apks\debug | Out-Null
    mkdir .\apks\release | Out-Null
}
Set-Location -Path .\android

switch ($args[0]) {
    "debug" {
        Write-Output "Preparing Debug Release..."
        ./gradlew
        Copy-Item -Path .\app\build\outputs\apk\debug\app-debug.apk ..\apks\debug\app-debug.apk | Out-Null
    }
    "release" {
        Write-Output "Preparing Release..."
        ./gradlew assembleRelease
        Copy-Item -Path .\app\build\outputs\apk\release\app-release.apk ..\apks\release\app-release.apk | Out-Null
        Write-Output ""
    }
    Default {
        Write-Output "Please specify a build of type [release/debug]"
    }
}
Set-Location -Path ..
