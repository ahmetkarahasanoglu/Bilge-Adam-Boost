package dependencyInversion.databaselogger;

public class DatabaseLogger2 {
	
	ILogger logger;
	
	// CONSTRUCTOR:
	public DatabaseLogger2(ILogger logger) {
		super();
		this.logger = logger;
	}

	// METHOD: ---
	public void log() {
		logger.log();
	}
}
