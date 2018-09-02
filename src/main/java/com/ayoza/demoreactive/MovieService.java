package com.ayoza.demoreactive;

import java.time.Duration;
import java.time.Instant;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class MovieService {

    private final MovieRepository repo;
    
    Flux<Movie> getAllMovies() {
        return repo.findAll();
    }
    
    Mono<Movie> getMovieById(String id) {
        return repo.findById(id);
    }
    
    Flux<MovieEvent> getEventsForMovie(String movieId) {
        return Flux.<MovieEvent>generate(sink -> sink.next(new MovieEvent(movieId, Instant.now())))
                .delayElements(Duration.ofSeconds(1));
    }
}
