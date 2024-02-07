package com.alura.loja.testes;

import com.alura.loja.dao.ClienteDAO;
import com.alura.loja.modelo.Cliente;
import com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;

public class CadastroClientes {
    public static void main(String[] args) {
        //cadastrarCliente();
        getCliente();
    }

    public static void cadastrarCliente(){
        EntityManager em = JPAUtil.getEntityManager();

        Cliente cliente = new Cliente("Gabriel Toyo", "12345678989");
        ClienteDAO clienteDAO = new ClienteDAO(em);

        em.getTransaction().begin();
        clienteDAO.cadastrar(cliente);
        em.getTransaction().commit();
        em.close();
    }

    public static void getCliente(){
        EntityManager em = JPAUtil.getEntityManager();
        ClienteDAO clienteDAO = new ClienteDAO(em);

        Cliente cliente = clienteDAO.getById(1l);
        System.out.println(cliente.getNome() + " " + cliente.getCpf());
    }
}
