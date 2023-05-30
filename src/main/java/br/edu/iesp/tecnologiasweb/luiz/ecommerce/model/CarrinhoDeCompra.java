package br.edu.iesp.tecnologiasweb.luiz.ecommerce.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_carrinho_de_compra")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarrinhoDeCompra {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idCarrinhoDeCompra;

    private double valorTotal;
    private LocalDate dataEmissao;
    private LocalDate dataEntrada;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "carrinhoDeCompra")
    private List<ItemProduto> itemProdutos;

    @OneToOne
    private Pedidos pedido;



}
