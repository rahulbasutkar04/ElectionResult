package com.amaap.electionresult;

import com.amaap.electionresult.controller.ElectionController;
import com.amaap.electionresult.controller.FileController;
import com.amaap.electionresult.service.exception.ElectionResultException;
import com.amaap.electionresult.service.exception.InvalidPartyCodeException;

public class Main {
    public static void main(String[] args) throws ElectionResultException {
        AppConfig appConfig = new AppConfig();
        FileController fileController = appConfig.fileController();
        ElectionController electionController = appConfig.electionController();

        fileController.readFile("D:\\ElectionResult\\src\\main\\resources\\electiondata.text");
        electionController.getWinner();


    }
}