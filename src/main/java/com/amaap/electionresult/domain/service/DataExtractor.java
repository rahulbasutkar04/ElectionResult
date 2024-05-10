package com.amaap.electionresult.domain.service;

import java.util.HashMap;

public class DataExtractor {

    private static DataExtractor instance;
    private DataExtractor() {}

    public static DataExtractor getInstance() {
        if (instance == null) {
            instance = new DataExtractor();
        }
        return instance;
    }

    public HashMap<String, HashMap<String, Integer>> ExtractData(String input) {
        HashMap<String, HashMap<String, Integer>> resultMap = new HashMap<>();

        String[] cities = input.split(";");

        for (String cityData : cities) {
            String[] parts = cityData.split(", ");
            String city = parts[0];
            HashMap<String, Integer> partyMap = new HashMap<>();

            for (int i = 1; i < parts.length - 1; i += 2) {
                String party = parts[i + 1];
                int votes = Integer.parseInt(parts[i]);
                partyMap.put(party, votes);
            }

            resultMap.put(city, partyMap);
        }

        return resultMap;
    }
}
