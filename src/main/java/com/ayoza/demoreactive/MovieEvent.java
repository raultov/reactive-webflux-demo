package com.ayoza.demoreactive;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MovieEvent {
    private String movieId;
    private Instant date;
}
