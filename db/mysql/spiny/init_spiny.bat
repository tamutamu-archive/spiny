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

%EXEC%\api_category_table.sql
%EXEC%\api_table.sql

%EXEC%\dictionary_category_table.sql
%EXEC%\dictionary_table.sql

%EXEC%\role_authority_table.sql
%EXEC%\role_table.sql

%EXEC%\user_password_reset_table.sql
%EXEC%\user_role_table.sql
%EXEC%\user_table.sql

%EXEC%\view_menu_category_table.sql
%EXEC%\view_menu_table.sql

%EXEC%\view_page_api_table.sql
%EXEC%\view_page_category_table.sql

%EXEC%\view_page_component_api_table.sql
%EXEC%\view_page_component_table.sql

%EXEC%\view_page_table.sql

%EXEC%\data.sql

echo.finish.
pause
