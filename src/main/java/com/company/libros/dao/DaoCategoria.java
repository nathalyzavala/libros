/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.libros.dao;

import com.company.libros.hibernate.HibernateUtil;
import com.company.libros.modelos.Categoria;
import com.company.libros.service.iBase;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nathaly Zavala
 */
public class DaoCategoria implements iBase {

    private SessionFactory sesfact;
    private Session ses;
    private Transaction tra;
    private Categoria categoria;

    private void iniciar() {
        sesfact = HibernateUtil.getSessionFactory();
        ses = sesfact.openSession();
        tra = ses.beginTransaction();
    }

    private void manejoException(HibernateException e) throws HibernateException {
        tra.rollback();
        throw new HibernateException("Ha ocurrido un error", e);
    }

    @Override
    public List<Categoria> listar() {
        List<Categoria> categorias = new ArrayList<>();
        try {
            iniciar();
            categorias = ses.createCriteria(Categoria.class).list();
            tra.commit();
        } catch (HibernateException e) {
            manejoException(e);
            throw e;
        } finally {
            ses.close();
        }
        return categorias;
    }

    @Override
    public void guardar() {
        try {
            iniciar();
            ses.save(categoria);
            tra.commit();
        } catch (HibernateException e) {
            manejoException(e);
            throw e;
        } finally {
            ses.close();
        }
    }

    @Override
    public void actualizar() {
        try {
            iniciar();
            ses.update(categoria);
            tra.commit();
        } catch (HibernateException e) {
            manejoException(e);
            throw e;
        } finally {
            ses.close();
        }
    }

    @Override
    public void eliminar() {
        try {
            iniciar();
            ses.delete(categoria);
            tra.commit();
        } catch (HibernateException e) {
            manejoException(e);
            throw e;
        } finally {
            ses.close();
        }
    }

}
