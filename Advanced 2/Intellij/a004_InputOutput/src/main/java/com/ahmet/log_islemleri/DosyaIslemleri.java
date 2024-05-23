package com.ahmet.log_islemleri;

import java.io.*;
import java.util.Optional;
import java.util.UUID;

public class DosyaIslemleri {

    // METHODS: ----
    public void createLog(Log log) {
        try {
            String fileName = UUID.randomUUID().toString();
            FileOutputStream file = new FileOutputStream("e:/LogData/"+fileName+".log"); // creates a new file. If the file does not exist, it will be created. If the file already exists, it will be overwritten.
            ObjectOutputStream logStream = new ObjectOutputStream(file); // This object is used to serialize Java objects into the file specified by the 'file' object.
            logStream.writeObject(log);
            logStream.close();
        }catch(Exception e) {

        }
    }

    public Optional<Log> getLogFile(String logFileUuid) {
        try {
            FileInputStream file = new FileInputStream("e:/LogData/"+logFileUuid+".log");
            ObjectInputStream logStream = new ObjectInputStream(file);
            Log log = (Log)logStream.readObject();
            return Optional.of(log); // "may throw a NullPointerException". It will be caught in the 'catch' block.
        }catch(Exception exception) {
            return Optional.empty(); // (when log object couldn't be obtained from the file for some reason)
        }
    }

}
