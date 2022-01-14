/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.libros.dao;

import com.company.libros.hibernate.HibernateUtil;
import com.company.libros.modelos.Autor;
import com.company.libros.modelos.Libro;
import com.company.libros.service.iBase;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Nathaly Zavala
 */
public class DaoLibro implements iBase{
    private SessionFactory sesfac;
    private Session ses;
    private Transaction tra;
    private Autor autor;
    
    private void iniciar(){
        sesfac = HibernateUtil.getSessionFactory();
        ses = sesfac.openSession();
        ses.beginTransaction();
    }
    
    private void manejoException(HibernateException e){
        tra.rollback();
        throw new HibernateException("Ha ocurrido un error", e);
    }

    @Override
    public List<Libro> listar() {
        List<Libro> libros = new ArrayList<>();
        try{
            iniciar();
            libros = ses.createCriteria(Libro.class).list();
            tra.commit();
        }catch(HibernateException e){
            manejoException(e);
            throw e;
        }finally{
            ses.close();
        }
        return libros;
    }

    @Override
    public void guardar() {
        try{
            iniciar();
            ses.save(autor);
            tra.commit();
        }catch(HibernateException e){
            manejoException(e);
            throw e;
        }finally{
            ses.close();
        }
    }

    @Override
    public void actualizar() {
        try{
            iniciar();
            ses.update(autor);
            tra.commit();
        }catch(HibernateException e){
            manejoException(e);
            throw e;
        }finally{
            ses.close();
        }
    }

    @Override
    public void eliminar() {
        try{
            iniciar();
            ses.delete(autor);
            tra.commit();
        }catch(HibernateException e){
            manejoException(e);
            throw e;
        }finally{
            ses.close();
        }
    }
 
    
}
