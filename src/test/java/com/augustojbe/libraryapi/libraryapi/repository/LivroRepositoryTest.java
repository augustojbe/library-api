package com.augustojbe.libraryapi.libraryapi.repository;

import com.augustojbe.libraryapi.libraryapi.model.Autor;
import com.augustojbe.libraryapi.libraryapi.model.GeneroLivro;
import com.augustojbe.libraryapi.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;


@SpringBootTest
class LivroRepositoryTest {

    @Autowired
    LivroRepository repositpry;

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

    @Test
    void atualizarAutorLivro(){
        UUID id= UUID.fromString("8dfbaa98-dd75-4808-9a62-3e93ff577b29");
        var livroParaAtualizar = repositpry.findById(id).orElse(null);

        UUID idAutor= UUID.fromString("4becec97-2782-47e5-8df8-352f85e68db8");
        var autor = autorRepository.findById(idAutor).orElse(null);

        livroParaAtualizar.setAutor(autor);

        repositpry.save(livroParaAtualizar);

    }


    @Test
    void deletar(){
        UUID id= UUID.fromString("8dfbaa98-dd75-4808-9a62-3e93ff577b29");
        repositpry.deleteById(id);


    }

    @Test
    void deletarCascade(){
        UUID id= UUID.fromString("0057daec-74c8-4a35-a517-512a0e5cf60c");
        repositpry.deleteById(id);

    }

    @Test
    @Transactional
    void buscarLivroTest(){
        UUID id= UUID.fromString("d3a64e57-9172-47b1-bc89-5b42fe511027");
        Livro livro = repositpry.findById(id).orElse(null);
        System.out.println("Livro");
        System.out.println(livro.getTitulo());

        System.out.println("Autor");
        System.out.println(livro.getAutor().getNome());
    }



}