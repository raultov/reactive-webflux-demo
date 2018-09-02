package com.ayoza.demoreactive;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class MovieHandler {

    private final MovieService svc;
    
    public Mono<ServerResponse> all(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(svc.getAllMovies(), Movie.class);
    }
    
    public Mono<ServerResponse> byId(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .body(svc.getMovieById(serverRequest.pathVariable("id")), Movie.class);
    }
    
    public Mono<ServerResponse> events(ServerRequest serverRequest) {
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(svc.getEventsForMovie(serverRequest.pathVariable("id")), MovieEvent.class);
    }
}
