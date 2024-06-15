package com.amaap.electionresult.repository;


import java.util.List;

public interface ElectionDataRepository {

   void  inertIntoElectionData(String list);

   List<String> getElectionData();


}
