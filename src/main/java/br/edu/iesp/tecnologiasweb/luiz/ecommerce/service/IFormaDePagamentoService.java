package br.edu.iesp.tecnologiasweb.luiz.ecommerce.service;

import br.edu.iesp.tecnologiasweb.luiz.ecommerce.enumeration.TipoPagamento;
import br.edu.iesp.tecnologiasweb.luiz.ecommerce.model.FormaDePagamento;

public interface IFormaDePagamentoService {

    void cadastrarFormaDePagamento(TipoPagamento tipoPagamento);

    FormaDePagamento listarFormaDePagamento(int idFormaDePagamento);

}
