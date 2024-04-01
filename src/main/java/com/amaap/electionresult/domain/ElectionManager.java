package com.amaap.electionresult.domain;

import com.amaap.electionresult.io.DataExtractor;
import com.amaap.electionresult.io.Parser;
import com.amaap.electionresult.io.exception.EmptyFilepathException;
import com.amaap.electionresult.io.exception.IllegalFileFormatException;
import com.amaap.electionresult.io.exception.IllegalPartyNameException;
import com.amaap.electionresult.io.exception.NoDataFoundInFileException;
import com.amaap.electionresult.domain.model.ElectionDataAnalyser;

import java.io.IOException;
import java.util.Map;

public class ElectionManager {
    public boolean readFile(String filepath) throws NoDataFoundInFileException, IllegalFileFormatException, EmptyFilepathException, IOException, IllegalPartyNameException {
        DataExtractor dataExtractor = new DataExtractor();
        return dataExtractor.readFile(filepath);
    }

    public boolean processData(String path) throws IOException, IllegalPartyNameException {
        Parser parser = new Parser();
        return parser.processFile(path);
    }

    public boolean calculateVote(Map<String, Map<String, Integer>> resultMap) {

        ElectionDataAnalyser electionDataAnalyser = new ElectionDataAnalyser();
        electionDataAnalyser.getPartyNameWithMaxVote(resultMap);


        System.out.println(electionDataAnalyser.getWinnersData());
        if (electionDataAnalyser.getWinnersData().size() != 0) return true;

        return false;
    }

    public void displayWinner(Map<String, Map<String, Integer>> winnersData) {
        DisplayWinner displayWinner = new DisplayWinner();
        displayWinner.displayWinners(winnersData);

    }
}
