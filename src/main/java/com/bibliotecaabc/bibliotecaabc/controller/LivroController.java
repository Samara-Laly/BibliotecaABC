package com.bibliotecaabc.bibliotecaabc.controller;

import com.bibliotecaabc.bibliotecaabc.model.Biblioteca;
import com.bibliotecaabc.bibliotecaabc.model.Livro;
import com.bibliotecaabc.bibliotecaabc.service.BibliotecaService;
import com.bibliotecaabc.bibliotecaabc.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/livros")

public class LivroController{

    @Autowired
    private LivroService livroService;

    //listar todas os livros
    @GetMapping("/findAll")
    public ResponseEntity<List<Livro>> listAll() {
        List<Livro> livros = livroService.findAll();
        return new ResponseEntity<>(livros, HttpStatus.OK);
    }

    //buscar livro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable Integer id) {
        Livro livro = livroService.findById(id).orElse(null);
        if (livro != null) {
            return new ResponseEntity<>(livro, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //novo livro
    @PostMapping("/save")
    public ResponseEntity<Livro> save(@RequestBody Livro livro) {
        Livro newLivro = livroService.save(livro);
        return new ResponseEntity<>(newLivro, HttpStatus.CREATED);
    }

    //deletar
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        boolean isDeleted = livroService.delete(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //atualizar
    @PutMapping("/update/{id}")
    public ResponseEntity<Livro> update(@PathVariable Integer id, @RequestBody Livro livroUpdate) {
        Livro updateLivro = livroService.update(id, livroUpdate);
        if (updateLivro != null) {
            return new ResponseEntity<>(updateLivro, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}





