CHCP 65001
@echo off

echo.MySQL Database Initial script
echo.author godcheese
echo.Platform: Windows

@echo off
set "MYSQL_HOME=D:\dev\wamp64\bin\mysql\mysql5.7.21\bin"
set "HOST=localhost"
set "PORT=3306"
set "USER=root"
set "PASSWORD=root"
set "DATABASE=spiny"
set "DIR=%~dp0"
set "TABLES=%DIR%"
set "EXEC="%MYSQL_HOME%\mysql.exe" -h%HOST% -P%PORT% -u%USER% -p%PASSWORD% -D%DATABASE%<%TABLES%"

%EXEC%\department_table.sql


%EXEC%\data.sql

echo.finish.
pause