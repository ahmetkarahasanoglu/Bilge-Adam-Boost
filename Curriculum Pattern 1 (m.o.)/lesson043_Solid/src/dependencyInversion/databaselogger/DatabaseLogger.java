package dependencyInversion.databaselogger;

public class DatabaseLogger {

	PostgreLogger postgreLogger = new PostgreLogger();
	
	public void logToPostgre() {
		PostgreLogger postgreLogger2 = new PostgreLogger(); // bağımlılık yaratıyor, istemediğimiz bir şey. DatabaseLogger2'de çözeceğiz bu durumu.
		postgreLogger.log();
		postgreLogger2.log();
	}
	
	public void logToMongo() {
		MongoLogger mongoLogger = new MongoLogger();		
		mongoLogger.log();
	}
	
}
