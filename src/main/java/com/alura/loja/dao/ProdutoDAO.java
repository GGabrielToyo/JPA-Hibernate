package com.alura.loja.dao;

import com.alura.loja.modelo.Produto;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class ProdutoDAO {
    private EntityManager em;

   public ProdutoDAO(EntityManager em){
        this.em = em;
    }

    public void cadastrar(Produto produto){
       this.em.persist(produto);
    }

    public Produto getPorId(Long id){
       return this.em.find(Produto.class, id);
    }

    public List<Produto> getAll(){
       String jpql = "SELECT p FROM Produto p";
       return this.em.createQuery(jpql, Produto.class).getResultList();
    }

    public List<Produto> getByName(String nome){
        String jpql = "SELECT p FROM Produto p WHERE p.nome = :nome";
        return this.em.createQuery(jpql, Produto.class)
                .setParameter("nome", nome)
                .getResultList();
    }

    public List<Produto> getByCategoryName(String nome){
        String jpql = "SELECT p FROM Produto p WHERE p.categoria.nome = ?1";
        return this.em.createQuery(jpql, Produto.class)
                .setParameter(1, nome)
                .getResultList();
    }

    public BigDecimal getPrecoByName(String nome){
        String jpql = "SELECT p.preco FROM Produto p WHERE p.nome = ?1";
        return this.em.createQuery(jpql, BigDecimal.class)
                .setParameter(1, nome)
                .getSingleResult();
    }

}
