package com.amaap.electionresult.domain;

import com.amaap.electionresult.controller.ElectionController;
import com.amaap.electionresult.controller.FileController;
import com.amaap.electionresult.domain.service.ElectionResultAnalyser;
import com.amaap.electionresult.repository.impl.InMemoryElectionRepositoryData;
import com.amaap.electionresult.repository.impl.InMemoryElectionResultRepository;
import com.amaap.electionresult.service.ElectionService;
import com.amaap.electionresult.service.FileReaderService;
import com.amaap.electionresult.service.exception.InvalidPartyCodeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ElectionResultAnalyserTest {
    InMemoryElectionRepositoryData inMemoryElectionRepositoryData;
    InMemoryElectionResultRepository inMemoryElectionResultRepository;
    ElectionResultAnalyser electionResultAnalyser;
    ElectionService electionService;
    ElectionController electionController;

    @BeforeEach
    void setup() {
        inMemoryElectionRepositoryData = InMemoryElectionRepositoryData.getInstance();
        inMemoryElectionResultRepository = InMemoryElectionResultRepository.getInstance();
        electionResultAnalyser = new ElectionResultAnalyser(inMemoryElectionRepositoryData, inMemoryElectionResultRepository);
        electionService = new ElectionService(electionResultAnalyser);
        electionController = new ElectionController(electionService);
        inMemoryElectionRepositoryData.clear();
        inMemoryElectionResultRepository.clear();


    }

    @Test
    void shouldBeABleTOGetTheWinneOfConstituencyWhenListOfDataIsSent() throws InvalidPartyCodeException {
        // arrange
        FileReaderService fileReaderService = new FileReaderService();
        FileController fileController = new FileController(fileReaderService);
        String path = "D:\\ElectionResult\\src\\main\\resources\\electiondata.text";
        fileController.readFile(path);

        // act
        electionController.getWinner();
        boolean hasData = inMemoryElectionResultRepository.getWinnerData().size() != 0;

        // assert

        assertTrue(hasData);
    }

}