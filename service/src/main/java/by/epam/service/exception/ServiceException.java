package by.epam.service.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = 1528751752451255980L;

	public ServiceException() {
		super();
	}

	public ServiceException(String message) {
		super(message);
	}

	public ServiceException(String message, Exception cause) {
		super(message, cause);
	}

	public ServiceException(Exception cause) {
		super(cause);
	}

}
