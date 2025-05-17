/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class StudentGUI extends JFrame {
    private final DatabaseHandler db = new DatabaseHandler();

    private final JTextField idField = new JTextField(10);
    private final JTextField nameField = new JTextField(10);
    private final JTextField ageField = new JTextField(5);
    private final JTextField courseField = new JTextField(15);
    private final JTextField mark1Field = new JTextField(5);
    private final JTextField mark2Field = new JTextField(5);
    private final JTextField mark3Field = new JTextField(5);
    private final JTextField searchField = new JTextField(10);
    private final JTextArea outputArea = new JTextArea(12, 50);

    public StudentGUI() {
        setTitle("Student Management System");
        setSize(700, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(7, 2, 5, 5));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Add / Modify Student"));
        inputPanel.add(new JLabel("Student ID:"));
        inputPanel.add(idField);
        inputPanel.add(new JLabel("Name:"));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("Age:"));
        inputPanel.add(ageField);
        inputPanel.add(new JLabel("Course:"));
        inputPanel.add(courseField);
        inputPanel.add(new JLabel("Mark 1:"));
        inputPanel.add(mark1Field);
        inputPanel.add(new JLabel("Mark 2:"));
        inputPanel.add(mark2Field);
        inputPanel.add(new JLabel("Mark 3:"));
        inputPanel.add(mark3Field);

        // Action Panel
        JPanel actionPanel = new JPanel();
        JButton addButton = new JButton("Add");
        JButton modifyButton = new JButton("Modify");
        JButton viewButton = new JButton("View All");
        JButton searchButton = new JButton("Search");
        JButton deleteButton = new JButton("Delete");
        JButton markSheetButton = new JButton("Generate Mark Sheet");

        actionPanel.add(addButton);
        actionPanel.add(modifyButton);
        actionPanel.add(viewButton);
        actionPanel.add(new JLabel("Student ID:"));
        actionPanel.add(searchField);
        actionPanel.add(searchButton);
        actionPanel.add(deleteButton);
        actionPanel.add(markSheetButton);

        // Output Area
        outputArea.setEditable(false);
        outputArea.setBorder(BorderFactory.createTitledBorder("Student Records"));
        JScrollPane scrollPane = new JScrollPane(outputArea);

        // Add Panels
        add(inputPanel, BorderLayout.NORTH);
        add(actionPanel, BorderLayout.CENTER);
        add(scrollPane, BorderLayout.SOUTH);

        // Button Actions
        addButton.addActionListener(e -> addStudent());
        modifyButton.addActionListener(e -> modifyStudent());
        viewButton.addActionListener(e -> viewStudents());
        searchButton.addActionListener(e -> searchStudent());
        deleteButton.addActionListener(e -> deleteStudent());
        markSheetButton.addActionListener(e -> generateMarkSheet());

        setVisible(true);
    }

    private int[] getMarks() {
        try {
            int m1 = Integer.parseInt(mark1Field.getText().trim());
            int m2 = Integer.parseInt(mark2Field.getText().trim());
            int m3 = Integer.parseInt(mark3Field.getText().trim());
            return new int[]{m1, m2, m3};
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Enter valid numeric marks.");
            return null;
        }
    }

    private void addStudent() {
        String id = idField.getText().trim();
        String name = nameField.getText().trim();
        String ageText = ageField.getText().trim();
        String course = courseField.getText().trim();
        int[] marks = getMarks();
        if (marks == null) return;

        if (id.isEmpty() || name.isEmpty() || ageText.isEmpty() || course.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields must be filled.");
            return;
        }

        try {
            int age = Integer.parseInt(ageText);
            if (age <= 0) throw new NumberFormatException();
            if (db.findStudentById(id) != null) {
                JOptionPane.showMessageDialog(this, "Student ID already exists.");
                return;
            }
            Student s = new Student(id, name, age, course, marks);
            db.insertStudent(s);
            clearFields();
            outputArea.setText("Student added successfully.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid age.");
        }
    }

    private void modifyStudent() {
        String id = searchField.getText().trim();
        Student existing = db.findStudentById(id);
        if (existing == null) {
            outputArea.setText("Student not found.");
            return;
        }

        String name = nameField.getText().trim();
        String ageText = ageField.getText().trim();
        String course = courseField.getText().trim();
        int[] marks = getMarks();
        if (marks == null) return;

        try {
            int age = Integer.parseInt(ageText);
            Student updated = new Student(id, name, age, course, marks);
            db.updateStudent(updated);
            outputArea.setText("Student record updated.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid age.");
        }
    }

    private void viewStudents() {
        outputArea.setText("");
        ArrayList<Student> list = db.getAllStudents();
        if (list.isEmpty()) {
            outputArea.setText("No students found.");
        } else {
            for (Student s : list) {
                outputArea.append(s.toString() + "\n");
            }
        }
    }

    private void searchStudent() {
        String id = searchField.getText().trim();
        Student s = db.findStudentById(id);
        outputArea.setText((s != null) ? "Student Found:\n" + s.toString() : "Student not found.");
    }

    private void deleteStudent() {
        String id = searchField.getText().trim();
        if (db.deleteStudent(id)) {
            outputArea.setText("Student with ID " + id + " has been deleted.");
        } else {
            outputArea.setText("Student not found.");
        }
    }

    private void generateMarkSheet() {
        String id = searchField.getText().trim();
        Student s = db.findStudentById(id);
        if (s != null) {
            outputArea.setText("Mark Sheet:\n" + s.generateMarkSheet());
        } else {
            outputArea.setText("Student not found.");
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        ageField.setText("");
        courseField.setText("");
        mark1Field.setText("");
        mark2Field.setText("");
        mark3Field.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentGUI::new);
    }
}

