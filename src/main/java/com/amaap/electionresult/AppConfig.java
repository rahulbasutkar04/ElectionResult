package com.amaap.electionresult;

import com.amaap.electionresult.controller.ElectionController;
import com.amaap.electionresult.controller.FileController;
import com.amaap.electionresult.repository.ElectionDataRepository;
import com.amaap.electionresult.repository.ElectionResultRepository;
import com.amaap.electionresult.repository.impl.InMemoryElectionRepositoryData;
import com.amaap.electionresult.repository.impl.InMemoryElectionResultRepository;
import com.amaap.electionresult.service.ElectionService;
import com.amaap.electionresult.service.io.FileReaderService;
import com.amaap.electionresult.domain.service.ElectionResultAnalyser;

public class AppConfig {
    public FileReaderService fileReaderService() {
        return new FileReaderService();
    }

    public ElectionDataRepository electionDataRepository() {
        return  InMemoryElectionRepositoryData.getInstance();
    }

    public ElectionResultRepository electionResultRepository() {
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