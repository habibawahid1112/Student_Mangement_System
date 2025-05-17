/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package studentmanagementsystem;

import java.util.*;

public class StudentManagementSystem {
    private List<Student> students;
    private String adminPassword;

    public StudentManagementSystem() {
        students = new ArrayList<>();
        adminPassword = "admin123";
    }

    public void start() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student Record");
            System.out.println("2. Search Student Record");
            System.out.println("3. Modify Student Record");
            System.out.println("4. Generate Mark Sheet");
            System.out.println("5. Delete Student Record");
            System.out.println("6. Change Admin Password");
            System.out.println("7. Display All Students");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> addStudent(sc);
                case 2 -> searchStudent(sc);
                case 3 -> modifyStudent(sc);
                case 4 -> generateMarkSheet(sc);
                case 5 -> deleteStudent(sc);
                case 6 -> changePassword(sc);
                case 7 -> displayAllStudents();
                case 0 -> {
                    System.out.println("Exiting system.");
                    return;
                }
                default -> System.out.println("Invalid choice. Try again.");
            }
        }
    }

    private void addStudent(Scanner sc) {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        Student student = new Student(id, name);

        System.out.print("Enter number of subjects: ");
        int subjectCount = sc.nextInt();
        sc.nextLine(); // consume newline

        for (int i = 0; i < subjectCount; i++) {
            System.out.print("Enter subject name: ");
            String subject = sc.nextLine();
            System.out.print("Enter marks: ");
            int marks = sc.nextInt();
            sc.nextLine(); // consume newline
            student.addMarks(subject, marks);
        }

        student.calculateGrade();
        students.add(student);
        System.out.println("Student added successfully.");
    }

    private void searchStudent(Scanner sc) {
        System.out.print("Enter Student ID or Name to search: ");
        String query = sc.nextLine();
        Student s = findStudent(query);
        if (s != null) {
            System.out.println("Found: " + s.getId() + " - " + s.getName());
            System.out.println("Marks: " + s.getMarksString());
            System.out.println("Grade: " + s.getGrade());
        } else {
            System.out.println("Student not found.");
        }
    }

    private void modifyStudent(Scanner sc) {
        System.out.print("Enter Student ID to modify: ");
        String id = sc.nextLine();
        Student s = findStudent(id);
        if (s != null) {
            System.out.print("Enter new name: ");
            String newName = sc.nextLine();
            s.setName(newName);
            System.out.println("Name updated.");

            System.out.print("Modify marks? (y/n): ");
            String opt = sc.nextLine();
            if (opt.equalsIgnoreCase("y")) {
                s.getMarks().clear();
                System.out.print("Enter number of subjects: ");
                int n = sc.nextInt();
                sc.nextLine(); // consume newline
                for (int i = 0; i < n; i++) {
                    System.out.print("Enter subject name: ");
                    String subj = sc.nextLine();
                    System.out.print("Enter marks: ");
                    int m = sc.nextInt();
                    sc.nextLine();
                    s.addMarks(subj, m);
                }
                s.calculateGrade();
                System.out.println("Marks updated.");
            }
        } else {
            System.out.println("Student not found.");
        }
    }

    private void generateMarkSheet(Scanner sc) {
        System.out.print("Enter Student ID to generate mark sheet: ");
        String id = sc.nextLine();
        Student s = findStudent(id);
        if (s != null) {
            s.calculateGrade();
            System.out.println("Mark Sheet for " + s.getName());
            System.out.println("Marks: " + s.getMarksString());
            System.out.println("Grade: " + s.getGrade());
        } else {
            System.out.println("Student not found.");
        }
    }

    private void deleteStudent(Scanner sc) {
        System.out.print("Enter Student ID to delete: ");
        String id = sc.nextLine();
        Student s = findStudent(id);
        if (s != null) {
            students.remove(s);
            System.out.println("Student deleted.");
        } else {
            System.out.println("Student not found.");
        }
    }

    private void changePassword(Scanner sc) {
        System.out.print("Enter current admin password: ");
        String current = sc.nextLine();
        if (adminPassword.equals(current)) {
            System.out.print("Enter new password: ");
            String newPass = sc.nextLine();
            adminPassword = newPass;
            System.out.println("Password changed.");
        } else {
            System.out.println("Incorrect current password.");
        }
    }

    private void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
            return;
        }
        for (Student s : students) {
            System.out.println("ID: " + s.getId() + ", Name: " + s.getName());
        }
    }

    private Student findStudent(String idOrName) {
        for (Student s : students) {
            if (s.getId().equalsIgnoreCase(idOrName) || s.getName().equalsIgnoreCase(idOrName)) {
                return s;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        system.start();
    }
}
