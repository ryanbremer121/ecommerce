package br.edu.iesp.tecnologiasweb.luiz.ecommerce.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_endereco")
public class Endereco {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idEndereco;
    private String logradouro;
    private String cidade;
    private String  estado;
    private String  bairro;
    private String  CEP;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    @OneToOne
    private Pedidos pedido;

}
