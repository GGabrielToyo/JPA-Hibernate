package com.alura.loja.dao;

import com.alura.loja.modelo.Pedido;
import com.alura.loja.modelo.dto.RelatorioVendasDTO;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class PedidoDAO {

    private EntityManager em;

    public PedidoDAO(EntityManager em){
        this.em = em;
    }

    public void cadastrar(Pedido pedido){
        this.em.persist(pedido);
    }

    public BigDecimal getValorTotalPedido(Long id){
        String jpql = "SELECT SUM(p.valorTotal) FROM Pedido p WHERE p.id = :idPedido";

        return this.em.createQuery(jpql, BigDecimal.class)
                .setParameter("idPedido", id)
                .getSingleResult();
    }

    public List<RelatorioVendasDTO> relatorioDeVendas(){
        String jpql = "SELECT new com.alura.loja.modelo.dto.RelatorioVendasDTO(" +
                "produto.nome, " +
                "SUM(item.quantidade) as quantidadeTotal, " +
                "MAX(pedido.data))" +
                "FROM Pedido pedido " +
                "JOIN pedido.itens item " +
                "JOIN item.produto produto " +
                "GROUP BY produto.nome " +
                "ORDER BY quantidadeTotal DESC";

        return em.createQuery(jpql, RelatorioVendasDTO.class).getResultList();
    }
}
