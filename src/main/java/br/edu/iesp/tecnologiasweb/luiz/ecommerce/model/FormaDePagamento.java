package br.edu.iesp.tecnologiasweb.luiz.ecommerce.model;

import br.edu.iesp.tecnologiasweb.luiz.ecommerce.enumeration.TipoPagamento;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name = "tb_forma_de_pagamento")
public class FormaDePagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idPagamento;

    @Embedded
    @NonNull
    private TipoPagamento tipoPagamento;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formaDePagamento")
    private List<Pedidos> pedidos;

}
