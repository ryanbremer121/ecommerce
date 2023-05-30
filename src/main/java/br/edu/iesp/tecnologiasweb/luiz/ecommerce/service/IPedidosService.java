package br.edu.iesp.tecnologiasweb.luiz.ecommerce.service;

import br.edu.iesp.tecnologiasweb.luiz.ecommerce.enumeration.EstadoPedido;

public interface IPedidosService {

    void concluirPedido(int idPedido, int idUsuario, int idCarrinhoDeCompras, int idEndereco, int idPagamento);

    void cancelarPedido(int idPedido);

    void rastreioPedido(int idPedido);

    void aplicarDesconto(int idPedido, int desconto);

    double calcularFrete(int idPedido);

    void formaEnvio();

    EstadoPedido statusPedido(int idPedido);

    void atualizarStatusPedido(int idPedido);

}
