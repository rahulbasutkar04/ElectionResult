package com.amaap.electionresult.models;

import java.util.HashMap;
import java.util.Map;
public class VoteCalculator {
    private static Map<String, Map<String, Integer>> winnersData = new HashMap<>();
    private static Map<String, Integer> totalVoteCountInCity = new HashMap<>();

    public static Map<String, Map<String, Integer>> getWinnersData() {
        return winnersData;
    }

    public static Map<String, Integer> getTotalVoteCountInCity() {
        return totalVoteCountInCity;
    }

    public Map<String, Map<String, Integer>> getPartyNameWithMaxVote(Map<String, Map<String, Integer>> resultMap) {

        for (String city : resultMap.keySet()) {
            Map<String, Integer> partyVotesMap = resultMap.get(city);
            String winningPartyCode = null;
            int maxVotes = Integer.MIN_VALUE;
            int totalVotesInCity = 0;

            for (Map.Entry<String, Integer> entry : partyVotesMap.entrySet()) {
                String partyName = entry.getKey();
                int votes = entry.getValue();
                totalVotesInCity += votes;

                if (votes > maxVotes) {
                    winningPartyCode = partyName;
                    maxVotes = votes;
                }
            }

            // Store the total number of votes in the city
            totalVoteCountInCity.put(city, totalVotesInCity);

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
