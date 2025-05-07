package com.augustojbe.libraryapi.libraryapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "livro")
public class Livro implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String isbn;

    @Column(nullable = false, length = 150)
    private String titulo;

    @Column(name = "data_publicacao")
    private LocalDate dataPubicacao;

    @Column(nullable = false, length = 30)
    @Enumerated(EnumType.STRING)
    private GeneroLivro genero;

    @Column(precision = 18, scale = 2)
    private BigDecimal preco;

    @ManyToOne//(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_autor")
    private Autor autor;



}
