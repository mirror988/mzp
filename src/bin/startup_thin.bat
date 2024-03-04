@echo off

setlocal
echo ------------------------MZP Bootapp------------------------
cd ..\
set "CURRENT_DIR=%cd%"
set "CONF_DIR=%CURRENT_DIR%/conf"
set "ARGS=%*"
echo "Current Dir:%CURRENT_DIR%"
echo "Config Dir:%CONF_DIR%"
for /f "delims=" %%A in ('dir /b %CURRENT_DIR%\lib\bootapp\*.jar') do set "JarName=%%A"
echo Jar name:%JarName%
if defined  JarName   goto checkconfig
echo %CURRENT_DIR%\lib\bootapp\%JarName% is not exist.Startup failed!
pause
exit 

:checkconfig
if exist "%CONF_DIR%\application.properties" goto gostart 
echo Configuration folder or files is not exist.Startup failed!
pause
exit 

:gostart
title %JarName%
echo Startup Args:%ARGS%
echo CONF_DIR:%CONF_DIR%
set STARTUP=java -server -Dspring.config.location="%CONF_DIR%/" -Dthin.lib.path="%CURRENT_DIR%/lib/" -Dlogging.config="%CONF_DIR%/logback-spring.xml" -Duser.timezone=GMT+08 -jar %CURRENT_DIR%\lib\bootapp\%JarName% %ARGS%
echo %STARTUP%
@echo/
@echo/
echo MZP Bootapp starting......
%STARTUP%
pause
exit
:end