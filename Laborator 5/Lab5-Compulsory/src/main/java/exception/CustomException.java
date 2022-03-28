package exception;


public class CustomException extends RuntimeException{

    public CustomException(String id) {
        super("id " + id + " already in use");
    }

}