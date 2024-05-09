package com.amaap.electionresult.repository;


import java.util.List;

public interface electionDataRepository {

   void  inertIntoElectionData(String list);

   List<String> getElectionData();


}
