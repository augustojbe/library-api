package com.augustojbe.libraryapi.libraryapi.model;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
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

    @ManyToOne(
            //cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "id_autor")
    private Autor autor;



}
