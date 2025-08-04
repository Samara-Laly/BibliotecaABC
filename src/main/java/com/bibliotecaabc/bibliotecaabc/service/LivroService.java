package com.bibliotecaabc.bibliotecaabc.service;
import com.bibliotecaabc.bibliotecaabc.model.Livro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LivroService {
    private List<Livro> livros = new ArrayList<>();

    //Retorna todos os livro
    public List<Livro> findAll() {
        return livros;
    }
    //Retorna um livro por ID
    public Optional<Livro> findById(int id){
        return livros.stream().filter(b ->b.getId() == id).findFirst();
    }

    //Salva um novo livro
    public Livro save(Livro livro) {
        livros.add(livro);
        return livro;
    }
    // Atualiza os dados de um livro
    public Livro update(int id, Livro livroUpdate){
        Optional<Livro> livroOpt = findById(id);
        if (livroOpt.isPresent()){
            Livro livro = livroOpt.get();
            livro.setISSN(livroUpdate.getISSN());
            livro.setAno(livroUpdate.getAno());
            livro.setTitulo(livroUpdate.getTitulo());
            livro.setSinopse(livroUpdate.getSinopse());
            livro.setNumeroPagina(livroUpdate.getNumeroPagina());
            return livro;
        }
        return null;
    }
    public boolean delete(int id){
        return livros.removeIf(b ->b.getId() == id);
    }
}
