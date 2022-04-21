package com.codestateswebflux.handler;

import com.codestateswebflux.entity.Chats;
import com.codestateswebflux.entity.Infos;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class WebfluxHandler {
    private final WebClient webClient = WebClient.create("http://localhost:8081");

    public Mono<ServerResponse> getChats(ServerRequest request) {

        String name = request.queryParam("name").get();

        Mono<Map> info = webClient.get()
                .uri("/info")
                .retrieve().bodyToMono(Map.class);
        Mono<Chats> message = info.map(m-> new Chats(name,"hello " + name, (String) m.get("job")));

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(message,Chats.class);
    }
}