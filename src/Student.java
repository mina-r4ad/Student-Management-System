
public class Student {

    private int id;
    private String name;
    private float gpa;

    public Student(int id, String name, float gpa) {
        this.id = id;
        this.name = name;
        this.gpa = gpa;
    }



    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;


    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getGpa() {
        return gpa;
    }


}