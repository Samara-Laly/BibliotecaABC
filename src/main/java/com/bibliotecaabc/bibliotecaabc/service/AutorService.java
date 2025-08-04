package com.bibliotecaabc.bibliotecaabc.service;

import com.bibliotecaabc.bibliotecaabc.model.Autor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    private List<Autor> autors = new ArrayList<>();

    //Retorna todas as Autores
    public List<Autor> findAll() {
        return autors;
    }
    //Retorna autor por ID
    public Optional<Autor> findById(int id){
        return autors.stream().filter(b ->b.getId() == id).findFirst();
    }

    //Salva um novo autor
    public Autor save(Autor autor) {
        autors.add(autor);
        return autor;
    }
    // Atualiza os dados do autor
    public Autor update(int id, Autor autorUpdate){
        Optional<Autor> autorOpt = findById(id);
        if (autorOpt.isPresent()){
            Autor autor = autorOpt.get();
            autor.setNome(autorUpdate.getNome());
            autor.setCpf(autorUpdate.getCpf());
            autor.setIdade(autorUpdate.getIdade());
            return autor;
        }
        return null;
    }
    public boolean delete(int id){
        return autors.removeIf(b ->b.getId() == id);
    }
}
