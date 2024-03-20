package com.amaap.electionresult.models;

import com.amaap.electionresult.customeexceptions.EmptyFilepathException;
import com.amaap.electionresult.customeexceptions.IllegalFileFormatException;
import com.amaap.electionresult.customeexceptions.IllegalPartyNameException;
import com.amaap.electionresult.customeexceptions.NoDataFoundInFileException;
import com.amaap.electionresult.io.datafilereader.DataExtractor;
import com.amaap.electionresult.io.datafilereader.DataProcessor;

import java.io.FileNotFoundException;
import java.util.Map;

public class ElectionManager {
    public boolean readFile(String filepath) throws NoDataFoundInFileException, IllegalFileFormatException, EmptyFilepathException, FileNotFoundException, IllegalPartyNameException {
        DataExtractor dataExtractor=new DataExtractor();
        return dataExtractor.readFile(filepath);
    }

    public boolean processData(String path) throws FileNotFoundException, IllegalPartyNameException {
        DataProcessor dataProcessor=new DataProcessor();
        return dataProcessor.processor(path);
    }

    public boolean calculateVote(Map<String, Map<String, Integer>> resultMap) {


        VoteCalculator voteCalculator=new VoteCalculator();
        voteCalculator.getPartyNameWithMaxVote(resultMap);


        System.out.println(voteCalculator.getWinnersData());
        if(voteCalculator.getWinnersData().size()!=0) return true;


        return false;

    }

    public void displayWinner(Map<String, Map<String, Integer>> winnersData) {

        DisplayWinner displayWinner=new DisplayWinner();
        displayWinner.displayWinners(winnersData);

    }
}
