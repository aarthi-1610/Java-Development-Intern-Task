## Level2
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

*n = Password Length*
=======

## Level2

# Task 1 - ❌⭕ Two-Player Tic-Tac-Toe

A fully interactive **two-player console-based Tic-Tac-Toe game** built in Java. Players take turns placing their marks on a 3×3 grid — featuring complete input validation, win detection across all 8 combinations, and draw handling.

---

## 📌 About the Project

This project was developed as part of a **Java Development Internship (Level 2)** at SaiKet Systems. It demonstrates game logic design, conditional branching, input validation, and clean console-based UI in Java.

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

This project was developed as part of a **Java Development Internship (Level 2)** at SaiKet Systems. It demonstrates validation logic, character-level analysis, and meaningful user feedback in a clean Java program.

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

## Technologies Used
- Java
- Eclipse IDE