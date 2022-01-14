/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.libros.controller;

import com.company.libros.dao.DaoAutor;
import com.company.libros.dao.DaoLibro;
import com.company.libros.modelos.Autor;
import com.company.libros.modelos.Libro;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

/**
 *
 * @author Nathaly Zavala
 */
@ManagedBean(name = "cautor", eager = true)
@ViewScoped
public class AutorController implements Serializable {
    private List<Autor> autores = null;
    DaoAutor daoAutor = new DaoAutor();

    @PostConstruct
    public void init() {        
        allAutores();
    }
    
    public List<Autor> allAutores(){
        autores = daoAutor.listar();
        return autores;
    }

    public List<Autor> getAutores() {
        return autores;
    }

   
}
