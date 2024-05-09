package com.amaap.electionresult.repository.impl;

import com.amaap.electionresult.repository.electionDataRepository;

import java.util.ArrayList;
import java.util.List;

public class InMemoryElectionRepositoryData  implements electionDataRepository {
    private static InMemoryElectionRepositoryData instance;
    private final List<String> electionData = new ArrayList<>();

    private InMemoryElectionRepositoryData() {
    }

    public static synchronized InMemoryElectionRepositoryData getInstance() {
        if (instance == null) {
            instance = new InMemoryElectionRepositoryData();
        }
        return instance;
    }

    @Override
    public void inertIntoElectionData(String data) {
        electionData.add(data);
    }

    @Override
    public List<String> getElectionData() {
        return electionData;
    }

    public  void clear()
    {
        electionData.clear();
    }
}
