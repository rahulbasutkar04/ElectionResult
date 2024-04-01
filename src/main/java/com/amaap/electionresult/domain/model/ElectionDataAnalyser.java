package com.amaap.electionresult.domain.model;

import java.util.HashMap;
import java.util.Map;

public class ElectionDataAnalyser {
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

            totalVoteCountInCity.put(city, totalVotesInCity);
            String winningPartyName = PartyCodes.valueOf(winningPartyCode).name();
            Map<String, Integer> winnerInfo = new HashMap<>();
            winnerInfo.put(winningPartyName, maxVotes);
            winnersData.put(city, winnerInfo);
        }

        return winnersData;
    }
}
