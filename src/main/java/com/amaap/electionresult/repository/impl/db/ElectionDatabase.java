package com.amaap.electionresult.repository.impl.db;

import java.util.List;

public interface ElectionDatabase {
    void insetIntoElectionDataTable(String data);
    
    List<String> getFromElectionDataTable();


    void clear();
}
