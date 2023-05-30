package br.edu.iesp.tecnologiasweb.luiz.ecommerce.enumeration;

import javax.persistence.Embeddable;

@Embeddable
public enum EstadoPedido {

    CRIADO,
    ENVIADO,
    ENTREGUE,
    CANCELADO
}
