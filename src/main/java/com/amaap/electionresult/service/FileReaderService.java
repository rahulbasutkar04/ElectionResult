package com.amaap.electionresult.service;

import com.amaap.electionresult.repository.impl.InMemoryElectionRepositoryData;
import com.amaap.electionresult.service.exception.InvalidCityNameException;
import com.amaap.electionresult.service.exception.InvalidFilePathException;
import com.amaap.electionresult.service.exception.InvalidFormatException;
import com.amaap.electionresult.service.exception.InvalidPartyCodeException;
import com.amaap.electionresult.service.io.FileParser;

import java.io.*;

public class FileReaderService {
    private final InMemoryElectionRepositoryData inMemoryElectionRepositoryData = InMemoryElectionRepositoryData.getInstance();
    FileParser fileParser = new FileParser();


    public boolean readFile(String path) throws InvalidFilePathException, IOException, InvalidFormatException, InvalidPartyCodeException, InvalidCityNameException {

        File file = new File(path);

        if (path == null) {
            throw new NullPointerException("File path cannot be null");
        }

        if (path.isEmpty()) {
            throw new InvalidFilePathException("File path cannot be empty");
        }

        if (!file.exists()) {
            throw new FileNotFoundException("File not found at the specified path: " + path);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                    String[] tokens = line.split("\\s*,\\s*");
                    line = String.join(", ", tokens);
                    try {
                        if (fileParser.parser(line)) {
                            inMemoryElectionRepositoryData.inertIntoElectionData(line);
                        }
                    } catch (InvalidCityNameException | InvalidFormatException | InvalidPartyCodeException e) {
                        throw e; // Rethrow the caught exception
                    }
                }
            }

            return true;
        }
    }

}
