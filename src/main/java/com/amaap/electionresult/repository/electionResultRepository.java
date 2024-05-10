package com.amaap.electionresult.repository;

import java.util.HashMap;

public interface electionResultRepository {
    void ConstituencyResult( HashMap<String, HashMap<String, Integer>> WinnerData);

    HashMap<String, HashMap<String, Integer>> getWinnerData();

    void clear();
}
