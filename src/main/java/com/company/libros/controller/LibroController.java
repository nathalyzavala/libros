/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.libros.controller;

import com.company.libros.dao.DaoLibro;
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
@ManagedBean(name = "clibro", eager = true)
@ViewScoped
public class LibroController implements Serializable{
    private List<Libro> libros;
    private DaoLibro daoLibro;
    
    @PostConstruct
    public void init(){
        daoLibro = new DaoLibro();
        libros = daoLibro.listar();
    }

    public List<Libro> getLibros() {
        return libros;
    }
    
    
}
