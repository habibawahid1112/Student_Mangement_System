package studentmanagementsystem;

import java.util.ArrayList;
import java.io.*;
import java.util.ArrayList;

public class DatabaseHandler {
    private final String FILE_NAME = "students.dat";
    private ArrayList<Student> students;

    public DatabaseHandler() {
        students = loadFromFile();
    }

    public boolean insertStudent(Student s) {
        if (findStudentById(s.getId()) == null) {
            students.add(s);
            saveToFile();
            return true;
        }
        return false;
    }

    public ArrayList<Student> getAllStudents() {
        return new ArrayList<>(students);
    }

    public Student findStudentById(String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) return s;
        }
        return null;
    }

    public boolean deleteStudent(String id) {
        Student s = findStudentById(id);
        if (s != null) {
            students.remove(s);
            saveToFile();
            return true;
        }
        return false;
    }

    public boolean updateStudent(Student updated) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId().equals(updated.getId())) {
                students.set(i, updated);
                saveToFile();
                return true;
            }
        }
        return false;
    }

    private void saveToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(students);
        } catch (IOException e) {
            System.err.println("Error saving to file: " + e.getMessage());
        }
    }

    private ArrayList<Student> loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (ArrayList<Student>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading from file: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}
