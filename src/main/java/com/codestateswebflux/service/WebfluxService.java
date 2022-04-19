package com.codestateswebflux.service;

import com.codestateswebflux.entity.Chats;
import org.springframework.stereotype.Service;

@Service
public class WebfluxService {

    public Chats getMessage(){
        return new Chats("name","message");
    }
}
