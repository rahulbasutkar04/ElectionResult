package com.amaap.electionresult.repository.impl;

import com.amaap.electionresult.repository.ElectionResultRepository;
import com.amaap.electionresult.repository.impl.db.Database;
import com.amaap.electionresult.repository.impl.db.impl.FakeDatabase;

import java.util.HashMap;

public class InMemoryElectionResultRepository implements ElectionResultRepository {
    private static InMemoryElectionResultRepository instance;
    Database database = new FakeDatabase();

    private InMemoryElectionResultRepository() {
    }

    public static synchronized InMemoryElectionResultRepository getInstance() {
        if (instance == null) {
            instance = new InMemoryElectionResultRepository();
        }
        return instance;
    }

    @Override
    public void ConstituencyResult(HashMap<String, HashMap<String, Integer>> WinnerData) {
        database.insertIntoConstituencyResultData(WinnerData);

    }

    @Override
    public HashMap<String, HashMap<String, Integer>> getWinnerData() {
        return database.getConstituencyData();
    }

    public void clear() {
        database.clear();
    }
}
