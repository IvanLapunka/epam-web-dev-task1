package by.training.task1.exception;

public class XmlCustomException extends Exception {
    public XmlCustomException() {
        super();
    }

    public XmlCustomException(String message) {
        super(message);
    }

    public XmlCustomException(String message, Throwable cause) {
        super(message, cause);
    }

    public XmlCustomException(Throwable cause) {
        super(cause);
    }
}
