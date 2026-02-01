# Payroll System Simulation (Bordro Hesaplama Sistemi)

> [!WARNING]
> **Technical Disclaimer:** This project is a technical simulation developed to demonstrate **Object-Oriented Programming (OOP)** principles and **Software Design Patterns**. It is **not** compliant with official labor laws or current taxation legislation in Turkey. It is intended solely for software development portfolio purposes and technical evaluation.

## 📌 Project Overview
This Java-based application simulates a complex payroll management process. It parses employee data from a semi-colon delimited CSV source, applies specific business logic for different organizational roles, and exports comprehensive payroll reports.

## 🚀 Key Software Features & Architecture
The project focuses on clean code, maintainability, and architectural integrity:

* **Advanced Design Patterns:**
    * **Factory Pattern:** Centralized object creation logic in `CalisanFactory` to instantiate different employee types based on their specific titles.
    * **Builder Pattern:** Implemented within `Manager`, `Servant`, and `Worker` classes to manage complex object construction with high readability.
* **Encapsulation & Polymorphism:** All employee entities implement a core `Calisan` interface, providing a consistent contract for salary processing methods like `maasUygula()`.
* **Data Management (File I/O):**
    * **Input:** Efficiently parses structured records from `kullanicilar_unvan.csv` using `BufferedReader`.
    * **Output:** Generates formatted payroll summaries in `maas_bilgileri_base.csv` using `BufferedWriter`.
* **Robust Modeling:** Utilizes Enums for type-safe classifications and maintains a clear separation of concerns across dedicated packages: `model`, `factory`, `repository`, and `services`.

## 🛠 Tech Stack
* **Language:** Java (Optimized for JDK 23/25).
* **Data Format:** CSV (Semi-colon delimited).
* **IDE:** IntelliJ IDEA.

## 📂 Project Structure
* `model/`: Core interfaces and domain entities (`Manager`, `Worker`, `Servant`).
* `factory/`: Factory classes for dynamic object instantiation.
* `repository/`: Data access layer for CSV file parsing.
* `services/`: Business logic for report generation and data export.

## ⚙️ How It Works
1.  **Data Ingestion:** The system initializes by reading employee records from a local CSV file path.
2.  **Object Creation:** The `Repo` class utilizes the `CalisanFactory` to create the appropriate objects dynamically.
3.  **Processing:** Programmatic calculations for SSK premiums and income taxes are applied to each employee.
4.  **Reporting:** The `RaporExporter` service creates the final output file with calculated net values.
