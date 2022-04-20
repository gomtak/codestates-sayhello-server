package com.codestateswebflux.handler;

import com.codestateswebflux.entity.Chats;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class WebfluxHandler {
    public Mono<ServerResponse> getChats(ServerRequest request) {

        String name = request.queryParam("name").get();
        Chats message = new Chats(name, "hello " + name);

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(message);
    }
}