package com.amaap.electionresult.repository.impl.db.impl;

import com.amaap.electionresult.repository.impl.db.ElectionDatabase;

import java.util.ArrayList;
import java.util.List;

public class InMemoryElectionFakeDatabase  implements ElectionDatabase {
    private final List<String> electionData = new ArrayList<>();

    @Override
    public void insetIntoElectionDataTable(String data) {
        electionData.add(data);

    }

    @Override
    public List<String> getFromElectionDataTable() {
        return electionData;
    }

  public void clear()
    {
        electionData.clear();
    }
}
