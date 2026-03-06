# Assignment TP1 — Kotlin Fundamentals & Virtual Library
Course: Desenvolvimento de Aplicações Móveis (DAM)
Student(s): Rui Ferreira (a51597)
Date: March 6th, 2026
Repository URL: https://github.com/RuiFerreira05/DAM-TP1.git
---
## 1. Introduction
This repository contains the pure Kotlin console assignments introduced during Tutorial 1. Its primary objective is to familiarize the student with Kotlin syntax, control flow mechanics, and Object-Oriented Programming (OOP) paradigms before jumping extensively into Android framework development. The project handles both the preliminary baseline exercises and the extended "Virtual Library" logic model.

## 2. System Overview
The project is structured as a Maven repository housing multiple detached, console-based Kotlin scripts and classes. It comprises:
- **Exercise 1**: Dynamic generation and filtering of perfect square algorithms using arrays, ranges, and `IntArray`.
- **Exercise 2**: A robust console-based calculator supporting arithmetic, bitwise shifts (`shl`, `shr`), logical operators, exception handling, and custom hexadecimal/binary output formatting.
- **Exercise 3**: An interactive `generateSequence` implementation modeling the bounce trajectory of a dropped object to practice Kotlin Sequences.
- **Virtual Library (Exercise 6)**: A comprehensive OOP system simulating a library manager with inheritance, classes, companion objects, and encapsulation logic.

## 3. Architecture and Design
The folder structure follows standard Kotlin/Java package hierarchy logic: `dam_a51597`:
- `exer_1`, `exer_2`, `exer_3`: Isolated script files containing independent `main()` functions.
- `virtual_library`: Models an inheritance tree. The `Book` class acts as the foundational abstraction. `DigitalBook` and `PhysicalBook` inherit from it. The `Library` acts as a managing ledger, while `LibraryMember` encapsulates borrower interaction. Types are strictly maintained with customized enumerators (`FormatType`).

## 4. Implementation
Noteworthy Kotlin constructs heavily employed:
- **Control Flow**: Extensive usage of dynamic `when` expressions for calculation mapping in Exer2.
- **Exceptions**: `try-catch` implementations explicitly capture `NumberFormatException` and `ArithmeticException`.
- **Properties**: Overridden custom getters (e.g., retrieving the "Era" of a book) and setters (verifying available stock counters).
- **Sequences**: High-performance lazy evaluation through `generateSequence` paired with `takeWhile`.

## 5. Testing and Validation
Testing was conducted manually via the IntelliJ console terminal.
- Test flows involve interacting manually with the interactive recursive terminal in `Exer2`.
- `TestMain.kt` was constructed explicitly to validate all paths of the `Virtual Library` implementation (e.g. attempting to borrow out-of-stock items natively validating expected console warnings). 

## 6. Usage Instructions
1. Clone the repository: `git clone https://github.com/RuiFerreira05/DAM-TP1.git`
2. Open the project directory in **IntelliJ IDEA**.
3. Reload the Maven `pom.xml` configuration if required.
4. Navigate to `src/main/kotlin/dam_a51597/...` to locate the runnable scripts.
5. Click the green play icon next to any `fun main()` declaration to execute that specific exercise in the IDE console.

---
# Development Process
## 12. Version Control and Commit History
Version control documented the progression starting from building `Exer1` sequentially toward building the abstract data types of the `Virtual Library`. Additionally, the repository underwent restructuring, as `SystemInfoApp` and `HelloWorld` were abstracted cleanly out of this originally monolithic repository.

## 13. Difficulties and Lessons Learned
- Handling raw CLI input with `readlnOrNull()?.trim()` and safely asserting variables securely to avoid unchecked null exceptions.
- Determining when to use companion objects versus standard class instantiations inside the `Library` manager constraint.
- Exploring precision casting when moving numbers visually into binary and hexadecimal outputs on Exer 2.

## 14. Future Improvements
- Refactor the Virtual Library to utilize a file-driven persistence layer (such as JSON parsing) instead of volatile memory construction.
- Implement exhaustive JVM unit tests (`JUnit`) instead of maintaining a raw `TestMain` file.
---
## 15. AI Usage Disclosure (Mandatory)
- No AI tools were employed during the problem-solving phases of `Exer1`, `Exer2`, `Exer3`, or the primary `virtual_library` classes, fulfilling the `[AC NO, AI NO]` instruction clauses correctly. 
- **Exception**: Claude 4.6 was used exclusively inside `TestMain.kt` solely to automatically generate boilerplate print-out logic to validate the optional 6.2 tasks efficiently, saving time on demonstrations. The student remains fully responsible for validating outcomes.
