# Terrier Bank

Terrier Bank is a sophisticated banking application designed to manage various banking functionalities like customer account creation, transactions, loan processing, and stock trading. 

## Design and Structure

This banking system leverages popular design patterns such as the Singleton Pattern, Factory Method, and Model View Controller (MVC). It's organized into several categories including `Account`, `Admin`, `Backend Files`, `Database`, `Loan`, `Stock`, and `Transaction` that define a host of classes and functionalities.

## Classes and Their Functions

### Account

* `Account`: An abstract class representing an account in the bank.
* `AccountDatabase`: Manages CRUD operations on the account database.
* `AccountFactory`: A factory method used during account creation.
* `CheckingAccount`, `SavingsAccount`, `SecurityAccount`: Represent different account types.

### Admin

* `AdminController`: A controller class that retrieves all the customers from the database.

### Backend Files

* `BankManager`, `Constants`, `CurrencyStrategy`, `CurrencyHandler`, `CurrencyEuro`, `CurrencyRupee`, `CurrencyUSD`, `Customer`: These classes and interfaces handle different backend operations such as currency conversion and customer data management.

### Database

* `Connector`, `Database Controller`, `Model (Interface)`: Manage database connections, update statements, and query execution.

### Loan

* `CollateralType`, `Loan`, `LoanController`, `LoanDatabase`, `LoanStatus`, `LoanType`: Define different types of collateral and loan statuses, manage loan-related data.

### Stock

* `Stock`, `StockDatabase`, `Stock position`, `StockPositionDatabase`: Handle stock-related operations and data management.

### Transaction

* `Transaction`, `TransactionAssociated`, `TransactionDatabase`, `TransactionType`: Represent any type of transaction performed by the customer, manage transaction data.

## Benefits of the Design

The MVC design pattern helps modularize the different components of each entity, ensuring the single responsibility principle of object-oriented design is upheld. This design is also extensible, as demonstrated by the `TransactionAssociated` interface and `CurrencyStrategy` interface.

## UML Diagram

Please refer to the submitted UML diagram for a visual representation of the class structure.

![UML Diagram](./uml.png)

---
For detailed information about how each class and interface operates, please refer to the source code comments and documentation. 

