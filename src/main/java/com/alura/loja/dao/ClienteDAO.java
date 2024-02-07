package com.alura.loja.dao;

import com.alura.loja.modelo.Cliente;
import com.alura.loja.modelo.Pedido;

import javax.persistence.EntityManager;

public class ClienteDAO {

    private EntityManager em;

    public ClienteDAO(EntityManager em){
        this.em = em;
    }

    public void cadastrar(Cliente cliente){
        this.em.persist(cliente);
    }

    public Cliente getById(Long id){
        return this.em.find(Cliente.class, id);
    }
}
