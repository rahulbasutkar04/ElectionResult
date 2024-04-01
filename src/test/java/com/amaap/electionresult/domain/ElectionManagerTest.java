package com.amaap.electionresult.domain;

import com.amaap.electionresult.domain.model.ElectionDataAnalyser;
import com.amaap.electionresult.io.Parser;
import com.amaap.electionresult.io.exception.EmptyFilepathException;
import com.amaap.electionresult.io.exception.IllegalFileFormatException;
import com.amaap.electionresult.io.exception.IllegalPartyNameException;
import com.amaap.electionresult.io.exception.NoDataFoundInFileException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ElectionManagerTest {
    private static Parser parser;

    @BeforeAll
    static void setUpParser() throws IOException {
        String partyNamesFilePath = "D:\\ElectionResult\\src\\test\\java\\com\\amaap\\electionresult\\configuration\\valid_party_names.yaml";
        String cityNamesFilePath = "D:\\ElectionResult\\src\\test\\java\\com\\amaap\\electionresult\\configuration\\valid_city_names.yaml";
        parser = new Parser();
        parser.initialize(partyNamesFilePath, cityNamesFilePath);
    }

    @Test
    void shouldBeAbleToTakeFileInputFromUser() throws NoDataFoundInFileException, IllegalFileFormatException, EmptyFilepathException, IOException, IllegalPartyNameException {
        // arrange
        ElectionManager electionManager = new ElectionManager();

        // act
        boolean actual = electionManager.readFile("D:\\ElectionResult\\src\\test\\DataFilesTest\\demo.txt");

        // assert
        assertTrue(actual);
    }

    @Test
    void shouldBeAbleToProcessTheDataInWellFormat() throws IOException, IllegalPartyNameException {
        // arrange
        ElectionManager electionManager = new ElectionManager();

        // act
        boolean actual = electionManager.processData("D:\\ElectionResult\\src\\test\\DataFilesTest\\demo.txt");

        // assert
        assertTrue(actual);
    }

    @Test
    void shouldBeAbleToCalculateVote() throws IOException, IllegalPartyNameException {
        // arrange
        Parser parser = new Parser();
        ElectionManager electionManager = new ElectionManager();
        electionManager.processData("D:\\ElectionResult\\src\\test\\DataFilesTest\\demo.txt");

        // act
        boolean actual = electionManager.calculateVote(parser.getResultMap());

        // assert
        assertTrue(actual);
    }

    @Test
    void shouldBeAbleToDisplayResult() throws IOException, IllegalPartyNameException {
        // arrange
        Parser parser = new Parser();
        ElectionManager electionManager = new ElectionManager();
        electionManager.processData("D:\\ElectionResult\\src\\test\\DataFilesTest\\demo.txt");
        electionManager.calculateVote(parser.getResultMap());

        // act
        electionManager.displayWinner(ElectionDataAnalyser.getWinnersData());

    }
}
