package br.edu.iesp.tecnologiasweb.luiz.ecommerce.model;

import br.edu.iesp.tecnologiasweb.luiz.ecommerce.enumeration.EstadoPedido;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_pedido")
public class Pedidos {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPedido;


    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @OneToOne
    private Endereco endereco;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPagamento")
    private FormaDePagamento formaDePagamento;

    @OneToOne
    private CarrinhoDeCompra carrinhoDeCompra;

    private LocalDate dataEntrada;

    private LocalDate dataEmissao;

    private double desconto;

    private double valorTotal;

    @Embedded
    private EstadoPedido estadoPedido;


}
