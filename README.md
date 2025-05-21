# Student Mangement System

The Student Management System is a Java-based desktop application designed to manage student records efficiently. It allows users to add, view, modify, delete, and search student data, as well as generate mark sheets. The application features a Graphical User Interface (GUI) built using Java Swing, making it user-friendly.

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
1. Student – Stores ID, name, course, marks; generates mark sheets.

2. MarkSheet – Formats and calculates total/average/grade.

3. SearchEngine – Finds students by ID or name.

4. DatabaseHandler – Reads/writes data to students.dat using Java I/O.

5. StudentManagementSystem – Console version with a text menu.

6. StudentGUI – Swing-based GUI version with buttons and forms.

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

- User selects an action (Add, Search, etc.).

- System prompts for input using GUI.

- Relevant class methods execute logic and update storage.

## 📚 Libraries:

- javax.swing – GUI

- java.sql – Mentioned, but not actually used (no SQL database)

- java.util – Data structures like ArrayList, HashMap

- java.util.stream – Filtering/searching

- java.awt – Basic GUI

- java.io – File input/output for storing student data

## 🧪 Sample Outputs
The report includes GUI screenshots for each operation:

- Add – Adds student to list and file.

- Modify – Updates marks or info.

- Delete – Removes student by ID.

- View All – Lists all students in output area.

- Search – Finds student and shows info.

- Generate MarkSheet – Shows formatted report.

## ✅ Conclusion
This report documents a well-structured student information system developed with Java Swing and object serialization. It's an educational project showing understanding of:

- Java OOP principles

- GUI design

- Data persistence

- Modular coding practices
