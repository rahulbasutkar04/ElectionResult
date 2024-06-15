package com.amaap.electionresult.repository.impl;

import com.amaap.electionresult.repository.ElectionDataRepository;
import com.amaap.electionresult.repository.impl.db.Database;
import com.amaap.electionresult.repository.impl.db.impl.FakeDatabase;

import java.util.List;

public class InMemoryElectionRepositoryData implements ElectionDataRepository {
    private static InMemoryElectionRepositoryData instance;
    Database database = new FakeDatabase();


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
        database.insetIntoElectionDataTable(data);
    }

    @Override
    public List<String> getElectionData() {
        return database.getFromElectionDataTable();
    }

    public void clear() {
        database.clear();
    }
}
