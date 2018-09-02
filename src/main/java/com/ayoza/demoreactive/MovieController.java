package com.ayoza.demoreactive;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@RestController
@RequestMapping("/movies")
@RequiredArgsConstructor
public class MovieController {

    private final MovieService svc;
    
    @GetMapping
    Flux<Movie> all() {
        return svc.getAllMovies();
    }
    
    @GetMapping("/{id}")
    Mono<Movie> byId(@PathVariable String id) {
        return svc.getMovieById(id);
    }
    
    @GetMapping(value = "/{id}/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    Flux<MovieEvent> events(@PathVariable String id) {
        return svc.getEventsForMovie(id);
    }
}
