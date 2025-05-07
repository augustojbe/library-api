package com.augustojbe.libraryapi.libraryapi.repository;

import com.augustojbe.libraryapi.libraryapi.model.Autor;
import com.augustojbe.libraryapi.libraryapi.model.GeneroLivro;
import com.augustojbe.libraryapi.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;


@SpringBootTest
class LivroRepositpryTest {

    @Autowired
    LivroRepositpry repositpry;

    @Autowired
    AutorRepository autorRepository;

    @Test
    void salvarLivro(){
        Livro livro = new Livro();
        livro.setIsbn("90887-84874");
        livro.setPreco(BigDecimal.valueOf(102));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("Vasco");
        livro.setDataPubicacao(LocalDate.of(1950, 10, 10));

        Autor autor = autorRepository.findById(UUID.fromString("4becec97-2782-47e5-8df8-352f85e68db8")).orElse(null);


        livro.setAutor(new Autor());

        repositpry.save(livro);
    }

    @Test
    void salvarAutorELivroTest(){

        Livro livro = new Livro();
        livro.setIsbn("90887-84874");
        livro.setPreco(BigDecimal.valueOf(102));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("Vasco");
        livro.setDataPubicacao(LocalDate.of(1950, 10, 10));

        Autor autor = new Autor();
        autor.setNome("Augusto");
        autor.setNacionalidade("Basileiro");
        autor.setDataNascimento(LocalDate.of(1988, 01, 20));

        autorRepository.save(autor);

        livro.setAutor(autor);

        repositpry.save(livro);

    }

    @Test
    void salvarCascadeTest(){

        Livro livro = new Livro();
        livro.setIsbn("90887-84874");
        livro.setPreco(BigDecimal.valueOf(102));
        livro.setGenero(GeneroLivro.FICCAO);
        livro.setTitulo("Botafogo");
        livro.setDataPubicacao(LocalDate.of(1950, 10, 10));

        Autor autor = new Autor();
        autor.setNome("Fernando");
        autor.setNacionalidade("Basileiro");
        autor.setDataNascimento(LocalDate.of(1990, 01, 20));

        livro.setAutor(autor);

        repositpry.save(livro);

    }

}