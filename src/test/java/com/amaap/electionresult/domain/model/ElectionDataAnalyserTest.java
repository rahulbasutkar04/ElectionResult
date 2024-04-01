package com.amaap.electionresult.domain.model;

import com.amaap.electionresult.io.DataExtractor;
import com.amaap.electionresult.io.Parser;
import com.amaap.electionresult.io.exception.EmptyFilepathException;
import com.amaap.electionresult.io.exception.IllegalFileFormatException;
import com.amaap.electionresult.io.exception.IllegalPartyNameException;
import com.amaap.electionresult.io.exception.NoDataFoundInFileException;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElectionDataAnalyserTest {

    Parser parser = new Parser();

    @Test
    void shouldBeAbleToGetThePartyNameWithHigherVoteWithCityName() throws NoDataFoundInFileException, IllegalFileFormatException, EmptyFilepathException, IOException, IllegalPartyNameException {
        // arrange
        Map<String, Integer> bangaloreExpected = new HashMap<>();
        bangaloreExpected.put("BJP", 50);
        Map<String, Integer> puneExpected = new HashMap<>();
        puneExpected.put("INC", 90);
        Map<String, Integer> kolkataExpected = new HashMap<>();
        kolkataExpected.put("BJP", 1020);

        Map<String, Map<String, Integer>> expected = new HashMap<>();
        expected.put("Banglore", bangaloreExpected);
        expected.put("Pune", puneExpected);
        expected.put("Kolkata", kolkataExpected);
        DataExtractor dataExtractor = new DataExtractor();
        dataExtractor.readFile("D:\\ElectionResult\\src\\test\\DataFilesTest\\demo.txt");
        ElectionDataAnalyser electionDataAnalyser = new ElectionDataAnalyser();

        // act
        Map<String, Map<String, Integer>> actual = electionDataAnalyser.getPartyNameWithMaxVote(parser.getResultMap());

        // assert
        assertEquals(expected, actual);

    }
}
