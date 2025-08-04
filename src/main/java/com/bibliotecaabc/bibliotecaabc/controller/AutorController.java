package com.bibliotecaabc.bibliotecaabc.controller;

import com.bibliotecaabc.bibliotecaabc.model.Autor;
import com.bibliotecaabc.bibliotecaabc.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/autor")

public class AutorController{

    @Autowired
    private AutorService autorService;

    //listar todas os autores
    @GetMapping("/findAll")
    public ResponseEntity<List<Autor>> listAll() {
        List<Autor> autors = autorService.findAll();
        return new ResponseEntity<>(autors, HttpStatus.OK);
    }

    //buscar autor por ID
    @GetMapping("/{id}")
    public ResponseEntity<Autor> findById(@PathVariable Integer id) {
        Autor autor = autorService.findById(id).orElse(null);
        if (autor != null) {
            return new ResponseEntity<>(autor, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //novo autor
    @PostMapping("/save")
    public ResponseEntity<Autor> save(@RequestBody Autor autor) {
        Autor newAutor = autorService.save(autor);
        return new ResponseEntity<>(newAutor, HttpStatus.CREATED);
    }

    //deletar
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        boolean isDeleted = autorService.delete(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //atualizar
    @PutMapping("/update/{id}")
    public ResponseEntity<Autor> update(@PathVariable Integer id, @RequestBody Autor autorUpdate) {
        Autor updateAutor = autorService.update(id, autorUpdate);
        if (updateAutor != null) {
            return new ResponseEntity<>(updateAutor, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}





