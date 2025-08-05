package com.pgrlv.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    private Integer count;
    @ManyToMany(mappedBy = "books")
    private List<Reader> readers;
}
