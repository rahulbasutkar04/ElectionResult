package com.amaap.electionresult.domain.service;

import com.amaap.electionresult.domain.model.PartyNameMapper;
import com.amaap.electionresult.repository.impl.InMemoryElectionResultRepository;

import java.util.HashMap;
import java.util.Map;

public class ResultAnnouncer {
    PartyNameMapper partyNameMapper = new PartyNameMapper();

    public void displayWinner() {
        InMemoryElectionResultRepository inMemoryElectionResultRepository = InMemoryElectionResultRepository.getInstance();
        HashMap<String, HashMap<String, Integer>> winnerData = inMemoryElectionResultRepository.getWinnerData();

        for (Map.Entry<String, HashMap<String, Integer>> entry : winnerData.entrySet()) {
            String city = entry.getKey();
            HashMap<String, Integer> partyVotes = entry.getValue();
            for (Map.Entry<String, Integer> partyEntry : partyVotes.entrySet()) {
                String partyCode = partyEntry.getKey();
                int votes = partyEntry.getValue();
                String partyName = partyNameMapper.getPartyFullName(partyCode);
                System.out.println("The Winner From " + city + " is" + ": " + partyName + " (" + partyCode + ") - with votes count is: " + votes);
            }
        }
    }
}
