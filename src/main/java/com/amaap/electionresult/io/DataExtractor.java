package com.amaap.electionresult.io;

import com.amaap.electionresult.io.exception.EmptyFilepathException;
import com.amaap.electionresult.io.exception.IllegalFileFormatException;
import com.amaap.electionresult.io.exception.IllegalPartyNameException;
import com.amaap.electionresult.io.exception.NoDataFoundInFileException;

import java.io.File;
import java.io.IOException;

public class DataExtractor {

    public boolean readFile(String path) throws IllegalFileFormatException, NoDataFoundInFileException, IOException, IllegalPartyNameException, EmptyFilepathException {
        if (path.isEmpty()) {
            throw new EmptyFilepathException("Path not found  / provide path");
        }
        if (!path.toLowerCase().endsWith(".txt")) {
            throw new IllegalFileFormatException("Invalid file format. Please provide a .txt file.");
        }

        Parser parser = new Parser();
        String partyNamesFilePath = "D:\\ElectionResult\\src\\test\\java\\com\\amaap\\electionresult\\configuration\\valid_party_names.yaml";
        String cityNamesFilePath = "D:\\ElectionResult\\src\\test\\java\\com\\amaap\\electionresult\\configuration\\valid_city_names.yaml";
        parser.initialize(partyNamesFilePath, cityNamesFilePath); // Initialize the parser

        File file = new File(path);
        if (file.length() == 0) {
            throw new NoDataFoundInFileException("No data found in the file");
        }
        return parser.processFile(path);
    }

}
