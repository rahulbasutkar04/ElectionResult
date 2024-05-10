package com.amaap.electionresult.domain.service;

import java.util.HashMap;
import java.util.Map;

public class VoteCalculator {
    public static HashMap<String, HashMap<String, Integer>> calculateVotes(HashMap<String, HashMap<String, Integer>> extractedData) {
        HashMap<String, HashMap<String, Integer>> cityWinners = new HashMap<>();

        for (Map.Entry<String, HashMap<String, Integer>> cityEntry : extractedData.entrySet()) {
            String city = cityEntry.getKey();
            HashMap<String, Integer> partyMap = cityEntry.getValue();
            String winningParty = "";
            int maxVotes = Integer.MIN_VALUE;

            for (Map.Entry<String, Integer> partyEntry : partyMap.entrySet()) {
                String party = partyEntry.getKey();
                int votes = partyEntry.getValue();
                if (votes > maxVotes) {
                    maxVotes = votes;
                    winningParty = party;
                }
            }

            HashMap<String, Integer> winnerMap = new HashMap<>();
            winnerMap.put(winningParty, maxVotes);
            cityWinners.put(city, winnerMap);
        }

        return cityWinners;
    }

}
