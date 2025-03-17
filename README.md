# Real Estate Management System Setup Guide

This guide provides step-by-step instructions to set up and run the Real Estate Management System project using NetBeans IDE 23 on Windows 10.

## Prerequisites

- **Java Development Kit (JDK) 23**: Ensure JDK 23 is installed. You can download it from the [official Oracle website](https://www.oracle.com/java/technologies/javase-jdk23-downloads.html).

- **NetBeans IDE 23**: Download and install from the [official NetBeans website](https://netbeans.apache.org/download/index.html).

- **XAMPP**: This package includes Apache and MySQL, essential for running the database. Download it from the [official XAMPP website](https://www.apachefriends.org/index.html).

- **Git**: Required to clone the project repository. Download it from the [official Git website](https://git-scm.com/).

## Setup Instructions

1. **Install XAMPP and Start MySQL**:
   - Run the XAMPP installer and follow the on-screen instructions.
   - Open the XAMPP Control Panel and start the MySQL service. Ensure MySQL is running on the default port `3306`.

2. **Clone the Project Repository**:
   - Open Command Prompt.
   - Execute the following commands:
     ```bash
     git clone https://github.com/Sentinail/RealEstateManagementSystemMapua.git
     cd RealEstateManagementSystemMapua
     ```

3. **Import the Project into NetBeans**:
   - Launch NetBeans IDE 23.
   - Navigate to `File` > `Open Project`.
   - Select the cloned `RealEstateManagementSystemMapua` directory and click `Open Project`.

4. **Set Up the Database**:
   - Open your web browser and go to `http://localhost/phpmyadmin/`.
   - Create a new database named `real_estate_db`.
   - Import the `Project Initialization.sql` file located in the project's root directory to set up the necessary tables and data.

5. **Verify Database Configuration**:
   - The project's source code includes predefined database URL, username, and password. Ensure these credentials match your MySQL setup:
     ```java
     private static final String URL = "jdbc:mysql://localhost:3306/real_estate_db";
     private static final String USER = "root";
     private static final String PASSWORD = "";
     ```

6. **Ensure JDBC Driver is Included**:
   - The project should already include the necessary JDBC driver (e.g., `mysql-connector-java.jar`) in the `lib` directory.
   - In NetBeans, right-click on the `Libraries` node under your project.
   - Verify that the JDBC driver is listed. If it's missing:
     - Download the MySQL Connector/J from the [official MySQL website](https://dev.mysql.com/downloads/connector/j/).
     - Right-click on the `Libraries` node, select `Add JAR/Folder`, and add the downloaded JAR file.

7. **Clean and Build the Project**:
   - In NetBeans, right-click on the project node in the Projects window.
   - Select `Clean and Build`. This process cleans previous builds and compiles the source code afresh.

8. **Run the Application**:
   - After a successful build, right-click the project node and select `Run`.
   - The application should launch, connecting to the database using the provided credentials.
