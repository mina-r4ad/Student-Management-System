package service;

import model.Student;
import java.util.List;

public interface StudentService {

    void addStudent(String name, float gpa);

    List<Student> getAllStudents();

    Student findStudentById(int id);

    List<Student> findStudentByName(String name);

    boolean deleteStudentById(int id);

    void updateStudentNameById(int id, String newName);

    void updateStudentGpaById(int id, float newGpa);
}