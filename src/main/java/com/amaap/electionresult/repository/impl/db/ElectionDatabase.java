package com.amaap.electionresult.repository.impl.db;

import java.util.HashMap;
import java.util.List;

public interface ElectionDatabase {
    void insetIntoElectionDataTable(String data);
    
    List<String> getFromElectionDataTable();


    void insertIntoConstituencyResultData(HashMap<String, HashMap<String, Integer>> WinnerData);

    HashMap<String, HashMap<String, Integer>> getConstituencyData();


    void clear();
}
