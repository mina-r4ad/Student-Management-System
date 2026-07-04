import java.util.ArrayList;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<Student> students = new ArrayList<>();

        boolean running = true;

        while (running) {
            System.out.println("1. Add Student\n" +
                    "2. Show Student\n" +
                    "3. Search Student\n" +
                    "4. Delect Student\n" +
                    "5. Exit");
            int number = input.nextInt();
            switch (number) {
                case 1: //Add Student
                    System.out.print("How Many Students you Need:");
                    int stu = input.nextInt();
                    for (int i = 0; i < stu; i++) {
                        Student student = new Student();

                        System.out.println("Enter Name Of Student #" + (i + 1));
                        student.setName(input.next());

                        System.out.println("Enter GPA Of Student #" + (i + 1));
                        student.setGpa(input.nextFloat());

                        student.setId(i + 1);

                        students.add(student);
                        System.out.println("Student #" + (i + 1) + " added successfully");


                    }
                    break;

                case 2: //Show Student
                    System.out.println("We Have #" + students.size() + " Of Students.");
                    int i = 0;
                    for (Student student : students) {

                        System.out.println("Student #" + (++i));
                        System.out.println("ID: " + student.getId());
                        System.out.println("Name: " + student.getName());
                        System.out.println("GPA: " + student.getGpa());
                    }
                    System.out.println("====================");
                    break;

                case 3: //Search Student
                    System.out.println("You Need searching By: \n 1. ID \n 2. Name");
                    int search = input.nextInt();
                    if (search == 1) {
                        System.out.print("Enter ID : ");
                        int IdSearch = input.nextInt();
                        for (Student student : students) {
                            if (IdSearch == student.getId()) {
                                System.out.println("==========");
                                System.out.println("ID: " + student.getId());
                                System.out.println("Name: " + student.getName());
                                System.out.println("GPA: " + student.getGpa());
                            }
                        }
                    } else if (search == 2) {
                        System.out.print("Enter Name : ");
                        String NameSearch = input.next();
                        for (Student student : students) {
                            if (NameSearch.equals(student.getName())) {
                                System.out.println("==========");
                                System.out.println("ID: " + student.getId());
                                System.out.println("Name: " + student.getName());
                                System.out.println("GPA: " + student.getGpa());
                            }
                        }
                    } else
                        System.out.println("Not Found.");


                    break;
                case 4: //Delect Student
                    System.out.println("Choose how you are need delect Student 1. ID OR 2. Name : ");
                    int delectBy = input.nextInt();
                    if (delectBy == 1) {
                        System.out.println("Enter ID: ");
                        int id = input.nextInt();
                        for ( i = 0; i < students.size(); i++) {
                            Student student = students.get(i);
                            if (student.getId() == id) {
                                students.remove(i);
                                System.out.println("========== Done ==========");

                            }
                        }

                    } else if (delectBy == 2) {
                        System.out.println("Enter Name: ");
                        String Name = input.next();
                        for (i = 0; i < students.size(); i++) {
                            Student student = students.get(i);
                            if (student.getName().equals(Name) ) {
                                students.remove(i);
                                System.out.println("========== Done ==========");
                            }
                        }

                    }else {
                        System.out.println("========== Try Again ==========");
                    }
                    break;

                case 5://Exit
                    running = false;




                    break;
                default:
                    System.out.println("Enter a valid value");
            }


        }
    }
}