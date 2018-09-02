package com.ayoza.demoreactive;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class DemoReactiveApplication {
    
    @Bean
    CommandLineRunner demoData(MovieRepository repo) {
        return args -> {
                Flux.just("Enter the Mono<Void>", "Back to the Future", "Flux Gordon",
                        "Meet the Fluxers", "The Fluxtice League", "Y Tu Mono tambien",
                        "Eon Flux", "The silence of the Lambdas")
                        .map(Movie::new)
                        .flatMap(repo::save)
                        .thenMany(repo.findAll())
                        .subscribe(System.out::println);
        };
    }
    
    @Bean
    RouterFunction<?> routes(MovieHandler handler) {
        return RouterFunctions.route(GET("/movies"), handler::all)
                .andRoute(GET("/movies/{id}"), handler::byId)
                .andRoute(GET("/movies/{id}/events"), handler::events);
    }

	public static void main(String[] args) {
		SpringApplication.run(DemoReactiveApplication.class, args);
	}
}
