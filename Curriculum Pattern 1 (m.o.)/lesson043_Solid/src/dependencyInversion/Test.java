package dependencyInversion;

import dependencyInversion.databaselogger.DatabaseLogger;
import dependencyInversion.databaselogger.DatabaseLogger2;
import dependencyInversion.databaselogger.MongoLogger;
import dependencyInversion.databaselogger.PostgreLogger;
import dependencyInversion.exception.StoryException;
import dependencyInversion.exception.VideoException;

public class Test {

	public static void main(String[] args) {
		
		Whatsapp whatsapp = new Whatsapp();
		
		try {
			whatsapp.hikayePaylas();
			whatsapp.videoKonferans();
		}catch(StoryException e) {
			new DatabaseLogger().logToPostgre();
		}catch(VideoException e) {
			new DatabaseLogger().logToMongo();
		}
		
		try {
			whatsapp.hikayePaylas();
			whatsapp.videoKonferans();
		}catch(StoryException e) {
			new DatabaseLogger2(new PostgreLogger());
		}catch(VideoException e) {
			new DatabaseLogger2(new MongoLogger());
		}
	}
	
}
