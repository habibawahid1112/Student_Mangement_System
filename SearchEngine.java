/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package studentmanagementsystem;

import java.util.List;
import java.util.ArrayList;

public class SearchEngine {

    public static List<Student> search_by_id(List<Student> students, String id) {
        List<Student> results = new ArrayList<>();
        for (Student student : students) {
            if (student.getId().equals(id)) {
                results.add(student);
            }
        }
        return results;
    }

    public static List<Student> search_by_name(List<Student> students, String name) {
        List<Student> results = new ArrayList<>();
        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) { // Case-insensitive search
                results.add(student);
            }
        }
        return results;
    }
}

