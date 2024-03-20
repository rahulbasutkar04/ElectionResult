package com.amaap.electionresult.models;

import java.util.HashMap;
import java.util.Map;

public class VoteCalculator {
   private static  Map<String, Map<String, Integer>> winnersData = new HashMap<>();

    public static Map<String, Map<String, Integer>> getWinnersData() {
        return winnersData;
    }

    public Map<String, Map<String, Integer>> getPartyNameWithMaxVote(Map<String, Map<String, Integer>> resultMap) {
        Map<String, Map<String, Integer>> winnersData = new HashMap<>();

        for (String city : resultMap.keySet()) {
            Map<String, Integer> partyVotesMap = resultMap.get(city);
            String winningPartyCode = null;
            int maxVotes = Integer.MIN_VALUE;

            for (Map.Entry<String, Integer> entry : partyVotesMap.entrySet()) {
                String partyName = entry.getKey();
                int votes = entry.getValue();

                if (votes > maxVotes) {
                    winningPartyCode = partyName;
                    maxVotes = votes;
                }
            }

            // Convert party name to party code using the PartyCodes enum
            String winningPartyName = PartyCodes.valueOf(winningPartyCode).name();
            // Store the winning party code and its votes for the current city
            Map<String, Integer> winnerInfo = new HashMap<>();
            winnerInfo.put(winningPartyName, maxVotes);
            winnersData.put(city, winnerInfo);
        }

        return winnersData;
    }
}

