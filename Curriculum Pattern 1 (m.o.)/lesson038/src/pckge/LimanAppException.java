package pckge;

public class LimanAppException extends RuntimeException {
	
	private final ErrorType errorType;

	// CONSTRUCTOR 1:
	public LimanAppException(ErrorType errorType) {
		super(errorType.getMessage());
		this.errorType = errorType;
	}
	
	// CONSTRUCTOR 2:
	public LimanAppException(ErrorType errorType, String message) {
		super(message);
		this.errorType = errorType;
	}	

	// GETTER:
	public ErrorType getErrorType() {
		return errorType;
	}

	
	
	
	
	
	
}
