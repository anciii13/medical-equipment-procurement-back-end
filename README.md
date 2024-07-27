# Information system for medical equipment procurement

This is a web application that serves as a centralized information system for companies procuring medical equipment, allowing private hospitals to reserve and obtain equipment. 

Administrators have access to the system and can enter reports on equipment sales. 

The system manages a large number of companies registered within the information system. 

The primary purpose of the application is to maintain records of employees, registered companies, equipment reservations and pick-up schedules, users, and their profiles.

[Project specification (Serbian version) 2023_2024.pdf](https://github.com/user-attachments/files/16399129/Specifikacija.projekta.E2-IN.ISA.2023_2024.pdf)

## Concurrent access to database resources

Part of the project is dedicated to researching and resolving issues related to concurrent access to the database. The system can serve many users simultaneously. For example, during the reservation of medical equipment, it can happen that a certain quantity of equipment is reserved at the same time, leading to a shortage in stock. 

*We aim to maintain data consistency, even when a large number of users are accessing the database simultaneously.*

To address these issues, we use transactions provided by the Spring Boot framework.

In the project, we have implemented both **optimistic** and **pessimistic** locking mechanisms.

- ***Pessimistic locking***: Utilizes SELECT ... FOR UPDATE to lock the row until the transaction is completed.
- ***Optimistic locking***: Uses a "version" column to check and update values in the database.

## Scalability (conceptual approach and possible suggestions)

The project presented an additional challenge: designing an architecture for the application that could handle a high number of concurrent users exceeding the capabilities of a single server.

The proposed architecture meets the requirements for scalability and high availability.

Scalability is crucial for maintaining performance and reliability under variable and increasing loads, ensuring that the system can grow and adapt to user and business needs.

**1. Data Partitioning Strategy:**
  - *Lazy Loading:* Use fetch = FetchType.LAZY in ORM to defer data loading until needed, improving performance and managing large datasets efficiently.

**2.Database Replication and Fault Tolerance:**
  - *Master-Slave Replication*: Implement a master-slave architecture where the master handles writes and slaves handle reads, enhancing fault tolerance and high availability.

**3. Load Balancer Strategy:**
  - *Weighted Round Robin:* Use a load balancer with a Weighted Round Robin algorithm to distribute requests based on server capacity, ensuring balanced load and preventing server overload.

**4. Monitoring Strategy:**
  - *Prometheus:* Collect and store application metrics using Prometheus for robust performance monitoring and alerting.
  - *Grafana:* Visualize Prometheus metrics with Grafana to analyze performance trends and make data-driven decisions.

## Technologies

- ***Server platform***: Java + Spring Boot

- ***Client platform***: Angular + REST services

- ***Database***: Relational Database (PostgreSQL)

For the server-side (back-end), we employed Java with the Spring Boot framework, while for the client-side (front-end), we used TypeScript, HTML, and CSS within the Angular framework.

Data storage was handled using a relational database (PostgreSQL).

## Getting started

To set up the project locally, follow these steps:
```
1. Clone the repository
2. Set up the backend using Java and Spring Boot
3. Set up the frontend using Angular
4. Configure the database using pgAdmin
```
## Contributors
- Ana Radovanović
- Kristina Zelić
- Milica Petrović
- Anja Kovačević
