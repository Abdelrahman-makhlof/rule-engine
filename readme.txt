# Payment Rule Engine

The **Payment Rule Engine** is a Spring Boot application designed
to evaluate and apply dynamic business rules on payment transactions.

## Features
- Add, update, delete rule and list all rules
- Evaluate dynamic conditions on incoming `PaymentTransaction`.
- Apply actions to update transaction fields based on defined logic.
- Business_Rule have pre-defined types (Enrichment, routing)
- Enrichment Rule: Engine apply all matched rule with respect to the priority
- Routing Rule: Engine apply the highest priority matched rule


## APIs

This application exposes REST APIs for:
- Add, update, delete rule and list all rules
- Evaluating conditional expressions against a transaction.
- Applying modification actions to a transaction and return it back after running the engine on it plus some insights of number of the applied rules with names


## Technologies Used

- Java 17+
- Spring Boot
- Spring Web
- H2 database
- Maven

## To run the application:

1. Build the project using Maven:
    mvn clean install
2. Run the application:
    mvn spring-boot:run


#####

Refer to the provided Postman collection for full API details including request formats, headers, and example use cases.
