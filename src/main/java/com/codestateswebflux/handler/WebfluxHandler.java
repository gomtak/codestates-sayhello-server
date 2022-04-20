package com.codestateswebflux.handler;

import com.codestateswebflux.entity.Chats;
import com.codestateswebflux.entity.Infos;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Component
public class WebfluxHandler {
    private final WebClient webClient;

    public WebfluxHandler(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<ServerResponse> getChats(ServerRequest request) {

        String name = request.queryParam("name").get();


        Mono<Infos> info = webClient.get()
                .uri(uriBuilder ->
                        uriBuilder.path("/info")
                                .build()
                ).retrieve().bodyToMono(Infos.class);

        Mono<String> job = info.map(i -> i.getJob()).log();

        Chats message = new Chats(name, "hello " + name, job.toString());


        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).bodyValue(message);
    }
}