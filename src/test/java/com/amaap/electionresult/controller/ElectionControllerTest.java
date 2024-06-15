package com.amaap.electionresult.controller;

import com.amaap.electionresult.controller.dto.HttpStatus;
import com.amaap.electionresult.controller.dto.Response;
import com.amaap.electionresult.domain.service.ElectionResultAnalyser;
import com.amaap.electionresult.repository.impl.InMemoryElectionRepositoryData;
import com.amaap.electionresult.repository.impl.InMemoryElectionResultRepository;
import com.amaap.electionresult.service.ElectionService;
import com.amaap.electionresult.service.exception.ElectionResultException;
import com.amaap.electionresult.service.io.FileReaderService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ElectionControllerTest {
    ElectionService electionService;
    InMemoryElectionRepositoryData inMemoryElectionRepositoryData;
    InMemoryElectionResultRepository inMemoryElectionResultRepository;
    ElectionResultAnalyser electionResultAnalyser;
    ElectionController electionController;
    FileController fileController;
    FileReaderService fileReaderService;

    @BeforeEach
    void setup() {
        inMemoryElectionRepositoryData = InMemoryElectionRepositoryData.getInstance();
        inMemoryElectionResultRepository = InMemoryElectionResultRepository.getInstance();
        electionResultAnalyser = new ElectionResultAnalyser(inMemoryElectionRepositoryData, inMemoryElectionResultRepository);
        fileReaderService = new FileReaderService();
        fileController = new FileController(fileReaderService);
        electionService = new ElectionService(electionResultAnalyser);
        electionController = new ElectionController(electionService);

        inMemoryElectionRepositoryData.clear();
        inMemoryElectionResultRepository.clear();
    }

    @Test
    void shouldBeAbleToRespondWithOkIFElectionDataIsProceededForGettingWinner() throws ElectionResultException, IOException {

        String path = "D:\\ElectionResult\\src\\main\\resources\\electiondata.text";
        fileReaderService.readFile(path);
        Response expected = new Response(HttpStatus.OK, HttpStatus.OK.getMessage());
        Response actual = electionController.getWinner();

        assertEquals(expected, actual);

    }

    @Test
    void shouldBeAbleToRespondWithBadRequestIfElectionServiceReturnsFalse() throws ElectionResultException, IOException {
        // arrange
        String path = "D:\\ElectionResult\\src\\main\\resources\\invalidElectionData.txt";
        fileReaderService.readFile(path);
        Response expected = new Response(HttpStatus.BAD_REQUEST, HttpStatus.BAD_REQUEST.getMessage());
        // act
        Response actual = electionController.getWinner();

        // assert
        assertEquals(expected, actual);
    }
}
