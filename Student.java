/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package studentmanagementsystem;

import java.io.Serializable;
import java.util.Arrays;

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;

    private String id;
    private String name;
    private int age;
    private String course;
    private int[] marks;

    public Student(String id, String name, int age, String course, int[] marks) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
        this.marks = marks;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getCourse() { return course; }
    public int[] getMarks() { return marks; }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Course: " + course;
    }

    public String generateMarkSheet() {
        int total = Arrays.stream(marks).sum();
        double average = total / (double) marks.length;
        return toString() + "\nMarks: " + Arrays.toString(marks) + "\nTotal: " + total + "\nAverage: " + average;
    }
}
