package br.edu.iesp.tecnologiasweb.luiz.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "itemProduto")
public class ItemProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idItensProduto;

    @OneToOne
    private Produto produto;

    private int quantidade;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCarrinhoDeCompra")
    private CarrinhoDeCompra carrinhoDeCompra;





}
