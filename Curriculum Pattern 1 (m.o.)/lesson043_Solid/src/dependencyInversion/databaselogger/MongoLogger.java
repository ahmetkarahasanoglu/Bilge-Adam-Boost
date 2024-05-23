package dependencyInversion.databaselogger;

public class MongoLogger implements ILogger {
	
	public void log() {
		System.out.println("mongoya loglandı.");
	}
	
}
