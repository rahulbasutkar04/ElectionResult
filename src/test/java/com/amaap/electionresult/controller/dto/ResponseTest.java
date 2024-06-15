package com.amaap.electionresult.controller.dto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ResponseTest {
    @Test
    void shouldBeAbleToTestConstructor() {
        // arrange
        HttpStatus status = HttpStatus.OK;
        String message = "File Uploaded Successfully..";

        // act
        Response response = new Response(status, message);

        // assert
        assertEquals(status, response.getStatus());
        assertEquals(message, response.getMessage());
    }

    @Test
    void testGetStatus() {
        // arrange
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String message = "File Cannot Be Uploaded..";
        Response response = new Response(status, message);

        // act & assert
        assertEquals(status, response.getStatus());
    }

    @Test
    void testGetMessage() {
        // arrange
        HttpStatus status = HttpStatus.BAD_REQUEST;
        String message = "File Cannot Be Uploaded..";
        Response response = new Response(status, message);

        // act & assert
        assertEquals(message, response.getMessage());
    }

    @Test
    void testEquals() {
        // arrange
        Response response1 = new Response(HttpStatus.OK, "File Uploaded Successfully..");
        Response response2 = new Response(HttpStatus.OK, "File Uploaded Successfully..");
        Response response3 = new Response(HttpStatus.BAD_REQUEST, "File Cannot Be Uploaded..");

        // act & assert
        assertEquals(response1, response2);
        assertNotEquals(response1, response3);
        assertNotEquals(response2, response3);
    }

    @Test
    void testHashCode() {
        // arrange
        Response response1 = new Response(HttpStatus.OK, HttpStatus.OK.getMessage());
        Response response2 = new Response(HttpStatus.OK, HttpStatus.OK.getMessage());

        // act & assert
        assertEquals(response1.hashCode(), response2.hashCode());

    }

}