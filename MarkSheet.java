/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package studentmanagementsystem;

public class MarkSheet {
    private Student student;

    public MarkSheet(Student student) {
        this.student = student;
    }

    public void generate() {
        student.calculateGrade();
    }

    public void display() {
        System.out.println("------ Mark Sheet ------");
        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        student.getMarks().forEach((subj, mark) ->
            System.out.println("Subject: " + subj + ", Marks: " + mark)
        );
        System.out.println("Grade: " + student.getGrade());
    }
}