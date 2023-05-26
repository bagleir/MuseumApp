#!/bin/bash

# Check if the required parameters are provided
if [ $# -lt 2 ]; then
    echo "Two obligatory string parameters are required: DB_Username and DB_Password."
    exit 1
fi

# Variables
DB_NAME="Museum"
DB_USERNAME="$1"
DB_PASSWORD="$2"
DUMP_FILE="dump.sql"
JAVAFX_LIB_PATH="/usr/share/openjfx/lib"
MYSQL_CONNECTOR_JAR="mysql-connector-j-8.0.33.jar"

# Check if Java is installed
if ! command -v java &> /dev/null; then
    echo "Java is not installed. Installing Java..."
    sudo apt-get install default-jdk
fi

# Check if OpenJFX is installed
if ! dpkg -s openjfx &> /dev/null; then
    echo "OpenJFX is not installed. Installing OpenJFX..."
    sudo apt-get install openjfx
fi

# Check if MySQL is installed
if ! command -v mysql &> /dev/null; then
    echo "MySQL is not installed. Installing MySQL..."
    sudo apt-get install mysql-server
fi

# Start MySQL service if not already running
if ! sudo service mysql status | grep "active (running)" &> /dev/null; then
    echo "Starting MySQL service..."
    sudo service mysql start
fi

# Check if the database exists
if ! mysql -u "$DB_USERNAME" -p"$DB_PASSWORD" -e "USE $DB_NAME;" &> /dev/null; then
    # Create the database
    mysql -u "$DB_USERNAME" -p"$DB_PASSWORD" -e "CREATE DATABASE IF NOT EXISTS $DB_NAME;"
    
    # Import the SQL dump
    mysql -u "$DB_USERNAME" -p"$DB_PASSWORD" "$DB_NAME" < "$DUMP_FILE"
fi

# Compile the project
javac --module-path "$JAVAFX_LIB_PATH" --add-modules javafx.controls -cp "$MYSQL_CONNECTOR_JAR" *.java

# Launch the project
java --module-path "$JAVAFX_LIB_PATH" --add-modules javafx.controls -cp "$MYSQL_CONNECTOR_JAR":. Main "$DB_USERNAME" "$DB_PASSWORD"

