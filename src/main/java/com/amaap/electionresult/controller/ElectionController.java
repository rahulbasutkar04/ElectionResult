package com.amaap.electionresult.controller;

import com.amaap.electionresult.controller.dto.HttpStatus;
import com.amaap.electionresult.controller.dto.Response;
import com.amaap.electionresult.service.ElectionService;
import com.amaap.electionresult.service.exception.ElectionResultException;

public class ElectionController {
    ElectionService electionService;


    public ElectionController(ElectionService electionService) {
        this.electionService = electionService;
    }

    public Response getWinner() throws ElectionResultException {
       if(electionService.getWinners())  return new Response(HttpStatus.OK,HttpStatus.OK.getMessage());
       else return new Response(HttpStatus.BAD_REQUEST,HttpStatus.BAD_REQUEST.getMessage());

    }
}
