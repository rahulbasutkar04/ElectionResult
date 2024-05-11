package com.amaap.electionresult.controller;

import com.amaap.electionresult.controller.dto.Http;
import com.amaap.electionresult.controller.dto.Response;
import com.amaap.electionresult.domain.service.ElectionResultAnalyser;
import com.amaap.electionresult.repository.impl.InMemoryElectionRepositoryData;
import com.amaap.electionresult.repository.impl.InMemoryElectionResultRepository;
import com.amaap.electionresult.service.ElectionService;
import com.amaap.electionresult.service.exception.ElectionResultException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ElectionControllerTest {
    ElectionService electionService;
    InMemoryElectionRepositoryData inMemoryElectionRepositoryData;
    InMemoryElectionResultRepository inMemoryElectionResultRepository;
    ElectionResultAnalyser electionResultAnalyser;

    @BeforeEach
    void setup() {
        inMemoryElectionRepositoryData = InMemoryElectionRepositoryData.getInstance();
        inMemoryElectionResultRepository = InMemoryElectionResultRepository.getInstance();
        electionResultAnalyser = new ElectionResultAnalyser(inMemoryElectionRepositoryData, inMemoryElectionResultRepository);
        electionService = new ElectionService(electionResultAnalyser);
        inMemoryElectionRepositoryData.clear();
        inMemoryElectionResultRepository.clear();
    }

    @Test
    void shouldBeAbleToRespondWithOkIFElectionDataIsProceededForGettingWinner() throws ElectionResultException {
        // arrange
        ElectionController electionController = new ElectionController(electionService);
        Response expected = new Response(Http.OK, Http.OK.getMessage());

        // act
        Response actual = electionController.getWinner();
        // assert
        assertEquals(expected, actual);

    }

    @Test
    void shouldBeAbleToRespondWithBadRequestIfElectionServiceReturnsFalse() throws ElectionResultException {
        // arrange
        ElectionService electionService = mock(ElectionService.class);
        ElectionController electionController = new ElectionController(electionService);
        when(electionService.getWinners()).thenReturn(false);

        // act
        Response actual = electionController.getWinner();

        // assert
        assertEquals(new Response(Http.BAD_REQUEST, Http.BAD_REQUEST.getMessage()), actual);
    }
}
