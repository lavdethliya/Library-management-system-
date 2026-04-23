# 📚 Library Management System

A **Console-based Library Management System** built using **Core Java** and **Object-Oriented Programming (OOP)** concepts.

---

## 🚀 Features

- 📖 **Book Management** — Add, View, and Search books by Title or Author
- 👤 **Member Management** — Register new members and view all members
- 📤 **Issue Books** — Issue available books to registered members
- 📥 **Return Books** — Accept returned books and update availability
- 📋 **Issue Records** — View complete issue/return history

---

## 🗂️ Project Structure

```
LibraryManagementSystem/
└── src/
    ├── Main.java                     # Entry point
    └── library/
        ├── model/
        │   ├── Book.java             # Book entity
        │   ├── Member.java           # Member entity
        │   └── IssueRecord.java      # Issue/Return record
        ├── service/
        │   ├── BookService.java      # Book operations
        │   ├── MemberService.java    # Member operations
        │   └── IssueService.java     # Issue/Return operations
        └── util/
            └── ConsoleUtil.java      # Console display utilities
```

---

## 🛠️ OOP Concepts Used

| Concept         | Where Used                                              |
|-----------------|---------------------------------------------------------|
| **Classes & Objects** | Book, Member, IssueRecord models              |
| **Encapsulation**     | Private fields with getters/setters             |
| **Abstraction**       | Service classes hide logic from Main            |
| **ArrayList**         | Dynamic storage of books, members, records      |
| **toString()**        | Formatted display for each model                |

---

## ▶️ How to Run

### Prerequisites
- Java JDK 11 or higher
- Any IDE (IntelliJ IDEA / Eclipse / VS Code) **or** Terminal

### Steps

**Using Terminal:**
```bash
# Navigate to src folder
cd LibraryManagementSystem/src

# Compile all files
javac -d . library/model/*.java library/service/*.java library/util/*.java Main.java

# Run
java Main
```

**Using IntelliJ IDEA:**
1. Open project → `File > Open` → select `LibraryManagementSystem` folder
2. Mark `src` as **Sources Root**
3. Run `Main.java`

---

## 📸 Sample Output

```
  ╔══════════════════════════════════════════════════╗
  ║        LIBRARY MANAGEMENT SYSTEM  v1.0          ║
  ║          Developed using Core Java OOP           ║
  ╚══════════════════════════════════════════════════╝

  ┌─────────────────────────────────┐
  │           MAIN MENU             │
  ├─────────────────────────────────┤
  │  1. View All Books              │
  │  2. Add a New Book              │
  │  3. Search Book by Title        │
  │  4. Search Book by Author       │
  │  5. View All Members            │
  │  6. Register New Member         │
  │  7. Issue a Book                │
  │  8. Return a Book               │
  │  9. View Issue/Return Records   │
  │  0. Exit                        │
  └─────────────────────────────────┘
```

---

## 👨‍💻 Author

**[Your Name]**  
B.Tech / BCA — [Your College Name]  
Java OOP Project — 2025

---

## 📄 License

This project is open-source and free to use for educational purposes.
