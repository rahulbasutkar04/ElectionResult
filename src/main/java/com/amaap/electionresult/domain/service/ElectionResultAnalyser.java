package com.amaap.electionresult.domain.service;

import com.amaap.electionresult.domain.VoteCalculator;
import com.amaap.electionresult.repository.impl.InMemoryElectionRepositoryData;
import com.amaap.electionresult.repository.impl.InMemoryElectionResultRepository;

import java.util.HashMap;
import java.util.List;

public class ElectionResultAnalyser {
    private final InMemoryElectionRepositoryData inMemoryElectionRepositoryData;
    private  final InMemoryElectionResultRepository inMemoryElectionResultRepository;
    DataExtractor dataExtractor=new DataExtractor();

    public ElectionResultAnalyser(InMemoryElectionRepositoryData inMemoryElectionRepositoryData, InMemoryElectionResultRepository inMemoryElectionResultRepository) {
        this.inMemoryElectionRepositoryData = inMemoryElectionRepositoryData;
        this.inMemoryElectionResultRepository = inMemoryElectionResultRepository;
    }


    public boolean analyseWinner() {
        List<String> data=inMemoryElectionRepositoryData.getElectionData();
        for(int i=0;i<data.size();i++)
        {
            String line=data.get(i);
            HashMap<String, HashMap<String, Integer>> extractedData =dataExtractor.ExtractData(line);
            HashMap<String, HashMap<String, Integer>> WinnerData = VoteCalculator.calculateVotes(extractedData);
            inMemoryElectionResultRepository.ConstituencyResult(WinnerData);

        }

        return true;
    }


}
