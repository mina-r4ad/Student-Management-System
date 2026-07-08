package repository;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {


    private final List<Student> students = new ArrayList<>();

    public void save(Student student){
        students.add(student);
    }
    public List<Student> findAll() {

        return students;

    }
    public Student findById(int id) {

        for (Student student : students) {

            if (student.getId() == id) {
                return student;
            }
        }

        return null;
    }
    public List<Student> findByName(String name){

        List<Student> result = new ArrayList<>();

        for (Student student : students) {

            if (student.getName()
                    .toLowerCase()
                    .contains(name.toLowerCase())) {

                result.add(student);
            }
        }

        return result;
    }
    public boolean deleteById(int id){
        for (int i = 0; i < students.size(); i++) {

            if (students.get(i).getId() == id) {

                students.remove(i);

                return true;
            }
        }

        return false;
    }


}