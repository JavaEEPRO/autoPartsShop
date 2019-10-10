package si.inspirited.web.error;

public class KindNotExistException extends RuntimeException {

    private static final long serialVersionUID = 5861310537366287163L;

    public KindNotExistException() {
        super();
    }

    public KindNotExistException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public KindNotExistException(final String message) {
        super(message);
    }

    public KindNotExistException(final Throwable cause) {
        super(cause);
    }
}
