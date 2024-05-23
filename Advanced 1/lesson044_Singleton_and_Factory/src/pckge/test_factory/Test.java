package pckge.test_factory;

import pckge.factory.DatabaseFactory;
import pckge.factory.ILogger;
/**
 * In this class, we will access the DatabaseFactory class
 * from an outer package. Note: Mongo and Postgre classes are 
 * not public; they can't be reached from outer packages.
 */
public class Test {

	public static void main(String[] args) {
		
//		Mongo mongoLogger = new Mongo();
		ILogger logger = DatabaseFactory.createDatabase("postgre");
		logger.log("asdf");
		
	}//MAIN ENDS HERE ----

}//CLASS ENDS HERE ----
