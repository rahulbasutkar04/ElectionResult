package com.amaap.electionresult.io;


import com.amaap.electionresult.io.exception.IllegalPartyNameException;
import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Parser {

    private static Map<String, Map<String, Integer>> resultMap = new HashMap<>();

    private static List<String> validPartyNames;
    private static List<String> validCityNames;

    public void initialize(String partyNamesFilePath, String cityNamesFilePath) throws IOException {
        readConfigurations(partyNamesFilePath, cityNamesFilePath);
    }

    private static void readConfigurations(String partyNamesFilePath, String cityNamesFilePath) throws IOException {
        Yaml yaml = new Yaml();
        try (FileReader partyReader = new FileReader(partyNamesFilePath);
             FileReader cityReader = new FileReader(cityNamesFilePath)) {
            validPartyNames = yaml.load(partyReader);
            validCityNames = yaml.load(cityReader);
        }
    }

    public Map<String, Map<String, Integer>> getResultMap() {
        return resultMap;
    }

    public boolean processFile(String filePath) throws IOException, IllegalPartyNameException {
        if (validCityNames == null) {
            throw new IllegalStateException("Valid city names have not been initialized.");
        }

        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            boolean dataProcessed = false;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                processLine(line);
                dataProcessed = true;
            }
            if (resultMap.isEmpty()) {
                return false;
            }
            return dataProcessed;
        }
    }

    private static void processLine(String line) throws IllegalPartyNameException {
        if (validCityNames == null) {
            throw new IllegalStateException("Valid city names have not been initialized.");
        }
        String[] parts = line.split(",");
        String city = parts[0].trim();
        if (!validCityNames.contains(city)) {
            throw new IllegalArgumentException("Invalid city name: " + city);
        }

        Map<String, Integer> partyVotesMap = new HashMap<>();

        for (int i = 1; i < parts.length; i += 2) {
            String party = parts[i].trim();
            String votesStr = parts[i + 1].trim();
            int votes;
            try {
                votes = Integer.parseInt(votesStr);
            } catch (NumberFormatException e) {
                throw new IllegalPartyNameException("Invalid vote count: " + votesStr);
            }
            if (!validPartyNames.contains(party)) {
                throw new IllegalPartyNameException("Invalid party name: " + party);
            }
            partyVotesMap.put(party, votes);
        }
        resultMap.put(city, partyVotesMap);
    }
}
