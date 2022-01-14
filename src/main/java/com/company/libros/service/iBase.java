/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.libros.service;

import java.util.List;

/**
 *
 * @author Nathaly Zavala
 */
public interface iBase<T> {
    public List<T> listar();
    
    public void guardar();
    
    public void actualizar();
    
    public void eliminar();
    
}
