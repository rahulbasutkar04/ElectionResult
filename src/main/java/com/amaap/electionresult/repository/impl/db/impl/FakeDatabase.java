package com.amaap.electionresult.repository.impl.db.impl;

import com.amaap.electionresult.repository.impl.db.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FakeDatabase implements Database {
    private final List<String> electionData = new ArrayList<>();

   private final  HashMap<String, HashMap<String, Integer>> constituencyData=new HashMap<>();

    @Override
    public void insetIntoElectionDataTable(String data) {
        electionData.add(data);

    }

    @Override
    public List<String> getFromElectionDataTable() {
        return electionData;
    }

    @Override
    public void insertIntoConstituencyResultData(HashMap<String, HashMap<String, Integer>> WinnerData) {
        constituencyData.putAll(WinnerData);

    }

    @Override
    public HashMap<String, HashMap<String, Integer>> getConstituencyData() {
        return constituencyData;
    }

    public void clear()
    {
        electionData.clear();
        constituencyData.clear();
    }
}
