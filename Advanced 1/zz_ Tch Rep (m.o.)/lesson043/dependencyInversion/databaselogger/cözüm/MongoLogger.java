package com.bilgeadam.lesson043.dependencyInversion.databaselogger.c�z�m;

public class MongoLogger implements ILogger {

	public void log(String ex) {
		System.out.println(ex + "-->mongoyo logland�");
	}

}
