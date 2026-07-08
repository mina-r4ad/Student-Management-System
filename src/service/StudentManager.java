package service;

import exception.InvalidGpaException;
import exception.InvalidNameException;
import exception.StudentNotFoundException;
import repository.StudentRepository;
import model.Student;
import util.Validator;

import java.util.List;

public class StudentManager implements StudentService {
    private final StudentRepository repository = new StudentRepository();

    // Store all students

    // Auto Increment Student ID
    private int nextStudentId = 1;

    // =========================
    // Add Student
    // =========================

    public void addStudent(String name, float gpa) {

        if (!Validator.Name(name)) {
            throw new InvalidNameException();
        }

        if (!Validator.Gpa(gpa)) {
            throw new InvalidGpaException();
        }

        Student student = new Student(nextStudentId++, name, gpa);

        repository.save(student);

    }

    // =========================
    // Get All Students
    // =========================

    public List<Student> getAllStudents() {

        return repository.findAll();
    }
    // =========================
    // Find Student By ID
    // =========================

    public Student findStudentById(int id) {

        return repository.findById(id);
    }

    // =========================
    // Find Students By Name
    // =========================

    public List<Student> findStudentByName(String name) {

        return repository.findByName(name);
    }    // =========================
    // Delete Student
    // =========================

    public boolean deleteStudentById(int id) {

        return repository.deleteById(id);
    }

    // =========================
    // Update Student Name
    // =========================

    public void updateStudentNameById(int id, String newName) {

        if (!Validator.Name(newName)) {
            throw new InvalidNameException();
        }

        Student student = findStudentById(id);

        if (student == null) {
            throw new StudentNotFoundException(id);
        }

        student.setName(newName);
    }

    // =========================
    // Update Student GPA
    // =========================


    public void updateStudentGpaById(int id, float newGpa) {

        if (!Validator.Gpa(newGpa)) {
            throw new InvalidGpaException();
        }

        Student student = findStudentById(id);

        if (student == null) {
            throw new StudentNotFoundException(id);
        }

        student.setGpa(newGpa);
    }
}