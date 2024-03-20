package com.amaap.electionresult.io.datafilereader;
import com.amaap.electionresult.customeexceptions.*;
public class DataExtractor {


    public boolean readFile(String path) throws IllegalFileFormatException {
        if (!path.toLowerCase().endsWith(".txt")) {
            throw new IllegalFileFormatException("Invalid file format. Please provide a .txt file.");
        }

        // Proceed with reading the file
        // Your file reading logic here

        return true; // Placeholder return statement
    }


}
