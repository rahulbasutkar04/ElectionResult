package com.amaap.electionresult.io;

import com.amaap.electionresult.io.exception.IllegalPartyNameException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {
    private Parser parser;

    @BeforeEach
    void setUp() {
        parser = new Parser();
    }

    @Test
    void shouldBeAbleToInitializeParserWithValidConfigurations() {
        // arrange
        String partyNamesFilePath = "D:\\ElectionResult\\src\\test\\DataFilesTest\\valid_party_names.yaml";
        String cityNamesFilePath = "D:\\ElectionResult\\src\\test\\DataFilesTest\\valid_city_names.yaml";

        // act & assert
        assertDoesNotThrow(() -> parser.initialize(partyNamesFilePath, cityNamesFilePath));
    }

    @Test
    void shouldThrowIOExceptionIfInvalidConfigurationsFilePath() {
        // arrange
        String invalidFilePath = "invalid_file_path.yaml";

        // act & assert
        assertThrows(IOException.class, () -> parser.initialize(invalidFilePath, invalidFilePath));
    }

    @Test
    void shouldBeAbleToProcessFileAndPopulateResultMap() throws IOException {
        // arrange
        String filePath = "D:\\ElectionResult\\src\\test\\DataFilesTest\\demo.txt";
        String partyNamesFilePath = "D:\\ElectionResult\\src\\test\\DataFilesTest\\valid_party_names.yaml";
        String cityNamesFilePath = "D:\\ElectionResult\\src\\test\\DataFilesTest\\valid_city_names.yaml";

        try {
            parser.initialize(partyNamesFilePath, cityNamesFilePath);
        } catch (IOException e) {
            fail("Initialization failed");
        }

        // act
        boolean result;
        try {
            result = parser.processFile(filePath);
        } catch (FileNotFoundException | IllegalPartyNameException e) {
            fail("Processing file failed");
            return;
        }

        // assert
        assertTrue(result);
        Map<String, Map<String, Integer>> resultMap = parser.getResultMap();
        assertNotNull(resultMap);
        assertFalse(resultMap.isEmpty());
    }


    @Test
    void shouldThrowIllegalPartyNameExceptionIfInvalidPartyName() {
        // arrange
        String filePath = "D:\\ElectionResult\\src\\test\\DataFilesTest\\demo2.txt";
        String partyNamesFilePath = "D:\\ElectionResult\\src\\test\\DataFilesTest\\valid_party_names.yaml";
        String cityNamesFilePath = "D:\\ElectionResult\\src\\test\\DataFilesTest\\valid_city_names.yaml";
        try {
            parser.initialize(partyNamesFilePath, cityNamesFilePath);
        } catch (IOException e) {
            fail("Initialization failed");
        }

        // act & assert
        assertThrows(IllegalPartyNameException.class, () -> parser.processFile(filePath));
    }
}