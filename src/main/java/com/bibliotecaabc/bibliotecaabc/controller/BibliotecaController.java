package com.bibliotecaabc.bibliotecaabc.controller;

import com.bibliotecaabc.bibliotecaabc.model.Biblioteca;
import com.bibliotecaabc.bibliotecaabc.service.BibliotecaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/bibliotecas")

public class BibliotecaController{

    @Autowired
    private BibliotecaService bibliotecaService;

    //listar todas as bibliotecas
    @GetMapping
    public ResponseEntity<List<Biblioteca>> listAll() {
        List<Biblioteca> bibliotecas = bibliotecaService.findAll();
        return new ResponseEntity<>(bibliotecas, HttpStatus.OK);
    }

    //buscar biblioteca por ID
    @GetMapping("/{id}")
    public ResponseEntity<Biblioteca> findById(@PathVariable Integer id) {
        Biblioteca biblioteca = bibliotecaService.findById(id).orElse(null);
        if (biblioteca != null) {
            return new ResponseEntity<>(biblioteca, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //nova biblioteca
    @PostMapping("/save")
    public ResponseEntity<Biblioteca> save(@RequestBody Biblioteca biblioteca) {
        Biblioteca newBiblioteca = bibliotecaService.save(biblioteca);
        return new ResponseEntity<>(newBiblioteca, HttpStatus.CREATED);
    }

    //deletar
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        boolean isDeleted = bibliotecaService.delete(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

        //atualizar
        @PutMapping("/update/{id}")
        public ResponseEntity<Biblioteca> update(@PathVariable Integer id, @RequestBody Biblioteca bibliotecaUpdate) {
            Biblioteca updatedBiblioteca = bibliotecaService.update(id, bibliotecaUpdate);
            if (updatedBiblioteca != null) {
                return new ResponseEntity<>(updatedBiblioteca, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        }





