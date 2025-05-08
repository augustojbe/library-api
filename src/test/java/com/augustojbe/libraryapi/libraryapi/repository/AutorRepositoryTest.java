package com.augustojbe.libraryapi.libraryapi.repository;

import com.augustojbe.libraryapi.libraryapi.model.Autor;
import com.augustojbe.libraryapi.libraryapi.model.GeneroLivro;
import com.augustojbe.libraryapi.libraryapi.model.Livro;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootTest
public class AutorRepositoryTest {

    @Autowired
    AutorRepository repository;

    @Autowired
    LivroRepository livroRepository;

    @Test
    void salvarTest() {

        Autor autor = new Autor();
        autor.setNome("Maria");
        autor.setNacionalidade("Basileiro");
        autor.setDataNascimento(LocalDate.of(1987, 01, 20));

        var autorSalvo = repository.save(autor);
        System.out.println(autorSalvo);


    }

    @Test
    void atualizarTeste() {
        var id = UUID.fromString("8fe0b736-b1cb-4767-8cfe-356856e90532");

        Optional<Autor> possivelAutor = repository.findById(id);

        if (possivelAutor.isPresent()) {
            Autor autorEncontrado = possivelAutor.get();
            System.out.println("Dados do Autor");
            System.out.println(autorEncontrado);

            autorEncontrado.setDataNascimento(LocalDate.of(1957, 10, 10));

            repository.save(autorEncontrado);

        }
    }

    @Test
    void listarTodos() {
        List<Autor> lista = repository.findAll();
        lista.forEach(System.out::println);

    }

    @Test
    void countTest() {
        System.out.println("Contagem de Autores " + repository.count());
    }

    @Test
    void deletePorIdTest() {
        var id = UUID.fromString("8fe0b736-b1cb-4767-8cfe-356856e90532");

        repository.deleteById(id);

    }

    @Test
    void deleteTest() {
        var id = UUID.fromString("1fe68d2b-4ddb-4adf-8c68-a4ff6eaa34b2");
        var augusto = repository.findById(id).get();
        repository.delete(augusto);

    }

    @Test
    void salvarAutorLivroTest() {
        Autor autor = new Autor();
        autor.setNome("Antonio");
        autor.setNacionalidade("Americano");
        autor.setDataNascimento(LocalDate.of(1988, 01, 29));

        Livro livro = new Livro();
        livro.setIsbn("28887-84874");
        livro.setPreco(BigDecimal.valueOf(205));
        livro.setGenero(GeneroLivro.MISTERIOI);
        livro.setTitulo("O roubo de banco");
        livro.setDataPubicacao(LocalDate.of(1999, 10, 10));
        livro.setAutor(autor);

        Livro livro2 = new Livro();
        livro2.setIsbn("38887-84874");
        livro2.setPreco(BigDecimal.valueOf(205));
        livro2.setGenero(GeneroLivro.MISTERIOI);
        livro2.setTitulo("O roubo de banco Central");
        livro2.setDataPubicacao(LocalDate.of(2000, 10, 10));
        livro2.setAutor(autor);

        autor.setLivros(new ArrayList<>());
        autor.getLivros().add(livro);
        autor.getLivros().add(livro2);

        repository.save(autor);
        //livroRepository.saveAll(autor.getLivros());

    }


}
