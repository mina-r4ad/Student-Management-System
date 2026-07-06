import java.util.*;

public class StudentManager {

    // Stores all students in memory
    private ArrayList<Student> students = new ArrayList<>();
    private int id = 1;

    // Add a new student
    public boolean addStudent(String name, float gpa) {


        // Set student information
        if (checkGpa(gpa) && checkName(name)) {

            Student student = new Student(id, name, gpa);

            id++;

            // Store the student
            students.add(student);

            return true;
        } else {
            return false;
        }


    }

    // Display all students
    public void showStudents() {

        System.out.println("We Have #" + students.size() + " Of Students.");

        int index = 0;

        for (Student student : students) {

            System.out.println("Student #" + (++index));
            printStudent(student);
        }
    }

    // Search for a student by ID
    public void searchStudentById(int searchId) {

        for (Student student : students) {

            if (searchId == student.getId()) {

                printStudent(student);
            }
        }
    }

    // Search for a student by name
    public boolean searchStudentByName(String name) {

        boolean found = false;

        for (Student student : students) {

            if (student.getName().toLowerCase().contains(name.toLowerCase())) {

                found = true;

                printStudent(student);
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }

        return found;
    }

    // Delete a student using ID
    public void deleteStudentById(int id) {

        for (int i = 0; i < students.size(); i++) {

            Student student = students.get(i);

            if (student.getId() == id) {

                printStudent(student);

                students.remove(i);

                System.out.println("========== Done ==========");

            }
        }

        System.out.println("Student not found.");

    }


    private boolean checkGpa(float gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            return true;
        } else {
            return false;
        }

    }

    private boolean checkName(String name) {
        if (name.matches("[A-Za-z ]+")) {

            return true;
        } else {
            return false;
        }

    }

    public boolean updateStudentNameById(int id, String newName) {
        for (Student student : students) {
            if (student.getId() == id) {
                if (checkName(newName)) {
                    student.setName(newName);
                    return true;

                }
            }
        }
        return false;
    }

    public boolean updateStudentGpaById(int id, float newGpa) {
        for (Student student : students) {
            if (student.getId() == id) {
                if (checkGpa(newGpa)) {
                    student.setGpa(newGpa);
                    return true;

                }
            }
        }
        return false;
    }

    public boolean updateStudentNameByName(String name) {

        for (Student student : students) {
            if (checkName(name)) {
                student.setName(name);
                return true;
            }
        }
        return false;
    }

    private void printStudent(Student student) {

        System.out.println("==========");
        System.out.println("ID: " + student.getId());
        System.out.println("Name: " + student.getName());
        System.out.println("GPA: " + student.getGpa());
        System.out.println("==========");

    }
}