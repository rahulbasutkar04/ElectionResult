package com.amaap.electionresult.models;

import com.amaap.electionresult.customeexceptions.EmptyFilepathException;
import com.amaap.electionresult.customeexceptions.IllegalFileFormatException;
import com.amaap.electionresult.customeexceptions.IllegalPartyNameException;
import com.amaap.electionresult.customeexceptions.NoDataFoundInFileException;
import com.amaap.electionresult.io.datafilereader.DataExtractor;

import java.io.FileNotFoundException;
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
