# 🛡️ Life Insurance Management System (LIMS)

> A console-based Java application for managing life insurance policies, customers, and claims — backed by a MySQL database with JDBC connectivity, role-based access control, and modular OOP design.

---

## 📌 Overview

The Life Insurance Management System (LIMS) digitizes and automates the core operations of a life insurance company. It replaces manual, error-prone record-keeping with a centralized, secure, and efficient software system.

Built with **Java + MySQL + JDBC**, the system follows a modular, object-oriented architecture with four independent modules: Customer Management, Policy Management, Claims Processing, and Reporting.

---

## 🧩 Modules

| Module | Features |
|---|---|
| **Customer Management** | Add, view, update, delete customer records |
| **Policy Management** | Create, update, view, delete life insurance policies |
| **Claims Processing** | File claims, track status (Pending/Approved/Rejected/Settled) |
| **Reporting** | Total premiums, claim summaries, customer statistics |

---

## 🛠️ Technology Stack

| Component | Technology |
|---|---|
| Language | Java (JDK 8+) |
| Database | MySQL |
| DB Connectivity | JDBC (Java Database Connectivity) |
| IDE | IntelliJ IDEA / Eclipse / VS Code |
| UI | Console-based (menu-driven) |

---

## ▶️ How to Run

### 1. Set up the Database
```bash
mysql -u root -p < sql/schema.sql
```

### 2. Configure DB Connection
Update credentials in `DatabaseConnection.java` (if using JDBC mode):
```java
String url      = "jdbc:mysql://localhost:3306/insurance_management";
String username = "root";
String password = "your_password";
```

### 3. Compile and Run
```bash
cd src/main/java
javac com/lims/*.java
java com.lims.LifeInsuranceSystem
```

> **Note:** The standalone version (`LifeInsuranceSystem.java`) runs with in-memory lists and does not require MySQL — ideal for quick testing.

---

## 📊 Sample Console Output

```
==========================================
   Life Insurance Management System
==========================================

--- Main Menu ---
1. Add Customer
2. View Customers
3. Add Policy
4. View Policies
5. File Claim
6. View Claims
7. Generate Report
8. Exit
Choose an option: 7

========== SYSTEM REPORT ==========
Total Customers : 3
Total Policies  : 3
Total Claims    : 2
Total Premium Collected : Rs. 5534.00
Total Claim Amount      : Rs. 800000.00
Pending Claims          : 1
====================================
```

---

## 🗃️ Database Schema

```
customers  ──< policies ──< claims
    id            customer_id      customer_id
    name          policy_number    policy_number
    email         type             claim_amount
    phone         premium_amount   status
    address       coverage_amount  claim_date
```

---

## ✅ Test Cases

| Module | Input | Expected Output |
|---|---|---|
| Add Customer | Name=Akilan, Email=akilan@gmail.com | Customer added successfully |
| Add Policy | Policy No=POL-001, Premium=1234 | Policy created and visible in View Policies |
| File Claim | Amount=700000, Status=Pending | Claim filed, Status: PENDING |
| Generate Report | — | Total premiums, claims, customer count displayed |

---

## 🔮 Future Enhancements

- GUI using JavaFX or Swing
- Cloud database integration (AWS RDS / Azure MySQL)
- AI-based fraud detection and claim prediction
- PDF report generation
- Email notification system for policy renewals and claim status updates

---

## 📜 License

Submitted as an academic project. All rights reserved by the author.
