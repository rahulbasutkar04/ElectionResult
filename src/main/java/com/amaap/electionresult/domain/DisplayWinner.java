package com.amaap.electionresult.domain.models;

import java.util.Map;

public class DisplayWinner {
    public static void displayWinners(Map<String, Map<String, Integer>> winnersData) {
        Map<String, Integer> totalVotesInCity = VoteCalculator.getTotalVoteCountInCity();

        for (String constituency : winnersData.keySet()) {
            System.out.println("Constituency: " + constituency);
            Map<String, Integer> winnerInfo = winnersData.get(constituency);
            int totalVotes = totalVotesInCity.get(constituency);

            for (Map.Entry<String, Integer> entry : winnerInfo.entrySet()) {
                String partyCode = entry.getKey();
                int votes = entry.getValue();
                String partyName = PartyCodes.getFullName(partyCode);

                // Calculate the percentage of votes for the winning party
                double votePercentage = calculateVotePercentage(votes, totalVotes);

                // Display the winner and the percentage of votes
                System.out.println("Winner: " + partyName + " (" + partyCode + ") - Votes: " + votes +
                        " - Percentage of Total Votes: " + votePercentage + "%");
            }
            System.out.println(); // Add a blank line between constituencies
        }
    }

    private static double calculateVotePercentage(int votes, int totalVotes) {
        return ((double) votes / totalVotes) * 100;
    }


}
