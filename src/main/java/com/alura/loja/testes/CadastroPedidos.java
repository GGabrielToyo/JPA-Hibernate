package com.alura.loja.testes;

import com.alura.loja.dao.ClienteDAO;
import com.alura.loja.dao.PedidoDAO;
import com.alura.loja.dao.ProdutoDAO;
import com.alura.loja.modelo.Cliente;
import com.alura.loja.modelo.ItemPedido;
import com.alura.loja.modelo.Pedido;
import com.alura.loja.modelo.Produto;
import com.alura.loja.modelo.dto.RelatorioVendasDTO;
import com.alura.loja.util.JPAUtil;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;

public class CadastroPedidos {
    public static void main(String[] args) {
        //cadastrarPedido();
        //buscarValorTotalPedido();
        relatorioVendas();

    }

    public static void cadastrarPedido(){
        EntityManager em = JPAUtil.getEntityManager();
        PedidoDAO pedidoDAO = new PedidoDAO(em);

        ProdutoDAO produtoDAO = new ProdutoDAO(em);
        Produto produto = produtoDAO.getPorId(1l);

        ClienteDAO clienteDAO = new ClienteDAO(em);
        Cliente cliente = clienteDAO.getById(1l);

        em.getTransaction().begin();

        Pedido pedido = new Pedido(cliente);
        pedido.adicionarItem(new ItemPedido(10, pedido, produto));
        pedidoDAO.cadastrar(pedido);

        em.getTransaction().commit();
    }

    public static void buscarValorTotalPedido(){
        EntityManager em = JPAUtil.getEntityManager();
        PedidoDAO pedidoDAO = new PedidoDAO(em);

        BigDecimal valorTotal = pedidoDAO.getValorTotalPedido(2l);
        System.out.println(valorTotal);
    }

    public static void relatorioVendas(){
        EntityManager em = JPAUtil.getEntityManager();
        PedidoDAO pedidoDAO = new PedidoDAO(em);

        List<RelatorioVendasDTO> relatorio = pedidoDAO.relatorioDeVendas();
        relatorio.forEach(System.out::println);
    }

}
