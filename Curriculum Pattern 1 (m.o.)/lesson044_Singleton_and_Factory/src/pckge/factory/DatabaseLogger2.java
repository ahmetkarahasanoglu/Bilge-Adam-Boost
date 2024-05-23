package pckge.factory;

public class DatabaseLogger2 {
	ILogger logger;

	// CONSTRUCTOR:
	public DatabaseLogger2(ILogger logger) {
		super();
		this.logger = logger;
	}

	public void logToDatabse(String ex) {
		logger.log(ex);
	}

}
