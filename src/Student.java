
public class Student {

    private int id;
    private String name;
    private float gpa;

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


    public String toString() {
        return "ID: " + id +
                ", Name: " + name +
                ", GPA: " + gpa;
    }


}