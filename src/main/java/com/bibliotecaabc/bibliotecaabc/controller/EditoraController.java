package com.bibliotecaabc.bibliotecaabc.controller;
import com.bibliotecaabc.bibliotecaabc.model.Editora;
import com.bibliotecaabc.bibliotecaabc.service.EditoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/editoras")

public class EditoraController{

    @Autowired
    private EditoraService editoraService;

    //listar todas as editoras
    @GetMapping("/findAll")
    public ResponseEntity<List<Editora>> listAll() {
        List<Editora> editoras = editoraService.findAll();
        return new ResponseEntity<>(editoras, HttpStatus.OK);
    }

    //buscar editoras por ID
    @GetMapping("/{id}")
    public ResponseEntity<Editora> findById(@PathVariable Integer id) {
        Editora editora = editoraService.findById(id).orElse(null);
        if (editora != null) {
            return new ResponseEntity<>(editora, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //novo editor
    @PostMapping("/save")
    public ResponseEntity<Editora> save(@RequestBody Editora editora) {
        Editora newEditora = editoraService.save(editora);
        return new ResponseEntity<>(newEditora, HttpStatus.CREATED);
    }

    //deletar
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        boolean isDeleted = editoraService.delete(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    //atualizar
    @PutMapping("/update/{id}")
    public ResponseEntity<Editora> update(@PathVariable Integer id, @RequestBody Editora editoraUpdate) {
        Editora updateEditora = editoraService.update(id, editoraUpdate);
        if (updateEditora != null) {
            return new ResponseEntity<>(updateEditora, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}





