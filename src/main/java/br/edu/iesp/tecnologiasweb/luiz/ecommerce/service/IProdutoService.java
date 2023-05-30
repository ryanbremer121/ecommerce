package br.edu.iesp.tecnologiasweb.luiz.ecommerce.service;

import br.edu.iesp.tecnologiasweb.luiz.ecommerce.model.Produto;

public interface IProdutoService {

    void cadastrarProduto(Produto produto);

    void removerProduto(int idProduto);

    void alterarProduto(int idProduto, Produto produto);

    Produto listaProduto(int idProduto);

}
