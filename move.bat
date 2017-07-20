@echo off
rem #############################Tomcat#########################
rem -----------------多模块maven项目编译部署脚本-----------------
rem ---------------此文件所在磁盘位置需和父项目一致---------------
rem ############################################################

:begin

rem -----------------Tomcat目录-----------------
set CATALINA_HOME=D:\WorkSpace\JAVAWorkSpace\HDTomcat\apache-tomcat-7.0.42

rem -----------------项目所在磁盘（不要更改）-----------------
set DISK=%~d0

rem -----------------项目的工作空间-----------------
set WORKSPACE_HOME=%DISK%\WorkSpace\JAVAWorkSpace

rem -----------------Web项目的父项目名称-----------------
set PROJECT_PARENT=goods

rem -----------------Web项目名称-----------------
set PROJECT_NAME=goods-server

rem -----------------Maven项目版本号-----------------
set PROJECT_VERSION=0.0.1-SNAPSHOT

:clear
set DEPLOY_PATH=%CATALINA_HOME%\webapps
if exist %DEPLOY_PATH%\%PROJECT_NAME%.war del %DEPLOY_PATH%\%PROJECT_NAME%.war
echo Has deleted %PROJECT_NAME%.war success!
if exist %DEPLOY_PATH%\%PROJECT_NAME% rmdir /s/q %DEPLOY_PATH%\%PROJECT_NAME%
echo Has deleted %PROJECT_NAME% success!
echo **************************finish clear******************************


:deploy
copy %WORKSPACE_HOME%\%PROJECT_PARENT%\%PROJECT_NAME%\target\%PROJECT_NAME%-%PROJECT_VERSION%.war %DEPLOY_PATH%\%PROJECT_NAME%.war
echo **************************finish deploy******************************

:choice
rem choice /c yn /M "start tomcat now?"
rem if errorlevel 2 goto end
rem if errorlevel 1 goto tomcat

:tomcat
rem call %CATALINA_HOME%\bin\startup.bat
rem echo **************************finish start tomcat******************************

:end
echo **************************bye******************************

pause;