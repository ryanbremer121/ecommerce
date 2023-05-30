package br.edu.iesp.tecnologiasweb.luiz.ecommerce.service;

import br.edu.iesp.tecnologiasweb.luiz.ecommerce.model.ItemProduto;
import br.edu.iesp.tecnologiasweb.luiz.ecommerce.model.Produto;

public interface IItemProdutoService {

    void cadastrarItemProduto(Produto produto, int quantidade);

    double valorTotal(int idItemProduto);

    ItemProduto listarItemProduto(int idItemProduto);

}
