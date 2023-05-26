@echo off

REM Check if the required parameters are provided
IF "%~2"=="" (
    echo Two obligatory string parameters are required: DB_Username and DB_Password.
    exit /b 1
)

REM Variables
SET DB_NAME=Museum
SET DB_USERNAME=%~1
SET DB_PASSWORD=%~2
SET DUMP_FILE=dump.sql
SET JAVAFX_LIB_PATH="C:\path\to\openjfx\lib"
SET MYSQL_CONNECTOR_JAR=mysql-connector-j-8.0.33.jar

REM Check if Java is installed
WHERE java >nul 2>&1
IF %ERRORLEVEL% NEQ 0 (
    echo Java is not installed. Installing Java...
    REM Place the installation command for Java here
)

REM Check if OpenJFX is installed
REM Replace the condition with your OpenJFX check on Windows
IF EXIST %JAVAFX_LIB_PATH% (
    echo OpenJFX is installed.
) ELSE (
    echo OpenJFX is not installed. Installing OpenJFX...
    REM Place the installation command for OpenJFX here
)

REM Check if MySQL is installed
WHERE mysql >nul 2>&1
IF %ERRORLEVEL% NEQ 0 (
    echo MySQL is not installed. Installing MySQL...
    REM Place the installation command for MySQL here
)

REM Start MySQL service if not already running
REM Replace the condition with your MySQL service status check on Windows
REM Place the command to start MySQL service here

REM Create the database
mysql -u "%DB_USERNAME%" -p"%DB_PASSWORD%" -e "CREATE DATABASE IF NOT EXISTS %DB_NAME%;"

REM Import the SQL dump
mysql -u "%DB_USERNAME%" -p"%DB_PASSWORD%" "%DB_NAME%" < "%DUMP_FILE%"

REM Compile the project
javac --module-path %JAVAFX_LIB_PATH% --add-modules javafx.controls -cp %MYSQL_CONNECTOR_JAR% *.java

REM Launch the project
java --module-path %JAVAFX_LIB_PATH% --add-modules javafx.controls -cp %MYSQL_CONNECTOR_JAR%;. Main %DB_USERNAME% %DB_PASSWORD%
