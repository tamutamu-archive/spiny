CHCP 65001
@echo off
echo.author godcheese
set "CURRENT_DIR=%~dp0"
cd %CURRENT_DIR%
cd ..
call mvn clean package -DskipTests=true -Dmaven.javadoc.skip=true
cd %CURRENT_DIR%