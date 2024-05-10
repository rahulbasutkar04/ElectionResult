package com.amaap.electionresult.service;

import com.amaap.electionresult.domain.service.ElectionResultAnalyser;
public class ElectionService {
    private  final ElectionResultAnalyser electionResultAnalyser;

    public ElectionService( ElectionResultAnalyser electionResultAnalyser) {
        this.electionResultAnalyser = electionResultAnalyser;
    }

    public  boolean getWinners() {
        return electionResultAnalyser.analyseWinner();
    }
}
