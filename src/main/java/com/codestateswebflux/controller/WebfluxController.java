package com.codestateswebflux.controller;

import com.codestateswebflux.entity.Chats;
import com.codestateswebflux.service.WebfluxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v0/chats")
public class WebfluxController {

    @Autowired
    WebfluxService webfluxService;

    @GetMapping
    public ResponseEntity getChat(){
        Chats chats = webfluxService.getMessage();
        return new ResponseEntity<>(chats, HttpStatus.OK);
    }
}
