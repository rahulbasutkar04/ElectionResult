package com.amaap.electionresult.io.datafilereader;


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

    public static boolean dataProcessor(String path) throws FileNotFoundException {


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

    private static void processLine(String line, Map<String, Map<String, Integer>> resultMap) {
        // Split the line into parts
        String[] parts = line.split(",");
        String city = parts[0];
        Map<String, Integer> partyVotesMap = new HashMap<>();

        for (int i = 1; i < parts.length; i += 2) {
            String party = parts[i].trim(); //party  name
            String votesStr = parts[i + 1].trim();//votes  as string
            int votes;
            try {
                votes = Integer.parseInt(votesStr);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                continue;
            }
            partyVotesMap.put(party, votes);
        }
        resultMap.put(city, partyVotesMap);
    }

}
