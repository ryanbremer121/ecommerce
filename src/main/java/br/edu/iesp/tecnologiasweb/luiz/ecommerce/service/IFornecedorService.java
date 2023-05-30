package br.edu.iesp.tecnologiasweb.luiz.ecommerce.service;

import br.edu.iesp.tecnologiasweb.luiz.ecommerce.model.Fornecedor;

public interface IFornecedorService {

    Fornecedor listarFornecedor(int idFornecedor);

    void cadastrarFornecedor(String nomeFornecedor, String CNPJFornecedor);
}
