package br.edu.iesp.tecnologiasweb.luiz.ecommerce.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idUsuario;

    private String nomeUsuario;
    private String emailUsuario;

    private int senhaUsuario;

    private String cpfUsuario;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Endereco> enderecos;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Pedidos> pedidos;


}

