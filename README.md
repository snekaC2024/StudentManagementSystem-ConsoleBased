# 🎓 Student Management System (Console-Based with JDBC)

This is a **console-based Java application** for managing student data using **JDBC with MySQL/MariaDB**. It allows you to:
- ➕ Add new students
- 📋 View all students
- ❌ Delete a student by ID

---

## 💻 Tech Stack

- Java (JDK 17+ recommended)
- JDBC API
- MySQL or MariaDB
- XAMPP (optional for local MySQL setup)

---

## ⚙️ Setup Instructions

### 1. Clone the repo:
```bash
git clone https://github.com/your-username/StudentManagementSystem-ConsoleBased.git
cd StudentManagementSystem-ConsoleBased
```
---

### 2. Setup MySQL/MariaDB:
```bash
CREATE DATABASE studentdb;

USE studentdb;

CREATE TABLE students (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50),
    age INT
);
```
---

### 3. Compile & Run
```bash
# Compile
javac -cp ".;mysql-connector-j-9.3.0.jar" StudentManagementSystemJDBC.java

# Run
java -cp ".;mysql-connector-j-9.3.0.jar" StudentManagementSystemJDBC
```
---

### 📸 Sample Output
```bash
==== Student Management System ====
1. Add Student
2. View Students
3. Delete Student
4. Exit
```
---

### 🙋‍♀️ Author
Sneka Chandrasekaran
🔗 LinkedIn: [https://www.linkedin.com/in/your-profile](https://github.com/snekaC2024)
📂 GitHub: [https://github.com/your-username](https://github.com/snekaC2024 )

---

### 📌 License
This project is open-source and free to use.

---

