package ui;

import model.Student;
import service.StudentManager;
import service.StudentService;
import exception.InvalidGpaException;
import exception.InvalidNameException;
import exception.StudentNotFoundException;


import java.util.*;


public class ConsoleMenu {

    private final Scanner input = new Scanner(System.in);
    private final StudentService manager = new StudentManager();

    public void start() {

        boolean running = true;

        while (running) {

            printMainMenu();

            int choice = input.nextInt();

            switch (choice) {

                case 1:
                    addStudent();
                    break;

                case 2:
                    showStudents();
                    break;

                case 3:
                    searchStudent();
                    break;

                case 4:
                    deleteStudent();
                    break;

                case 5:
                    updateStudent();
                    break;

                case 6:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid Option.");
            }
        }
    }

    private void addStudent() {

        System.out.print("How Many Students You Need: ");

        int numberOfStudents = input.nextInt();

        for (int i = 0; i < numberOfStudents; i++) {

            boolean added = false;

            do {

                try {

                    input.nextLine();

                    System.out.print("Enter Student Name #" + (i + 1) + ": ");
                    String name = input.nextLine();

                    System.out.print("Enter Student GPA #" + (i + 1) + ": ");
                    float gpa = input.nextFloat();

                    manager.addStudent(name, gpa);

                    System.out.println("===== Student Added Successfully =====");

                    added = true;

                } catch (InvalidNameException | InvalidGpaException e) {

                    System.out.println(e.getMessage());

                }

            } while (!added);
        }
    }
    private void printMainMenu() {

        System.out.println("""
                1. Add Student
                2. Show Students
                3. Search Student
                4. Delete Student
                5. Update Student
                6. Exit
                ===================
                """);
    }

    private void showStudents() {

        List<Student> students = manager.getAllStudents();

        if (students.isEmpty()) {

            System.out.println("No students found.");
            return;
        }

        int index = 1;

        for (Student student : students) {

            System.out.println("Student #" + index++);
            printStudent(student);
        }
    }

    private void searchStudent() {

        System.out.println("""
                Search Student By:
                1. ID
                2. Name
                """);

        int option = input.nextInt();

        switch (option) {

            case 1:

                System.out.print("Enter Student ID: ");

                int id = input.nextInt();

                Student student = manager.findStudentById(id);

                if (student == null) {

                    System.out.println("Student not found.");

                } else {

                    printStudent(student);

                }

                break;

            case 2:

                input.nextLine();

                System.out.print("Enter Student Name: ");

                String name = input.nextLine();

                List<Student> result = manager.findStudentByName(name);

                if (result.isEmpty()) {

                    System.out.println("Student not found.");

                } else {

                    for (Student s : result) {

                        printStudent(s);

                    }
                }

                break;

            default:

                System.out.println("Invalid Option.");
        }
    }

    private void deleteStudent() {

        System.out.print("Enter Student ID: ");

        int id = input.nextInt();

        boolean deleted = manager.deleteStudentById(id);

        if (deleted) {

            System.out.println("Student deleted successfully.");

        } else {

            System.out.println("Student not found.");

        }
    }

    private void updateStudent() {

        System.out.println("""
                Update Student
                1. Name
                2. GPA
                """);

        int option = input.nextInt();

        switch (option) {

            case 1:
                updateStudentName();
                break;

            case 2:
                updateStudentGpa();
                break;

            default:
                System.out.println("Invalid Option.");
        }
    }

    private void updateStudentName() {

        System.out.print("Enter Student ID: ");
        int id = input.nextInt();

        input.nextLine();

        System.out.print("Enter New Name: ");
        String newName = input.nextLine();

        try {

            manager.updateStudentNameById(id, newName);

            System.out.println("===== Updated Successfully =====");

            Student student = manager.findStudentById(id);

            printStudent(student);

        } catch (InvalidNameException | StudentNotFoundException e) {

            System.out.println(e.getMessage());

        }
    }
    private void updateStudentGpa() {

        System.out.print("Enter Student ID: ");
        int id = input.nextInt();

        System.out.print("Enter New GPA: ");
        float gpa = input.nextFloat();

        try {

            manager.updateStudentGpaById(id, gpa);

            System.out.println("===== Updated Successfully =====");

            Student student = manager.findStudentById(id);

            printStudent(student);

        } catch (InvalidGpaException | StudentNotFoundException e) {

            System.out.println(e.getMessage());

        }
    }

    private void printStudent(Student student) {

        System.out.println("==========");
        System.out.println("ID   : " + student.getId());
        System.out.println("Name : " + student.getName());
        System.out.println("GPA  : " + student.getGpa());
        System.out.println("==========");
    }
}