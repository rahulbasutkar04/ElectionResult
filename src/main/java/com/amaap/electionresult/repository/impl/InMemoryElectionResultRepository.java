package com.amaap.electionresult.repository.impl;

import com.amaap.electionresult.repository.electionResultRepository;
import com.amaap.electionresult.repository.impl.db.ElectionDatabase;
import com.amaap.electionresult.repository.impl.db.impl.InMemoryElectionFakeDatabase;

import java.util.HashMap;

public class InMemoryElectionResultRepository implements electionResultRepository {
    private static InMemoryElectionResultRepository instance;
    ElectionDatabase electionDatabase = new InMemoryElectionFakeDatabase();

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
        electionDatabase.insertIntoConstituencyResultData(WinnerData);

    }

    @Override
    public HashMap<String, HashMap<String, Integer>> getWinnerData() {
        return electionDatabase.getConstituencyData();
    }

    public void clear() {
        electionDatabase.clear();
    }
}
