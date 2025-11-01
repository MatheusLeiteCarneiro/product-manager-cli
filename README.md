# Product Manager CLI 📦

**Description:** `A simple command-line interface CRUD system for a product inventory, built with Java.`

This project is a command-line inventory management system (CRUD). It was developed as a practical exercise to apply and solidify key Object-Oriented Programming (OOP) concepts in Java.

---

## ✨ Features

The system allows the user to perform the following operations:

* **Create:** Register a new product (with duplicate ID and name validation).
* **Read:** List all registered products in stock.
* **Update:**
    * Add or remove units from a product's stock (with stock validation).
    * Change the name or price of an existing product.
* **Delete:** Remove a product from the stock (with user confirmation).
* **Calculate:** Display the total stock value (sum of `price * quantity` for all items) and the subtotal value for each item.

---

## 🛠️ Technologies Used

* **Java 25** * **Eclipse IDE** * **Git & GitHub** for version control.

---

## 🚀 What I Learned (Concepts Practiced)

The main goal of this project was to master the following topics:

* **Object-Oriented Programming (OOP):**
    * **Encapsulation:** Protecting the `Product` class data (with `private` attributes) and exposing `public` methods (like `addQuantity` or `setPrice`) that contain validation logic.
    * **Constructors:** Using constructors to create valid objects.
* **Java Collections:**
    * Using `ArrayList` to store and manage the list of `Product` objects.
    * Manipulating the list (adding, removing, iterating, and searching for items).
* **Programming Logic:**
    * Creating interactive menus using `switch-case` and `do-while` loops.
    * Robust validation of all user inputs.
* **Professional Git Workflow:**
    * Creating a `.gitignore` to clean the repository.
    * Using commits for each feature or fix, with clear messages.

---

## 🏁 How to Run

1.  Open your **Terminal** (or `Git Bash` on Windows).
2.  Navigate to the directory (folder) where you want to save the project.
3.  **Copy and paste** the following command into your terminal and press **Enter**:

    ```bash
    git clone https://github.com/MatheusLeiteCarneiro/product-manager-cli.git
    ```
    *(This will create a new folder named `product-manager-cli` with all the project files.)*
 
4. Open the project in your Java IDE.
5. Locate and run the `Program.java` file (under `src/application/Program.java`).

---

Author: **Matheus Leite Carneiro**
