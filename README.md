# Insurance Management Console Application

## Overview

This is a Java-based console application designed to manage insurance contracts and claims for an insurance company. The application digitalizes the management of advisors, clients, contracts, and claims, utilizing Java 8 features such as Streams API, Lambda expressions, Method References, Optional, and Java Time API. It follows a layered architecture (Model, Enum, View, Service, DAO) and uses JDBC for database persistence.

## Features

- **Advisor Management**:
    - Add an advisor (auto-generated ID).
    - Delete an advisor by ID.
    - Search for an advisor by ID.
    - Display clients associated with an advisor by advisor ID.
- **Client Management**:
    - Add a client (auto-generated ID).
    - Delete a client by ID.
    - Search for clients by last name, sorted alphabetically (using Streams API).
    - Search for a client by ID (using Optional).
    - Display clients associated with an advisor by advisor ID (using Streams API).
- **Contract Management**:
    - Add a contract (auto-generated ID, linked to a client by client ID).
    - Display contract details by ID (using Optional).
    - Delete a contract by ID.
    - Display contracts subscribed by a client by client ID.
- **Claim Management**:
    - Add a claim (auto-generated ID, linked to a contract by contract ID).
    - Delete a claim by ID.
    - Calculate total claim costs for a client by client ID (using Streams API).
    - Search for a claim by ID (using Optional).
    - Display claims for a contract by contract ID (using Streams API).
    - Display claims sorted by amount in descending order (using Streams API).
    - Display claims for a client by client ID (using Streams API).
    - Display claims before a specified date (using Streams API).
    - Display claims exceeding a specified amount (using Streams API).

## Technical Specifications

- **Language**: Java 8
- **Architecture**: Layered (Model, Enum, View, Service, DAO)
- **Database**: JDBC for persistence
- **Key Features**:
    - Encapsulation with private properties and getters/setters.
    - Use of Streams API for collection processing.
    - Lambda expressions and Method References for cleaner code.
    - Optional for null safety.
    - Java Time API for date management.
- **Dependencies**:
    - JDBC driver (MySQL).
    - No external frameworks required.

## Prerequisites

- Java Development Kit (JDK) 8
- A relational database (MySQL) with JDBC driver
- Git for version control

## Installation

1. **Clone the Repository**:

   ```bash
   git clone https://github.com/ayoub-ahnaou/assurance-contracts.git
   ```

2. Alternatively, compile the Java files manually:

   ```bash
   javac -d bin src/**/*.java
   ```

## Usage

1. Launch the application to access the main menu.
2. Navigate through the console menu to manage advisors, clients, contracts, and claims.
3. Follow the prompts to perform CRUD operations or filter/sort data as needed.
4. Example commands:
    - Add a client: Select "Client Management" &gt; "Add a client" and enter the required details.
    - View claims by contract ID: Select "Claim Management" &gt; "Display claims by contract ID" and provide the contract ID.

## Project Structure

```
insurance-management-app/
├── src/
│   ├── main/
│   │   ├── java.com.ismail.insurancemanagement/
│   │   │   ├── config/ 
│   │   │   ├── controller/
│   │   │   ├── model/         
│   │   │   ├── enum/           
│   │   │   ├── view/           
│   │   │   ├── service/       
│   │   │   ├── dao/
│   │   │   ├── Main.java
├── README.md                   # This file
├── insurance-management-app.jar # Executable JAR
```

## Development Notes

- The application adheres to Java naming conventions (CamelCase).
- Code is well-commented for clarity.
- Git commits are regular and descriptive, reflecting the development progress.
- The Service layer contains all business logic, with Controllers calling Service methods and Views handling output.

## Troubleshooting

- **Database Connection Issues**: Ensure the JDBC driver is included and the database connection details are correct.
- **Missing Data**: Verify that the database schema is correctly set up using the provided SQL scripts.
- **Java Version Errors**: Confirm that JDK 8 is used, as the application relies on Java 8 features