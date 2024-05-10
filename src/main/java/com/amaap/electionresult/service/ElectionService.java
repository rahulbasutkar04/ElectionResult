package com.amaap.electionresult.service;

import com.amaap.electionresult.domain.service.ElectionResultAnalyser;
import com.amaap.electionresult.service.exception.InvalidPartyCodeException;

public class ElectionService {
    private final ElectionResultAnalyser electionResultAnalyser;


    public ElectionService(ElectionResultAnalyser electionResultAnalyser) {
        this.electionResultAnalyser = electionResultAnalyser;
    }

    public boolean getWinners() throws InvalidPartyCodeException {

        if (electionResultAnalyser.analyseWinner()) {
            return true;
        }
        return false;
    }
}
