package com.amaap.electionresult.repository.impl;

import com.amaap.electionresult.repository.electionDataRepository;
import com.amaap.electionresult.repository.impl.db.ElectionDatabase;
import com.amaap.electionresult.repository.impl.db.impl.InMemoryElectionFakeDatabase;

import java.util.List;

public class InMemoryElectionRepositoryData implements electionDataRepository {
    private static InMemoryElectionRepositoryData instance;
    ElectionDatabase electionDatabase = new InMemoryElectionFakeDatabase();


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
        electionDatabase.insetIntoElectionDataTable(data);
    }

    @Override
    public List<String> getElectionData() {
        return electionDatabase.getFromElectionDataTable();
    }

    public void clear() {
        electionDatabase.clear();
    }
}
