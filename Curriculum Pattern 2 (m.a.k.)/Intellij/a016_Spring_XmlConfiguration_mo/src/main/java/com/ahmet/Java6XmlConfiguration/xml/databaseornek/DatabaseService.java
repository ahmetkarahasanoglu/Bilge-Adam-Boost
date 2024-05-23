package com.ahmet.Java6XmlConfiguration.xml.databaseornek;

import org.yaml.snakeyaml.events.Event;

public class DatabaseService {

    IDatabase database;

    public DatabaseService(IDatabase databaseSelected) {
        this.database = databaseSelected;
    }

    public void log() {
        database.logToDatabase();
    }
}
