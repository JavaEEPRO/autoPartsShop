package si.inspirited.web.error;

public class AdAlreadyExistException extends RuntimeException {

    private static final long serialVersionUID = 5861310537366287163L;

    public AdAlreadyExistException() {
        super();
    }

    public AdAlreadyExistException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public AdAlreadyExistException(final String message) {
        super(message);
    }

    public AdAlreadyExistException(final Throwable cause) {
        super(cause);
    }
}
