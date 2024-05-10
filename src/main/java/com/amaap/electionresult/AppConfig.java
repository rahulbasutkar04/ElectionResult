package com.amaap.electionresult;

import com.amaap.electionresult.controller.ElectionController;
import com.amaap.electionresult.controller.FileController;
import com.amaap.electionresult.repository.electionDataRepository;
import com.amaap.electionresult.repository.electionResultRepository;
import com.amaap.electionresult.repository.impl.InMemoryElectionRepositoryData;
import com.amaap.electionresult.repository.impl.InMemoryElectionResultRepository;
import com.amaap.electionresult.service.ElectionService;
import com.amaap.electionresult.service.FileReaderService;
import com.amaap.electionresult.domain.service.ElectionResultAnalyser;

public class AppConfig {
    public FileReaderService fileReaderService() {
        return new FileReaderService();
    }

    public electionDataRepository electionDataRepository() {
        return  InMemoryElectionRepositoryData.getInstance();
    }

    public electionResultRepository electionResultRepository() {
        return  InMemoryElectionResultRepository.getInstance();
    }

    public ElectionResultAnalyser electionResultAnalyser() {
        return new ElectionResultAnalyser((InMemoryElectionRepositoryData) electionDataRepository(), (InMemoryElectionResultRepository) electionResultRepository());
    }

    public ElectionService electionService() {
        return new ElectionService(electionResultAnalyser());
    }

    public ElectionController electionController() {
        return new ElectionController(electionService());
    }

    public FileController fileController() {
        return new FileController(fileReaderService());
    }
}
