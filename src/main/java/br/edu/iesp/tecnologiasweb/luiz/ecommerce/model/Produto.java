package br.edu.iesp.tecnologiasweb.luiz.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tb_produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idProduto;

    private String nomeProduto;

    private float precoProduto;

    private int qtdEstoque;


    @OneToOne
    private ItemProduto itemProduto;

    @OneToMany(mappedBy = "produto", cascade = CascadeType.ALL)
    private List<Fornecedor> fornecedores;



}
