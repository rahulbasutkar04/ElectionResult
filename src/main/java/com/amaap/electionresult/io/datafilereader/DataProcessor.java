package com.amaap.electionresult.io.datafilereader;


import com.amaap.electionresult.customeexceptions.IllegalPartyNameException;
import com.amaap.electionresult.models.PartyCodes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DataProcessor {


   private static  Map<String, Map<String, Integer>> resultMap = new HashMap<>();

    public static Map<String, Map<String, Integer>> getResultMap() {
        return resultMap;
    }

    public static boolean processor(String path) throws FileNotFoundException, IllegalPartyNameException {


            File file = new File(path);
            Scanner scanner = new Scanner(file);

            boolean dataProcessed = false; // Flag to track if any data is processed
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                processLine(line, resultMap);
                dataProcessed = true; // Set flag to true if data is processed
            }
            scanner.close();

            return dataProcessed; // Return true if data is processed, otherwise false
        }

    private static void processLine(String line, Map<String, Map<String, Integer>> resultMap) throws IllegalPartyNameException {
        // Split the line into parts
        String[] parts = line.split(",");
        String city = parts[0];
        Map<String, Integer> partyVotesMap = new HashMap<>();

        for (int i = 1; i < parts.length; i += 2) {
            String party = parts[i].trim(); // Party name
            String votesStr = parts[i + 1].trim(); // Votes as string
            int votes;
            try {
                votes = Integer.parseInt(votesStr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                continue;
            }
            // Check if the party name is valid using the enum
            if (!isValidParty(party)) {
                throw new IllegalPartyNameException("Invalid party name: " + party);
            }
            partyVotesMap.put(party, votes);
        }
        resultMap.put(city, partyVotesMap);
    }
    // Method to check if the party name is valid using the enum
    private static boolean isValidParty(String partyName) {
        for (PartyCodes party : PartyCodes.values()) {
            if (party.name().equals(partyName)) {
                return true;
            }
        }
        return false;
    }

}
