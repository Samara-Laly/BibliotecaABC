package com.bibliotecaabc.bibliotecaabc.service;

import com.bibliotecaabc.bibliotecaabc.model.Biblioteca;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BibliotecaService {
    private List<Biblioteca> bibliotecas = new ArrayList<>();

    //Retorna todas as bibliotecas
    public List<Biblioteca> findAll() {
        return bibliotecas;
    }
    //Retorna ima biblioteca por ID
    public Optional<Biblioteca> findById(int id){
        return bibliotecas.stream().filter(b ->b.getId() == id).findFirst();
    }

    //Salva uma nova biblioteca
    public Biblioteca save(Biblioteca biblioteca) {
        bibliotecas.add(biblioteca);
        return biblioteca;
    }
    // Atualiza os dados de uma biblioteca
    public Biblioteca update(int id, Biblioteca bibliotecaUpdate){
        Optional<Biblioteca> bibliotecaOpt = findById(id);
        if (bibliotecaOpt.isPresent()){
            Biblioteca biblioteca = bibliotecaOpt.get();
            biblioteca.setNome(bibliotecaUpdate.getNome());
            biblioteca.setTelefone(bibliotecaUpdate.getTelefone());
            return biblioteca;
        }
        return null;
    }
    public boolean delete(int id){
        return bibliotecas.removeIf(b ->b.getId() == id);
    }
}
