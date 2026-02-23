package eru.testing.forum;

public class EmailAddressAlreadyExistsException extends RuntimeException {

    public EmailAddressAlreadyExistsException(String message) {
        super(message);
    }
}
