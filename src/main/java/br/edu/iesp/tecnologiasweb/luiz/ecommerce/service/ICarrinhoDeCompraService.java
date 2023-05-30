package br.edu.iesp.tecnologiasweb.luiz.ecommerce.service;

import br.edu.iesp.tecnologiasweb.luiz.ecommerce.model.CarrinhoDeCompra;
import br.edu.iesp.tecnologiasweb.luiz.ecommerce.model.ItemProduto;

public interface ICarrinhoDeCompraService {

    void cadastrarCarrinho(ItemProduto itemProduto);

    CarrinhoDeCompra listarCarrinho(int idCarrinho);

    void removerItemProduto(ItemProduto itemProduto, int idCarrinho);

    void adicionaItemProduto(ItemProduto itemProduto, int idCarrinho);

    double valorTotal(int idCarrinho);

}
