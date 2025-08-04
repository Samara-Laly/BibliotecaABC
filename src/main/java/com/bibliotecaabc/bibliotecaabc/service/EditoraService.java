package com.bibliotecaabc.bibliotecaabc.service;
import com.bibliotecaabc.bibliotecaabc.model.Editora;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EditoraService {
    private List<Editora> editoras = new ArrayList<>();

    //Retorna todas as editoras
    public List<Editora> findAll() {
        return editoras;
    }
    //Retorna editora por ID
    public Optional<Editora> findById(int id){
        return editoras.stream().filter(b ->b.getId() == id).findFirst();
    }

    //Salva um novo editor
    public Editora save(Editora editora) {
        editoras.add(editora);
        return editora;
    }
    // Atualiza os dados do editor
    public Editora update(int id, Editora editoraUpdate){
        Optional<Editora> editoraOpt = findById(id);
        if (editoraOpt.isPresent()){
            Editora editora = editoraOpt.get();
            editora.setNome(editoraUpdate.getNome());
            editora.setEndereco(editoraUpdate.getEndereco());
            editora.setTelefone(editoraUpdate.getTelefone());

            return editora;
        }
        return null;
    }
    public boolean delete(int id){
        return editoras.removeIf(b ->b.getId() == id);
    }
}
