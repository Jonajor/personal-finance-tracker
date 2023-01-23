# Personal Finance Tracker

This is a Spring Boot application for tracking personal income and expenses. It allows users to add and categorize their income and expenses, and generate reports and charts to visualize their financial data.

## Getting Started

### Prerequisites
- Java 8
- Maven

### Running the Application
1. Clone the repository

git clone https://github.com/Jonajor/personal-finance-tracker.git

2. Build the application

mvn clean install

3. Run the application

mvn spring-boot:run

4. Access the application at http://localhost:8080

## Endpoints
- POST /incomes : create a new income
- GET /incomes : retrieve a list of all incomes
- GET /incomes/{id} : retrieve a specific income by id
- PUT /incomes/{id} : update a specific income by id
- DELETE /incomes/{id} : delete a specific income by id
- POST /expenses : create a new expense
- GET /expenses : retrieve a list of all expenses
- GET /expenses/{id} : retrieve a specific expense by id
- PUT /expenses/{id} : update a specific expense by id
- DELETE /expenses/{id} : delete a specific expense by id
- GET /reports/category/{id} : retrieve a report of expenses and incomes by category id
- GET /charts/income-expense : retrieve a chart of expenses and incomes
- GET /charts/category/{id} : retrieve a chart of expenses and incomes by category id
- POST /categories : create a new category
- GET /categories : retrieve a list of all categories
- GET /categories/{id} : retrieve a specific category by id
- PUT /categories/{id} : update a specific category by id
- DELETE /categories/{id} : delete a specific category by id

## Built With
- Spring Boot
- Maven
- Thymeleaf
- Chart.js

## Authors
- [Jonathan Jorge]
