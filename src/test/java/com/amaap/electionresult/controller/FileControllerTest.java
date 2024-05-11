package com.amaap.electionresult.controller;

import com.amaap.electionresult.controller.dto.Http;
import com.amaap.electionresult.controller.dto.Response;
import com.amaap.electionresult.repository.impl.InMemoryElectionRepositoryData;
import com.amaap.electionresult.service.FileReaderService;
import com.amaap.electionresult.service.exception.ElectionResultException;
import com.amaap.electionresult.service.exception.InvalidFilePathException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileControllerTest {

    FileReaderService fileReaderService;
    InMemoryElectionRepositoryData inMemoryElectionRepositoryData;

    @BeforeEach
    void setup() {
        inMemoryElectionRepositoryData = InMemoryElectionRepositoryData.getInstance();
        fileReaderService = new FileReaderService();
        inMemoryElectionRepositoryData.clear();
    }

    @Test
    void shouldBeAbleToRespondWithOkMessageIfFileISTakenFromUser() throws ElectionResultException, IOException {
        // arrange
        FileController fileController = new FileController(fileReaderService);
        Response expected = new Response(Http.OK, Http.OK.getMessage());
        String path = "D:\\ElectionResult\\src\\main\\resources\\electiondata.text";

        // act
        Response actual = fileController.readFile(path);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleToRespondWithBadRequestMessageIfGivenFilePathIsNotProceeded()  {
        // arrange
        FileController fileController = new FileController(fileReaderService);
        Response expected = new Response(Http.BAD_REQUEST, Http.BAD_REQUEST.getMessage());
        String path = "D:\\ElectionResult\\src\\main\\resources\\invalidElectionData.txt";

        // act
        Response actual = fileController.readFile(path);

        // assert
        assertEquals(expected, actual);
    }

}
