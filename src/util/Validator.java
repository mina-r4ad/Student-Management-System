package util;

public class Validator {
    private Validator() {}

    //Check Name
    public static boolean Name(String name) {
        return name.matches("[A-Za-z ]+");

    }
    // Check Gpa
    public static boolean Gpa(float gpa) {
        return gpa >= 0.0 && gpa <= 4.0;

    }
}
