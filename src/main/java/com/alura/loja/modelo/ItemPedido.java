package com.alura.loja.modelo;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;

@Entity
@Table(name = "itens_pedido")
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "preco_unitario")
    private BigDecimal precoUnitario;
    private Integer quantidade;
    @ManyToOne
    private Pedido pedido;
    @ManyToOne
    private Produto produto;

    public ItemPedido(){};

    public ItemPedido(Integer quantidade, Pedido pedido, Produto produto){
        this.precoUnitario = produto.getPreco();
        this.quantidade = quantidade;
        this.pedido = pedido;
        this.produto = produto;
    };

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getPrecoUnitario() {
        return precoUnitario;
    }
    public void setPrecoUnitario(BigDecimal precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public Integer getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Pedido getPedido() {
        return pedido;
    }
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public BigDecimal getValor(){
        return precoUnitario.multiply(new BigDecimal(getQuantidade()));
    }
}
