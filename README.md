# Student Mangement System

The Student Management System is a Java-based desktop application designed to manage student records efficiently. It allows users to add, view, modify, delete, and search student data, as well as generate mark sheets. The application features a Graphical User Interface (GUI) built using Java Swing, making it user-friendly and accessible to non-programmers.

### 🔍 Project Purpose
The system is a Java-based desktop application used to:

- Manage student records (ID, name, course, subject marks, grades).

- Support full CRUD (Create, Read, Update, Delete) operations.

- Calculate grades automatically.

- Provide a graphical user interface (GUI) using Java Swing.

- Store data persistently using file-based serialization (no SQL DB).
                                         
### 🎯 Objectives
The main goals were to:

- Provide an easy way to manage student data.

- Calculate grades based on average marks.

- Enable long-term storage of data via files.

- Make it modular and maintainable.

- Provide a user-friendly GUI for non-technical users.

### ⚙️ System Components

## ✅ Main Classes & Their Roles:
- Student – Stores ID, name, course, marks; generates mark sheets.

- MarkSheet – Formats and calculates total/average/grade.

- SearchEngine – Finds students by ID or name.

- DatabaseHandler – Reads/writes data to students.dat using Java I/O.

- StudentManagementSystem – Console version with a text menu.

- StudentGUI – Swing-based GUI version with buttons and forms.

## ✅ GUI Features:
Add, Modify, Delete, Search, View All, Generate Mark Sheet.

- Input fields for student data.

- Output area showing messages/results.

- Button-based controls using Java Swing.

## ✅ File-Based Database (Not MySQL):
Student data stored in students.dat using ObjectOutputStream.

- Supports serialization (saving/loading objects as files).

- Simple, no SQL setup needed—suitable for small-scale apps.

### 🧮 Algorithms and Libraries Used

## 🧩 Main Logic Flow:

User selects an action (Add, Search, etc.).

System prompts for input using GUI.

Relevant class methods execute logic and update storage.

## 📚 Libraries:

javax.swing – GUI

java.sql – Mentioned, but not actually used (no SQL database)

java.util – Data structures like ArrayList, HashMap

java.util.stream – Filtering/searching

java.awt – Basic GUI

java.io – File input/output for storing student data
