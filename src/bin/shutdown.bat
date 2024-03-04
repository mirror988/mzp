@echo off

setlocal

cd ..\
set "CURRENT_DIR=%cd%"
echo CURRENT_DIR:%CURRENT_DIR%

for /f "delims=" %%A in ('dir /b %CURRENT_DIR%\lib\*.jar') do set "JarName=%%A"
echo Jarname:%JarName%
if defined  JarName   goto stop
echo %CURRENT_DIR%\lib\%JarName% does not exist!Shutdown failed£°
exit 

:stop
echo KOCA Bootapp Shutdown
for /f "tokens=10" %%i in ('tasklist /v /fi "imagename eq cmd.exe" ^| findstr %JarName%') do (
    rem match windowtitle "koca-xxxx-1.0.0-snapshot" or "π‹¿Ì‘±:  koca-xxxx-1.0.0-snapshot"
	if "%%i"=="%JarName%" (set windowtitle=%%i
	) else (set windowtitle=%%i  %JarName%
	)
)
echo title£∫%windowtitle%
if defined  windowtitle (taskkill /fi "windowtitle eq %windowtitle%" /im cmd.exe /f /t
) else (
echo Task is not exist.
)
exit 
:end

