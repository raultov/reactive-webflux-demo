package com.ayoza.demoreactive;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MovieRepository extends ReactiveCrudRepository<Movie, String> {
    
}