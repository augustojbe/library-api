package com.augustojbe.libraryapi.libraryapi.repository;

import com.augustojbe.libraryapi.libraryapi.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;


public interface LivroRepository extends JpaRepository<Livro, UUID> {

}
