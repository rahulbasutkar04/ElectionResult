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
        for (String constituency : winnersData.keySet()) {
            System.out.println("Constituency: " + constituency);
            Map<String, Integer> winnerInfo = winnersData.get(constituency);
            for (String partyCode : winnerInfo.keySet()) {
                String partyName = PartyCodes.getFullName(partyCode); // Corrected method invocation
                int votes = winnerInfo.get(partyCode);
                System.out.println("Winner: " + partyName + " (" + partyCode + ") - Votes: " + votes);
            }
            System.out.println(); // Add a blank line between constituencies
        }

    }

    public static void main(String[] args) throws NoDataFoundInFileException, IllegalFileFormatException, EmptyFilepathException, FileNotFoundException, IllegalPartyNameException {
        String path = "D:\\ElectionResult\\src\\test\\DataFilesTest\\demo.txt";
        DataExtractor dataExtractor = new DataExtractor();
        dataExtractor.readFile(path);

        // Retrieve winners data from VoteCalculator
        Map<String, Map<String, Integer>> winnersData = VoteCalculator.getWinnersData();

        // Display winners data
        DisplayWinner.displayWinners(winnersData);
    }
}
