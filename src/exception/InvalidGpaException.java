package exception;

public class InvalidGpaException extends RuntimeException {

    public InvalidGpaException() {
        super("Invalid GPA. GPA must be between 0.0 and 4.0.");
    }
}