package com.amaap.electionresult.service.io;

import com.amaap.electionresult.repository.impl.InMemoryElectionRepositoryData;
import com.amaap.electionresult.service.exception.*;
import com.amaap.electionresult.service.io.FileParser;

import java.io.*;

public class FileReaderService {
    private final InMemoryElectionRepositoryData inMemoryElectionRepositoryData = InMemoryElectionRepositoryData.getInstance();
    FileParser fileParser = new FileParser();


    public boolean readFile(String path) throws ElectionResultException, IOException {

        File file = new File(path);

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
                        throw e;
                    }
                }
            }

            return true;
        }
    }

}
