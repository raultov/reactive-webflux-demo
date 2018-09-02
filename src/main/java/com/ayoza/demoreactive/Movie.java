package com.ayoza.demoreactive;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Table
@Data
@AllArgsConstructor
public class Movie {
        
    @PrimaryKey
    private String id;
    
    @NotEmpty
    @Column("title")
    private String title;
    
    Movie(String title) {
        this.id = title;
        this.title = title;
    }
}
