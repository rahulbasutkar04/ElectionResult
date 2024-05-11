package com.amaap.electionresult.service;

import com.amaap.electionresult.repository.impl.InMemoryElectionRepositoryData;
import com.amaap.electionresult.service.exception.ElectionResultException;
import com.amaap.electionresult.service.exception.InvalidFilePathException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderServiceTest {

    InMemoryElectionRepositoryData inMemoryElectionRepositoryData;
    @BeforeEach
    void setup()
    {
        inMemoryElectionRepositoryData=InMemoryElectionRepositoryData.getInstance();
        inMemoryElectionRepositoryData.clear();
    }
    @Test
    void shouldBeAbleToReadTheDataInFile() throws ElectionResultException, IOException {
        // arrange
        FileReaderService fileReaderService = new FileReaderService();
        String path = "D:\\ElectionResult\\src\\main\\resources\\electiondata.text";

        // act
        boolean actual = fileReaderService.readFile(path);

        // assert
        assertTrue(actual);
    }

    @Test
    void shouldThrowExceptionIfGivenPathISNull() {
        // arrange
        FileReaderService fileReaderService = new FileReaderService();
        String path = null;

        // act & assert
        assertThrows(NullPointerException.class, () -> {
            fileReaderService.readFile(path);
        });

    }

    @Test
    void shouldThrowExceptionIfGivenPathISEmpty() {
        // arrange
        FileReaderService fileReaderService = new FileReaderService();
        String path = "";

        // act & assert
        assertThrows(InvalidFilePathException.class, () -> {
            fileReaderService.readFile(path);
        });
    }

    @Test
    void shouldThrowExceptionIfPathDoesNotHaveTheFile() {
        // arrange
        FileReaderService fileReaderService = new FileReaderService();
        String path = "D:\\ElectionResult\\src\\main\\resources\\doestntexiest.txt";

        // act & assert
        assertThrows(FileNotFoundException.class, () -> {
            fileReaderService.readFile(path);
        });
    }

    @Test
    void shouldBeAbleTOGetTheAddedDataFromTheRepositoryFromFile() throws ElectionResultException, IOException {
        // arrange
        FileReaderService fileReaderService = new FileReaderService();
        String path = "D:\\ElectionResult\\src\\main\\resources\\electiondata.text";

        // act
        fileReaderService.readFile(path);
        List<String> actual=inMemoryElectionRepositoryData.getElectionData();

        // assert
        assertEquals(2,actual.size());
    }

    @Test
    void shouldThrowExceptionIfFileHasInvalidDataFound()
    {
        // arrange
        FileReaderService fileReaderService = new FileReaderService();
        String path = "D:\\ElectionResult\\src\\main\\resources\\invalidElectionData.txt";

        // act & assert
         assertThrows(Exception.class, () -> {
            fileReaderService.readFile(path);
        });


    }

}