package com.bibliotecaabc.bibliotecaabc.model;

import lombok.Data;

@Data
public class Livro {
    private int Id;
    private String ISSN;
    private String titulo;
    private String sinopse;
    private int ano;
    private int numeroPagina;
}
