package by.epam.dao.exception;

public class DAOException extends Exception {
	private static final long serialVersionUID = -4209618863989526199L;

	public DAOException() {
		super();
	}

	public DAOException(String message) {
		super(message);
	}

	public DAOException(String message, Exception cause) {
		super(message, cause);
	}

	public DAOException(Exception cause) {
		super(cause);
	}
}
