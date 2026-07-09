# Level 1
# Task 1 - Number Grid Search

## Objective
Develop a Java program to create a 3×3 number grid using a two-dimensional array and search for a user-specified number.

## Features
- Accepts 9 numbers from the user.
- Displays the 3×3 grid.
- Searches for a given number.
- Displays the row and column position if found.
- Displays "Number Not Found" if the number does not exist.

## Concepts Used
- Java Arrays (2D Array)
- Nested Loops
- Methods (Functions)
- User Input (Scanner)
- Conditional Statements

## Time Complexity
- **O(n²)**

## Space Complexity
- **O(n²)**


# Task 2 - Temperature Converter

## Objective
Develop a Java application to convert temperature between Celsius and Fahrenheit.

## Features
- Celsius to Fahrenheit conversion.
- Fahrenheit to Celsius conversion.
- Menu-driven program.
- User-friendly console interface.
- Accurate temperature conversion using standard formulas.

## Formula Used

Fahrenheit = (Celsius × 9 / 5) + 32

Celsius = (Fahrenheit - 32) × 5 / 9

## Concepts Used
- Methods (Functions)
- Conditional Statements
- Scanner Class
- Arithmetic Operations
- Menu-Driven Programming

## Time Complexity
- **O(1)**

## Space Complexity
- **O(1)**

<<<<<<< HEAD

# Task 3 - Student Grade Average

## Objective
Develop a Java program to calculate the average marks of a student and determine the corresponding grade based on the average score.

## Features
- Accepts the number of subjects from the user.
- Takes marks for each subject.
- Validates user input.
- Calculates the average marks.
- Determines the grade based on the average.
- Displays the average and final grade.

## Grade Criteria

| Average Marks | Grade |
|--------------:|:-----:|
| 90 - 100      | A     |
| 80 - 89       | B     |
| 70 - 79       | C     |
| 60 - 69       | D     |
| Below 60      | F     |

## Concepts Used
- Arrays
- Methods (Functions)
- Loops
- Conditional Statements
- Input Validation
- Scanner Class
=======
# Task 4 - Secure Password Generator

## Objective
Develop a Java application to generate secure and customizable passwords based on user preferences.

## Features
- Accepts the desired password length.
- Allows users to include:
  - Uppercase letters
  - Lowercase letters
  - Numbers
  - Special characters
- Validates user inputs.
- Generates a random and secure password using the `SecureRandom` class.
- Ensures at least one character type is selected.

## Concepts Used
- Methods (Functions)
- StringBuilder
- Conditional Statements
- Input Validation
- Scanner Class
- SecureRandom
- Boolean Variables


## Time Complexity
- **O(n)**

## Space Complexity
- **O(n)**

=======

# Level 2

# Task 1 - ❌⭕ Two-Player Tic-Tac-Toe

A fully interactive **two-player console-based Tic-Tac-Toe game** built in Java. Players take turns placing their marks on a 3×3 grid — featuring complete input validation, win detection across all 8 combinations, and draw handling.

---

## 📌 About the Project

This project was developed as part of a **Java Development Internship (Level 2)**. It demonstrates game logic design, conditional branching, input validation, and clean console-based UI in Java.

---

## ✨ Features

- 🎮 Two-player mode — Player X vs Player O
- 🔢 Position-based input (1–9 grid mapping)
- ✅ Input validation
  - Rejects numbers outside 1–9
  - Rejects non-numeric input
  - Rejects already-occupied positions
- 🏆 Win detection for all 8 combinations (3 rows, 3 columns, 2 diagonals)
- 🤝 Draw detection when all 9 cells are filled
- 🔁 Smooth player switching after every valid move

---

## 🛠️ Tech Stack

| Tool | Details |
|------|---------|
| Language | Java (JDK 8+) |
| IDE | IntelliJ IDEA / Eclipse / VS Code |
| Type | Console Application |

---

## ▶️ How to Run

```bash
# Step 1: Compile
javac Task1_TicTacToe.java

# Step 2: Run
java Task1_TicTacToe
```

**Sample Output:**
```
=============================
   Welcome to Tic-Tac-Toe!
=============================
 Player 1 → X  |  Player 2 → O

 1 | 2 | 3
---+---+---
 4 | 5 | 6
---+---+---
 7 | 8 | 9

Player X, choose position (1-9): 5

 1 | 2 | 3
---+---+---
 4 | X | 6
---+---+---
 7 | 8 | 9
```

---

## 🧠 Game Logic

```
Start Game
    ↓
Display Board
    ↓
Player enters position (1–9)
    ↓
Validate Input → Invalid? → Ask Again
    ↓
Place Mark (X or O)
    ↓
Check Win? → YES → Announce Winner → End
    ↓
Check Draw? → YES → Announce Draw → End
    ↓
Switch Player → Loop Back
```

---

## 📊 Complexity Analysis

| Operation | Time Complexity | Space Complexity | Reason |
|---|---|---|---|
| `displayBoard()` | O(1) | O(1) | Always prints 9 fixed cells |
| `checkWin()` | O(1) | O(1) | Checks exactly 8 hard-coded combinations |
| `checkDraw()` | O(1) | O(1) | Loops over exactly 9 cells always |
| Full game | O(1) | O(1) | Max 9 moves, board is constant size |

**Why O(1)?**
The board is always exactly **3×3 = 9 cells** — it never grows. Since the input size is fixed and does not scale, every operation runs in constant time. **O(1) is the best and only possible complexity here.** ✅

---

## 📚 Skills Demonstrated

- Game state management using char arrays
- Conditional logic and nested branching
- Console input handling and validation using Scanner
- Modular code design with static helper methods

---



# Task 2 - 🔐 Password Strength Analyzer

A Java console application that evaluates the **strength of any password** against 5 security rules — providing a score, a strength rating, and specific suggestions to improve weak passwords.

---

## 📌 About the Project

This project was developed as part of a **Java Development Internship (Level 2)**. It demonstrates validation logic, character-level analysis, and meaningful user feedback in a clean Java program.

---

## ✨ Features

- 🔍 Validates password against **5 security rules**
- 📊 Assigns a **score out of 5**
- 🚦 Three-tier strength rating — **WEAK / MEDIUM / STRONG**
- 💡 Displays **specific suggestions** for each failed rule
- 🙈 Masks the password with `*` during display for privacy

---

## 🛡️ Validation Rules

| # | Rule | Requirement |
|---|------|-------------|
| 1 | Length | At least 8 characters |
| 2 | Uppercase | At least one A–Z |
| 3 | Lowercase | At least one a–z |
| 4 | Digit | At least one 0–9 |
| 5 | Special Character | At least one of `!@#$%^&*()...` |

---

## 🚦 Strength Ratings

| Score | Rating |
|---|---|
| 5 / 5 | 🟢 STRONG — Great password! |
| 3–4 / 5 | 🟡 MEDIUM — Can be improved |
| 0–2 / 5 | 🔴 WEAK — Please change it |

---

## 🛠️ Tech Stack

| Tool | Details |
|------|---------|
| Language | Java (JDK 8+) |
| IDE | IntelliJ IDEA / Eclipse / VS Code |
| Type | Console Application |

---

## ▶️ How to Run

```bash
# Step 1: Compile
javac Task2_PasswordStrength.java

# Step 2: Run
java Task2_PasswordStrength
```

**Sample Output:**
```
====================================
     Password Strength Analyzer
====================================
Enter your password: MyPass@123

====================================
Password : **********
Length   : 10 characters
Score    : 5 / 5
Strength : STRONG - Great password!
All rules passed! Your password is strong.
====================================
```

```
Enter your password: hello

====================================
Password : *****
Length   : 5 characters
Score    : 1 / 5
Strength : WEAK - Please change it.

Suggestions to improve:
  - Use at least 8 characters
  - Add at least one uppercase letter (A-Z)
  - Add at least one number (0-9)
  - Add at least one special character (!@#$...)
====================================
```

---

## 📊 Complexity Analysis

| Operation | Time Complexity | Space Complexity | Reason |
|---|---|---|---|
| Each rule check | O(n) | O(1) | Iterates through all n characters |
| Full analysis (5 rules) | O(n) | O(n) | 5 × O(n) passes = O(n) |
| Password masking | O(n) | O(n) | `String.repeat()` builds a new string |

**n = number of characters in the password**

**Why O(n) is the best complexity here?**
To validate a password, we **must examine every character at least once**. There is no shortcut — skipping even one character could miss a rule violation. So O(n) is the **theoretically optimal** lower bound. ✅

---

## 📚 Skills Demonstrated

- Character-level string analysis using `toCharArray()`
- Boolean flag logic for rule checking
- `StringBuilder` for dynamic feedback generation
- Clean user feedback and structured console output

---


# Task 3 -🔒 File Encryptor & Decryptor

A Java console application that **encrypts and decrypts text files** using the **Caesar Cipher** algorithm. Letters are shifted by a fixed key, while digits, spaces, and special characters remain unchanged — making it easy to secure and restore plain text files.

---

## 📌 About the Project

This project was developed as part of a **Java Development Internship (Level 2)**. It demonstrates file I/O operations, algorithm implementation, and exception handling in Java.

---

## ✨ Features

- 🔐 **Encrypt** any `.txt` file using Caesar Cipher (shift key = 3)
- 🔓 **Decrypt** previously encrypted files back to original content
- 📄 Processes files **line by line** — memory efficient, no full file load
- ✅ Handles uppercase and lowercase letters separately
- 🔢 Digits, spaces, and symbols are **left unchanged**
- ⚠️ Proper error handling for missing or inaccessible files

---

## 🧮 Algorithm — Caesar Cipher

Each letter in the file is shifted by **SHIFT = 3** positions in the alphabet:

| Original | Encrypted (Shift 3) |
|---|---|
| A | D |
| Z | C (wraps around) |
| a | d |
| Hello! | Khoor! |

**Decryption** reverses the shift using `26 - SHIFT = 23`:
```
Encrypt: (char - base + shift) % 26 + base
Decrypt: (char - base + 23)   % 26 + base
```

---

## 🛠️ Tech Stack

| Tool | Details |
|------|---------|
| Language | Java (JDK 8+) |
| File I/O | `BufferedReader`, `BufferedWriter`, `FileReader`, `FileWriter` |
| IDE | IntelliJ IDEA / Eclipse / VS Code |
| Type | Console Application |

---

## ▶️ How to Run

```bash
# Step 1: Compile
javac Task3_FileEncryptor.java

# Step 2: Run
java Task3_FileEncryptor
```

**Sample Interaction:**
```
========================================
     File Encryptor / Decryptor
     Algorithm: Caesar Cipher (Shift=3)
========================================
1. Encrypt a file
2. Decrypt a file
Choose option (1 or 2): 1
Enter input file path  : message.txt
Enter output file path : message_encrypted.txt

File encrypted successfully!
Encrypted file saved at: message_encrypted.txt
```

**Before encryption (`message.txt`):**
```
Hello World!
Java is fun.
```

**After encryption (`message_encrypted.txt`):**
```
Khoor Zruog!
Mdyd lv ixq.
```

---

## 📊 Complexity Analysis

| Operation | Time Complexity | Space Complexity | Reason |
|---|---|---|---|
| `caesarShift()` per char | O(1) | O(1) | Single math operation per character |
| `encryptFile()` / `decryptFile()` | O(n) | O(L) | n = total chars; L = max line length |

**n = total number of characters in the file**
**L = length of the longest line (only one line held in memory at a time)**

**Why O(n)?**
Every character must be read and transformed exactly once. There is no way to encrypt/decrypt a file faster than O(n) since we must touch every character. **O(n) is the optimal complexity.** ✅

**Why O(L) space and not O(n)?**
We use `BufferedReader` to process **one line at a time**, so only the current line (max length L) lives in memory — not the entire file. This makes the program scalable for large files.


---

## ⚙️ Customization

To change the cipher key, update this line in the source:
```java
static final int SHIFT = 3;  // Change to any value between 1 and 25
```

---

## 📚 Skills Demonstrated

- File handling with `BufferedReader` and `BufferedWriter`
- Caesar Cipher algorithm implementation
- Exception handling (`FileNotFoundException`, `IOException`)
- Memory-efficient line-by-line file processing

---

# Task 4 - 💰 Personal Expense Tracker

A Java console application that helps you **track daily expenses with persistent file storage**. Add expenses by category, view all records, check total spending, and filter by category — all saved to a local text file that persists across sessions.

---

## 📌 About the Project

This project was developed as part of a **Java Development Internship (Level 2)**. It demonstrates file-based data persistence, menu-driven interaction, and structured data handling in Java — without any external database.

---

## ✨ Features

- ➕ **Add Expense** — Save category, description, and amount to file
- 📋 **View All Expenses** — Displays all records in a formatted table
- 💵 **View Total Spending** — Calculates and shows total amount spent
- 🔍 **Filter by Category** — View and total expenses for a specific category
- 💾 **Persistent Storage** — All data saved to `expenses.txt` (survives app restart)
- ✅ Input validation for amount and menu choice
- 🔁 Loop-based menu until user exits

---

## 🗂️ Supported Categories

| Category | Examples |
|---|---|
| Food | Lunch, Dinner, Groceries |
| Travel | Cab, Train ticket, Fuel |
| Bills | Electricity, Internet, Rent |
| Shopping | Clothes, Electronics |
| Other | Medicines, Books, Miscellaneous |

---

## 🛠️ Tech Stack

| Tool | Details |
|------|---------|
| Language | Java (JDK 8+) |
| Storage | File-based (`expenses.txt`) |
| File I/O | `BufferedReader`, `BufferedWriter`, `FileWriter (append mode)` |
| IDE | IntelliJ IDEA / Eclipse / VS Code |
| Type | Console Application |

---

## ▶️ How to Run

```bash
# Step 1: Compile
javac Task4_ExpenseTracker.java

# Step 2: Run
java Task4_ExpenseTracker
```

**Sample Interaction:**
```
========================================
       Personal Expense Tracker
========================================

--- MENU ---
1. Add Expense
2. View All Expenses
3. View Total Spending
4. View by Category
5. Exit
Choose option: 1

Category (Food / Travel / Bills / Shopping / Other): Food
Description: Lunch at canteen
Amount (Rs): 85
Expense saved: Food - Lunch at canteen - Rs 85.00
```

```
Choose option: 2

--- All Expenses ---
1   Food         Lunch at canteen          Rs 85.00
2   Travel       Auto to college           Rs 40.00
3   Bills        Internet recharge         Rs 299.00
```

```
Choose option: 3

--- Spending Summary ---
Total Expenses : 3
Total Amount   : Rs 424.00
```

---

## 💾 Data Storage Format

Each expense is saved as one line in `expenses.txt`:
```
Category|Description|Amount
Food|Lunch at canteen|85.00
Travel|Auto to college|40.00
Bills|Internet recharge|299.00
```

The file is opened in **append mode** — existing data is never overwritten.

---

## 📊 Complexity Analysis

| Operation | Time Complexity | Space Complexity | Reason |
|---|---|---|---|
| `addExpense()` | O(1) | O(1) | Appends exactly one line to file |
| `viewAllExpenses()` | O(n) | O(1) | Reads all n records, one line at a time |
| `viewTotal()` | O(n) | O(1) | Scans all n records to sum amounts |
| `viewByCategory()` | O(n) | O(1) | Scans all n records for matches |

**n = number of expense records stored in the file**
---

## 📚 Skills Demonstrated

- File append mode using `FileWriter(path, true)`
- Line-by-line file reading with `BufferedReader`
- String parsing with `split()` for structured records
- Exception handling (`FileNotFoundException`, `IOException`)
- `printf` for aligned tabular console output

---


# Level 3

# Task 1 -  Contact Management System 

## 📌 Project Overview

The **Contact Management System** is a console-based Java application that allows users to efficiently manage personal or business contacts. It provides essential CRUD (Create, Read, Update, Delete) operations along with input validation to ensure data accuracy and reliability.

This project demonstrates the practical application of **Object-Oriented Programming (OOP)** concepts, Java Collections, user input handling, and data validation.

---

## 🚀 Features

* Add a new contact
* View all saved contacts
* Search a contact using Contact ID
* Update existing contact details
* Delete a contact
* Auto-generated unique Contact ID
* Input validation for:

  * Contact Name
  * Phone Number
  * Email Address
* User-friendly menu-driven interface
* Handles invalid user inputs gracefully

---

## 🛠️ Technologies Used

* Java
* Eclipse IDE (or any Java IDE)
* Java Collections (`ArrayList`)
* Object-Oriented Programming (OOP)

---

## 📖 Functionalities

### 1. Add Contact

Allows the user to create a new contact by entering:

* Name
* Phone Number
* Email Address

Each contact is assigned a unique Contact ID automatically.

---

### 2. View Contacts

Displays all stored contacts in a readable format.

Information displayed:

* Contact ID
* Name
* Phone Number
* Email Address

---

### 3. Search Contact

Searches for a contact using its unique Contact ID.

Displays:

* Contact information if found
* "Contact not found" message if the ID does not exist

---

### 4. Update Contact

Allows modification of an existing contact by entering its Contact ID.

Users can update:

* Name
* Phone Number
* Email Address

---

### 5. Delete Contact

Deletes a contact permanently using the Contact ID.

Displays a success message after successful deletion.

---

## ✅ Input Validation

The application validates user inputs before saving contact details.

### Name Validation

* Only alphabets and spaces are allowed
* Minimum 2 characters
* Numbers and special characters are not accepted

**Examples**

Valid:

* Aarthi
* Ravi Kumar

Invalid:

* 12345
* Aarthi123
* @John

---

### Phone Number Validation

Rules:

* Exactly 10 digits
* Must start with digits 6–9
* Alphabets and special characters are not allowed

**Examples**

Valid:

* 9876543210
* 8123456789

Invalid:

* 1234567890
* 987654321
* 98765432101
* 98AB567890

---

### Email Validation

Accepts standard email format.

**Examples**

Valid:

* [aarthi@gmail.com](mailto:aarthi@gmail.com)
* [user123@yahoo.com](mailto:user123@yahoo.com)
* [abc@gmail.co.in](mailto:abc@gmail.co.in)

Invalid:

* gmail.com
* abc@
* @gmail.com
* abc@gmail

---

## 🧠 OOP Concepts Implemented

* Classes and Objects
* Encapsulation
* Constructors
* Getters and Setters
* Method Calling
* Object Manipulation

---

## 📚 Java Concepts Used

* ArrayList
* Scanner
* Loops
* Conditional Statements
* Methods
* Regular Expressions (Regex)
* String Methods
* Exception Prevention using Input Validation

---

## ▶️ How to Run

1. Clone this repository.
2. Open the project in Eclipse or any Java IDE.
3. Compile the Java files.
4. Run the `ContactManagementSystem` class.
5. Use the menu options to manage contacts.

---

## 💡 Learning Outcomes

Through this project, I gained hands-on experience in:

* Designing a menu-driven Java application
* Applying Object-Oriented Programming concepts
* Managing dynamic data using ArrayList
* Implementing CRUD operations
* Validating user input using Regular Expressions (Regex)
* Writing clean, modular, and reusable Java code
* Improving console-based application development skills

---
# Task 2 - Student Record Management System

A Java console-based application that manages student records using Object-Oriented Programming (OOP) principles and File Handling. The system allows users to add, store, and retrieve student information while ensuring data validation and persistence through a text file.

---

## 📌 Project Overview

The Student Record Management System is designed to simplify student data management in a console environment. The application stores student records permanently using a text file, preventing data loss after the program exits.

The project demonstrates the implementation of Java OOP concepts, collections, file handling, input validation, and exception handling.

---

## ✨ Features

- Add new student records
- View all student records
- Store data permanently using File Handling
- Load saved records automatically when the application starts
- Prevent duplicate Roll Numbers
- Accept marks for multiple subjects
- Automatically calculate:
  - Total Marks
  - Average Marks
- Validate student name
- Validate subject count
- Validate marks (0–100)
- User-friendly menu-driven interface
- Handles invalid user input gracefully

---

## 🛠 Technologies Used

- Java
- Object-Oriented Programming (OOP)
- File Handling
- Collections (ArrayList)
- Exception Handling
- Scanner Class

---

## 📖 Concepts Implemented

### Object-Oriented Programming

- Classes
- Objects
- Constructors
- Encapsulation
- Method Overriding (`toString()`)

### Java Collections

- ArrayList

### File Handling

- File
- FileReader
- FileWriter
- BufferedReader
- PrintWriter

### Exception Handling

- IOException
- Input Validation

### Java Utilities

- Scanner
- String Methods
- Regular Expressions

---

## 📋 Menu

```
========== STUDENT RECORD SYSTEM ==========

1. Add Student

2. View Students

3. Exit
```

---

## ✔ Input Validation

The application performs several validations to ensure accurate data entry.

### Roll Number

- Must be an integer
- Duplicate Roll Numbers are not allowed

### Student Name

- Cannot be empty
- Accepts only alphabets and spaces
- Rejects numbers and special characters

### Subject Count

- Must be greater than zero

### Marks

- Accepts only numeric values
- Range must be between 0 and 100

---

## 📊 Student Details Stored

Each student record contains:

- Roll Number
- Student Name
- Total Subjects
- Total Marks
- Average Marks

---

## 💾 Data Storage

All student records are stored in a text file.

```
students.txt
```

Example format:

```
101,Aarthi,5,438.0,87.6
102,Rahul,4,356.0,89.0
```

The application automatically loads these records when it starts.

---

## ⚙ Working Process

1. Application starts
2. Existing student records are loaded
3. User selects an option from the menu
4. Student details are validated
5. Total marks and average are calculated
6. Records are saved to the text file
7. User can view all stored records
8. Data remains available after restarting the application

---

## 🧪 Error Handling

The project handles:

- Invalid menu choices
- Invalid Roll Numbers
- Duplicate Roll Numbers
- Empty names
- Invalid student names
- Invalid subject count
- Invalid marks
- File read/write errors

---

## 📚 Learning Outcomes

This project helped in understanding:

- Java Object-Oriented Programming
- Encapsulation
- Constructors
- Collections
- File Handling
- Data Persistence
- Input Validation
- Exception Handling
- Console-Based Application Development

---

# Task 3 - Library Management System (Core Java)

## 📖 Project Overview

The **Library Management System** is a menu-driven console application developed using **Core Java**. It allows users to manage a collection of books by adding new books, viewing available books, issuing books, and returning issued books.

This project demonstrates the practical implementation of **Object-Oriented Programming (OOP)** concepts, input validation, collections, and menu-driven application development.

---

## 🚀 Features

* 📚 Add new books
* 📋 Display all books
* 📖 Issue a book
* 🔄 Return a book
* ✅ Auto-generated Book ID
* ✅ Prevent duplicate book entries
* ✅ Book title validation
* ✅ Author name validation
* ✅ Empty input validation
* ✅ Invalid menu choice handling
* ✅ Book availability status (Available / Issued)

---

## 🛠 Technologies Used

* Java
* Object-Oriented Programming (OOP)
* Java Collections (`ArrayList`)
* Scanner Class


---

## 🎯 Functionalities

### 1. Add Book

Users can add a new book by entering:

* Book Title
* Author Name

The system automatically generates a unique Book ID.

Validation includes:

* Book title cannot be empty
* Author name cannot be empty
* Invalid characters are rejected
* Duplicate books are not allowed

---

### 2. Display Books

Displays all books stored in the library with:

* Book ID
* Book Title
* Author Name
* Current Status

Example Status:

* Available
* Issued

---

### 3. Issue Book

Allows users to issue a book using its Book ID.

The system checks:

* Book ID exists
* Book is available
* Prevents issuing an already issued book

---

### 4. Return Book

Allows users to return a previously issued book.

The system checks:

* Book ID exists
* Book has already been issued
* Prevents returning books that are already available

---

## ✔ Input Validation

The application performs several validations to ensure data integrity.

### Book Title Validation

* Cannot be empty
* Accepts meaningful titles
* Supports letters, numbers, spaces, apostrophes, hyphens, colons, and parentheses

Examples:

* Java Programming
* Head First Java
* Clean Code
* Data Structures

---

### Author Name Validation

* Cannot be empty
* Accepts only alphabets and spaces

Examples:

* James Gosling
* Robert Martin
* Herbert Schildt

---

### Duplicate Book Detection

The application prevents adding the same book more than once.

Duplicate checking is performed using:

* Book Title
* Author Name

If both match an existing record, the book is rejected.

---

## 🧠 OOP Concepts Used

* Class
* Object
* Encapsulation
* Constructors
* Methods
* Method Invocation
* Object Creation

---

## 📚 Java Concepts Used

* ArrayList
* Scanner
* Loops
* Conditional Statements
* Methods
* Regular Expressions (Regex)
* Exception-safe input handling

---

## 🔄 Program Workflow

1. Start the application
2. Display the main menu
3. Select an option
4. Perform the requested operation
5. Return to the menu
6. Exit the application

---

## 💡 Learning Outcomes

This project helped strengthen knowledge in:

* Object-Oriented Programming
* Java Collections Framework
* Input Validation
* Menu-Driven Application Development
* Data Management using ArrayList
* Clean Code Practices
* Console-Based Application Design

---


## ▶️ How to Run

1. Clone the repository.

2. Open the project in your preferred Java IDE (Eclipse, IntelliJ IDEA, or VS Code).

3. Compile the project.

4. Run the `LibraryManagementSystem` class.

5. Use the menu to manage library operations.

---


# Task 4 - Timestamped Log File Generator

## Overview

The **Timestamped Log File Generator** is a simple Java console application that records log messages along with the current date, time, and log level. It demonstrates Java file handling, date and time APIs, exception handling, user input validation, and structured logging.

The application appends each log entry to a text file (`log.txt`) instead of overwriting existing data, making it suitable for maintaining a continuous log history.

---

## Features

* Records log messages with the current timestamp.
* Supports log levels:

  * INFO
  * WARNING
  * ERROR
* Validates user input.
* Prevents empty log messages.
* Rejects invalid log levels.
* Appends new log entries without deleting previous records.
* Automatically creates the log file if it does not exist.
* Uses Java's modern Date and Time API.

---

## Technologies Used

* Java
* File Handling (`FileWriter`, `PrintWriter`)
* Exception Handling
* Scanner Class
* LocalDateTime
* DateTimeFormatter

---

## How It Works

1. The user enters a log level (`INFO`, `WARNING`, or `ERROR`).
2. The application validates the entered log level.
3. The user enters a log message.
4. The application checks that the message is not empty.
5. The current date and time are generated automatically.
6. The log entry is written to `log.txt`.
7. If the file already contains logs, the new entry is appended.

---

## Log Entry Format

```
[YYYY-MM-DD HH:MM:SS] [LOG_LEVEL] Log Message
```

Example:

```
[2026-07-05 15:20:15] [INFO] User logged in successfully
```

---

## Input Validation

The application validates the following:

* Log level must be one of:

  * INFO
  * WARNING
  * ERROR
* Log message cannot be empty.

If invalid input is provided, the application displays an appropriate error message and exits safely.

---

## Concepts Demonstrated

* Object-Oriented Programming
* File Handling
* Exception Handling
* User Input Validation
* Date and Time API
* String Manipulation
* Console-Based Application Development

---

## Learning Outcomes

This project helps in understanding:

* Writing data to text files
* Appending data to existing files
* Using Java's `LocalDateTime` and `DateTimeFormatter`
* Handling exceptions using `try-with-resources`
* Designing structured log records
* Validating user input before processing

---

# Level 4

# Task 1 - Automated file organizer

## Overview

The **File Organizer** is a Java console application that automatically organizes files into categorized folders based on their file extensions. It helps keep directories clean and well-structured by moving files into folders such as **Images**, **Documents**, **Videos**, **Audio**, **Archives**, **Code**, and **Others**.

This project demonstrates practical file management using Java's File Handling and NIO APIs, making it an excellent beginner-friendly real-world automation project.

---

## Features

* Organizes files automatically based on file extensions.
* Creates category folders if they do not already exist.
* Moves files into their respective folders.
* Handles multiple file types.
* Prevents application crashes through exception handling.
* Validates the provided folder path.
* Displays the status of each moved file.
* Uses Java NIO for efficient file movement.

---

## Supported File Categories

| Category  | Supported Extensions            |
| --------- | ------------------------------- |
| Images    | `.jpg`, `.jpeg`, `.png`, `.gif` |
| Documents | `.pdf`, `.doc`, `.docx`, `.txt` |
| Videos    | `.mp4`, `.avi`, `.mkv`, `.mov`  |
| Audio     | `.mp3`, `.wav`, `.aac`          |
| Archives  | `.zip`, `.rar`, `.7z`           |
| Code      | `.java`, `.cpp`, `.py`, `.js`   |
| Others    | Any unsupported file extension  |

---

## Technologies Used

* Java
* Java File Handling (`java.io.File`)
* Java NIO (`Files.move`)
* Exception Handling
* Scanner Class
* Conditional Statements

---

## How It Works

1. The user enters the path of the folder to organize.
2. The application validates whether the folder exists.
3. All files in the selected folder are scanned.
4. The extension of each file is identified.
5. A category is determined based on the file extension.
6. If the category folder does not exist, it is created automatically.
7. The file is moved into its corresponding category folder.
8. The application displays the status of every file that is processed.

---

## Folder Structure Example

### Before Organizing

```text
Downloads/
│── photo.jpg
│── report.pdf
│── movie.mp4
│── music.mp3
│── project.java
│── archive.zip
│── notes.txt
│── unknown.xyz
```

### After Organizing

```text
Downloads/
│
├── Images/
│     └── photo.jpg
│
├── Documents/
│     ├── report.pdf
│     └── notes.txt
│
├── Videos/
│     └── movie.mp4
│
├── Audio/
│     └── music.mp3
│
├── Archives/
│     └── archive.zip
│
├── Code/
│     └── project.java
│
└── Others/
      └── unknown.xyz
```

---

## Input Validation

The application checks for the following conditions before organizing files:

* Folder path cannot be empty.
* The specified folder must exist.
* The specified path must be a valid directory.
* Displays an appropriate message if no files are found.
* Handles file movement errors gracefully.

---

## Concepts Demonstrated

* File Handling
* Java NIO File Operations
* Directory Creation
* File Extension Extraction
* Conditional Logic
* Exception Handling
* User Input Validation
* Console-Based Application Development

---

## Learning Outcomes

This project helps in understanding:

* Working with files and directories in Java.
* Using `Files.move()` to relocate files.
* Automatically creating folders.
* Identifying file types using extensions.
* Building simple file automation utilities.
* Writing clean and reusable methods.

---

# Task 2 -Daily Task Manager

## Overview

The **Daily Task Manager** is a Java console-based application that helps users manage their daily tasks efficiently. It allows users to add, view, and delete tasks while storing them permanently in a text file. The application automatically loads previously saved tasks when it starts, ensuring that task data is preserved between program executions.

This project demonstrates practical use of Java collections, file handling, user input validation, and menu-driven application development.

---

## Features

* Add new daily tasks.
* View all saved tasks.
* Delete tasks by selecting their task number.
* Automatically saves tasks to a text file.
* Loads existing tasks when the application starts.
* Validates user input to prevent invalid operations.
* Displays appropriate success and error messages.
* Simple and user-friendly menu-driven interface.

---

## Technologies Used

* Java
* Java Collections (`ArrayList`)
* File Handling (`FileReader`, `FileWriter`, `BufferedReader`, `PrintWriter`)
* Exception Handling
* Scanner Class
* Console-Based User Interface

---

## How It Works

1. The application starts by loading previously saved tasks from `tasks.txt`.
2. A menu is displayed with available operations.
3. The user selects one of the following options:

   * Add Task
   * View Tasks
   * Delete Task
   * Exit
4. Any changes made to the task list are automatically saved to the file.
5. When the application is restarted, all previously saved tasks are loaded again.

---

## Menu Options

```text
Daily Task Manager

1. Add Task
2. View Tasks
3. Delete Task
4. Exit
```

---

## Task Storage

Tasks are stored in a simple text file named:

```text
tasks.txt
```

Each line in the file represents one task.

Example:

```text
Complete Java assignment
Practice SQL queries
Prepare for interview
```

---

## Input Validation

The application performs several validations:

* Task cannot be empty.
* Menu choice must be a valid number.
* Task number must exist before deletion.
* Handles invalid numeric and text inputs gracefully.
* Displays appropriate error messages without crashing the application.

---

## Concepts Demonstrated

* Object-Oriented Programming (OOP)
* Java Collections (`ArrayList`)
* File Handling
* Persistent Data Storage
* Exception Handling
* User Input Validation
* Menu-Driven Programming
* Console Application Development

---

## Learning Outcomes

This project helps in understanding:

* Reading data from text files.
* Writing data to files.
* Using `ArrayList` for dynamic data storage.
* Creating reusable methods.
* Implementing CRUD operations (Create, Read, Delete).
* Building interactive console applications.
* Persisting application data between executions.



# Task 3 - Student Report Generator

## Overview

The **Student Report Generator** is a Java console-based application that generates a student's academic report by calculating the total marks, average percentage, and grade based on marks entered by the user. The application includes robust input validation to ensure meaningful student names, valid subject counts, valid marks, and prevents duplicate student names during program execution.

This project demonstrates fundamental Java programming concepts, including arrays, methods, loops, conditional statements, collections, and user input validation through a practical real-world application.

---

## Features

* Accepts student details through a console-based interface.
* Validates student names (letters and spaces only).
* Prevents empty or invalid student names.
* Restricts student name length.
* Prevents duplicate student names during execution.
* Accepts marks for any number of subjects.
* Validates marks between 0 and 100.
* Calculates:

  * Total Marks
  * Average Marks
  * Grade
* Generates a well-formatted student report.
* Allows multiple student reports in a single execution.

---

## Grade Criteria

| Average Marks | Grade |
| ------------: | :---: |
|      90 – 100 |   A   |
|       80 – 89 |   B   |
|       70 – 79 |   C   |
|       60 – 69 |   D   |
|      Below 60 |   F   |

---

## Technologies Used

* Java
* Arrays
* ArrayList
* Methods
* Loops
* Conditional Statements
* Scanner Class
* Exception-Free Input Validation
* Console-Based User Interface

---

## How It Works

1. The user enters the student's name.
2. The application validates the name.
3. Duplicate names are checked during program execution.
4. The user enters the number of subjects.
5. Marks for each subject are entered.
6. Each mark is validated to ensure it is between 0 and 100.
7. The application calculates:

   * Total Marks
   * Average Marks
   * Grade
8. A formatted student report is displayed.
9. The user can generate reports for additional students or exit the application.

---

## Sample Output

```text
Enter Student Name: John Deo
Enter Number of Subjects: 3
Enter Marks for Subject 1: 95
Enter Marks for Subject 2: 88
Enter Marks for Subject 3: 92

==============================
        STUDENT REPORT
==============================
Name      : John Deo
Subject 1 : 95
Subject 2 : 88
Subject 3 : 92
Total     : 275
Average   : 91.67
Grade     : A
==============================
```

---

## Input Validation

The application validates the following:

* Student name cannot be empty.
* Student name must contain only letters and spaces.
* Student name must contain at least 3 characters.
* Student name cannot exceed 30 characters.
* Duplicate student names are not allowed during execution.
* Number of subjects must be greater than zero.
* Subject marks must be between 0 and 100.
* Invalid numeric inputs are handled gracefully.

---

## Concepts Demonstrated

* Object-Oriented Programming (OOP)
* Arrays
* ArrayList
* Method Creation and Reusability
* Input Validation
* Loops
* Conditional Statements
* Console-Based Application Development

---

## Learning Outcomes

This project helps in understanding:

* Working with arrays for storing marks.
* Using methods to improve code reusability.
* Calculating totals and averages.
* Implementing grading logic using conditional statements.
* Validating user input effectively.
* Preventing duplicate entries using `ArrayList`.
* Building interactive menu-driven console applications.

---

# Task 4 - CSV Data Processor 

## 📌 Project Overview

The **CSV Data Processor** is a beginner-friendly real-world Java project that reads and analyzes CSV (Comma-Separated Values) files. It demonstrates file handling, data validation, duplicate detection, exception handling, and basic statistical calculations using Java.

This project is designed to simulate how real-world applications process and validate CSV datasets before performing data analysis.

---

## 🚀 Features

* Read any CSV file
* Validate the input file name
* Skip the header row automatically
* Ignore blank lines
* Ignore empty cells
* Detect and ignore literal `NaN` values
* Detect and ignore non-numeric values (e.g., `abc`, `xyz`)
* Detect and skip duplicate records
* Calculate:

  * Total Rows
  * Valid Rows
  * Duplicate Rows
  * Invalid Rows
  * Empty Values
  * NaN Values
* Generate statistical results:

  * Sum
  * Average
  * Minimum Value
  * Maximum Value
* Display a professional processing summary
* Handle invalid files and runtime errors gracefully

---

## 🛠️ Technologies Used

* Java
* Java IO (`BufferedReader`, `FileReader`)
* Collections (`HashSet`)
* Exception Handling
* Scanner Class

---

## 📄 Sample CSV File

```csv
Employee,Salary,Age
Anu,69000,22
Raj,87000,34
Tom,34000,21
John,59000,20
Veni,67000,31
Mano,72000,23
Harini,53000,33
Divya,34000,41
Sara,NaN,24
Peter,abc,31
David,,32
Anu,69000,22
```

---

## ▶️ How to Run

1. Open the project in your Java IDE (Eclipse, IntelliJ IDEA, or VS Code).
2. Place the CSV file in the project directory (or provide the correct file path).
3. Run the `CSVDataProcessor` class.
4. Enter the CSV file name when prompted.

Example:

```text
Enter CSV file name: employees.csv
```

---

## 📊 Sample Output

```text
========================================
        CSV PROCESSING SUMMARY
========================================
Total Rows           : 12
Valid Rows           : 8
Duplicate Rows       : 1
Invalid Rows         : 1
Empty Values         : 1
NaN Values           : 1
----------------------------------------
Sum                  : 475000.00
Average              : 59375.00
Minimum              : 34000.00
Maximum              : 87000.00
========================================
```

> **Note:** The exact output depends on the CSV file and the processing logic used.

---

## 💡 Concepts Covered

* File Handling
* CSV Parsing
* Data Validation
* Duplicate Detection
* Exception Handling
* Collections (`HashSet`)
* Loops and Conditional Statements
* Statistical Calculations
* Input Validation
* Clean Code Practices

---

## 🎯 Learning Outcomes

By completing this project, you will gain practical experience in:

* Reading and processing CSV files in Java
* Handling real-world data validation scenarios
* Working with collections for duplicate detection
* Implementing robust exception handling
* Computing basic statistical summaries
* Writing clean, maintainable Java code

---

## Technologies Used
- Java
- Eclipse IDE

## Author

**Aarthi T**

B.Tech – Artificial Intelligence and Data Science

Java | Python | SQL | Machine Learning | Spring Boot | AI Enthusiast



