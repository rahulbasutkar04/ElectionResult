package com.amaap.electionresult.controller;

import com.amaap.electionresult.controller.dto.Http;
import com.amaap.electionresult.controller.dto.Response;
import com.amaap.electionresult.service.ElectionService;
import com.amaap.electionresult.service.exception.ElectionResultException;

public class ElectionController {
    ElectionService electionService;


    public ElectionController(ElectionService electionService) {
        this.electionService = electionService;
    }

    public Response getWinner() throws ElectionResultException {

        if (electionService.getWinners()) return new Response(Http.OK, Http.OK.getMessage());

        return new Response(Http.BAD_REQUEST, Http.BAD_REQUEST.getMessage());
    }
}
