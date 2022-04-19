package com.codestateswebflux.handler;

import com.codestateswebflux.entity.Chats;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class WebfluxHandler {
    public Mono<ServerResponse> getChats(ServerRequest request) {
        Mono<Chats> chatsMono = Mono.just(new Chats("name","message"));
        return ServerResponse.ok().body(chatsMono, Chats.class);
    }
}