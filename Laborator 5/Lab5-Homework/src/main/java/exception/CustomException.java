package exception;

/**
 * class CustomException
 * @author Petrea Daniela
 */
public class CustomException extends Exception{

    public CustomException(String exception) {
        super("exception " + exception);
    }

}