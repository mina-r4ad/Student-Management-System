import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Read user input
        Scanner input = new Scanner(System.in);

        // Create Student Manager object
        StudentManager manager = new StudentManager();

        // Control application loop
        boolean running = true;

        while (running) {

            // Display main menu
            System.out.println("""
                    1. Add Student
                    2. Show Student
                    3. Search Student
                    4. Delete Student
                    5. Update Student
                    6. Exit
                    ###################""");

            int choice = input.nextInt();

            switch (choice) {

                case 1: // Add Student

                    System.out.print("How Many Students You Need: ");
                    int numberOfStudents = input.nextInt();

                    for (int i = 0; i < numberOfStudents; i++) {
                        boolean done;
                        do {
                            System.out.println("Enter Name Of Student #" + (i + 1));
                            input.nextLine();
                            String name = input.nextLine();

                            System.out.println("Enter GPA Of Student #" + (i + 1));
                            float gpa = input.nextFloat();
                            done = manager.addStudent(name, gpa);

                            if (done) {
                                System.out.println("===== Done =====");
                            } else System.out.println("*****Enter a correct value*****");
                        } while (!done);

                    }

                    System.out.println("====================");
                    break;

                case 2: // Show Students

                    manager.showStudents();

                    System.out.println("====================");
                    break;

                case 3: // Search Student

                    System.out.println("""
                            Search Student By:
                            1. ID
                            2. Name
                            """);

                    int searchOption = input.nextInt();

                    if (searchOption == 1) {

                        System.out.print("Enter Student ID: ");

                        int id = input.nextInt();

                        manager.searchStudentById(id);

                    } else if (searchOption == 2) {

                        System.out.print("Enter Student Name: ");
                        input.nextLine();

                        String name = input.nextLine();

                        manager.searchStudentByName(name);

                    } else {

                        System.out.println("Not Found.");
                    }

                    break;

                case 4: // Delete Student

                    System.out.println("""
                            Delete Student By:
                            1. ID
                            2. Name
                            """);

                    int deleteOption = input.nextInt();

                    if (deleteOption == 1) {

                        System.out.print("Enter Student ID: ");
                        int id = input.nextInt();

                        manager.deleteStudentById(id);

                    } else if (deleteOption == 2) {

                        System.out.print("Enter Student Name: ");
                        String name = input.next();
                        if (manager.searchStudentByName(name)) {

                            System.out.print("Enter Student ID to delete: ");
                            int id = input.nextInt();

                            manager.deleteStudentById(id);

                        }
                    }

                    break;
                case 5: // Update Student

                    System.out.println("""
            What do you want to update?
            1. Name
            2. GPA
            """);

                    int updateOption = input.nextInt();

                    switch (updateOption) {

                        case 1: // Update Name

                            System.out.print("Enter Student Name: ");
                            input.nextLine();
                            String name = input.nextLine();

                            if (manager.searchStudentByName(name)) {

                                System.out.print("Enter Student ID to update: ");
                                int id = input.nextInt();

                                input.nextLine();

                                System.out.print("Enter New Name: ");
                                String newName = input.nextLine();

                                boolean updated = manager.updateStudentNameById(id, newName);

                                if (updated) {
                                    System.out.println("===== Student Updated Successfully =====");
                                    manager.searchStudentById(id);
                                } else {
                                    System.out.println("===== Update Failed =====");
                                }

                            } else {

                                System.out.println("===== Student Not Found =====");

                            }

                            break;

                        case 2: // Update GPA

                            System.out.print("Enter Student Name: ");
                            input.nextLine();
                            String studentName = input.nextLine();

                            if (manager.searchStudentByName(studentName)) {

                                System.out.print("Enter Student ID to update: ");
                                int id = input.nextInt();

                                System.out.print("Enter New GPA: ");
                                float newGpa = input.nextFloat();

                                boolean updated = manager.updateStudentGpaById(id, newGpa);

                                if (updated) {
                                    System.out.println("===== Student Updated Successfully =====");
                                    manager.searchStudentById(id);
                                } else {
                                    System.out.println("===== Update Failed =====");
                                }

                            } else {

                                System.out.println("===== Student Not Found =====");

                            }

                            break;

                        default:

                            System.out.println("Invalid Option.");

                    }

                    break;

                case 6: // Exit Program

                    running = false;
                    break;

                default:

                    System.out.println("Enter a valid value.");
            }
        }
    }
}