package exception;

public class BlogException extends RuntimeException {
	private static final long serialVersionUID = -2950205365998448571L;

	public BlogException() {
		super();
	}
	
	public BlogException(String message) {
		super(message);
	}


	public BlogException(Throwable e) {
		super(e);
	}
}
