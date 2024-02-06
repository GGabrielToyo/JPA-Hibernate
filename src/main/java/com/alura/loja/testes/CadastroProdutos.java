package com.alura.loja.testes;

import com.alura.loja.dao.CategoriaDAO;
import com.alura.loja.dao.ProdutoDAO;
import com.alura.loja.modelo.Categoria;
import com.alura.loja.modelo.Produto;
import com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

public class CadastroProdutos {
    public static void main(String[] args) {
        //cadastrarProduto();
        //getProduto();
        //buscarTodosProdutos();
        //buscarPorNome();
        //buscarPorCategoria();
        buscarPrecoPorNome(); 
    }

    public static void cadastrarProduto(){
        EntityManager em = JPAUtil.getEntityManager();

        Categoria celurares = new Categoria("CELULARES");
        CategoriaDAO categoriaDao = new CategoriaDAO(em);

        Produto celular = new Produto("Iphone 15", "O melhor 15", new BigDecimal("12500"), celurares);
        ProdutoDAO produtoDao = new ProdutoDAO(em);

        em.getTransaction().begin();
        categoriaDao.cadastrar(celurares);
        produtoDao.cadastrar(celular);
        em.getTransaction().commit();
        em.close();
    }

    public static void getProduto(){
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDao = new ProdutoDAO(em);

        Produto produto = produtoDao.getPorId(1l);
        System.out.println(produto.getNome() + ", " + produto.getDescricao() + ", " + produto.getPreco());
    }

    public static void buscarTodosProdutos(){
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDao = new ProdutoDAO(em);

        List<Produto> produtosList = produtoDao.getAll();
        produtosList.forEach(p -> {
            System.out.println(p.getNome() + ", " + p.getDescricao() + ", " + p.getPreco());
        });
    }

    public static void buscarPorNome(){
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDao = new ProdutoDAO(em);

        List<Produto> produtosList = produtoDao.getByName("Motorola");
        produtosList.forEach(p -> {
            System.out.println(p.getNome() + ", " + p.getDescricao() + ", " + p.getPreco());
        });
    }

    public static void buscarPorCategoria(){
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDao = new ProdutoDAO(em);

        List<Produto> produtosList = produtoDao.getByCategoryName("CELULARES");
        produtosList.forEach(p -> {
            System.out.println(p.getNome() + ", " + p.getDescricao() + ", " + p.getPreco());
        });
    }

    public static void buscarPrecoPorNome(){
        EntityManager em = JPAUtil.getEntityManager();
        ProdutoDAO produtoDao = new ProdutoDAO(em);

        BigDecimal preco = produtoDao.getPrecoByName("Motorola");
        System.out.println(preco);
    }


}
