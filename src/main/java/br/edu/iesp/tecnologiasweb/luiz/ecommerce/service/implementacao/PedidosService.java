package br.edu.iesp.tecnologiasweb.luiz.ecommerce.service.implementacao;

import br.edu.iesp.tecnologiasweb.luiz.ecommerce.enumeration.EstadoPedido;
import br.edu.iesp.tecnologiasweb.luiz.ecommerce.enumeration.FormaEnvio;
import br.edu.iesp.tecnologiasweb.luiz.ecommerce.repository.PedidosRepository;
import br.edu.iesp.tecnologiasweb.luiz.ecommerce.service.IPedidosService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PedidosService implements IPedidosService {

    private final PedidosRepository pedidosRepository;
    private final UsuarioService usuarioService;
    private final CarrinhoDeCompraService carrinhoDeCompraService;
    private final EnderecoService enderecoService;
    private final FormaDePagamentoService formaDePagamentoService;

    public void concluirPedido(int idPedido, int idUsuario, int idCarrinhoDeCompras, int idEndereco, int idPagamento) {

        var pedidoBanco =  pedidosRepository.findById(idPedido).orElseThrow();
        var usuarioBanco = usuarioService.listarUsuario(pedidoBanco.getUsuario().getIdUsuario());
        var carrinhoDeCompraBanco = carrinhoDeCompraService.listarCarrinho(pedidoBanco.getCarrinhoDeCompra().getIdCarrinhoDeCompra());
        var enderecoBanco = enderecoService.listarEndereco(pedidoBanco.getEndereco().getIdEndereco());
        var formaPagamentoBanco = formaDePagamentoService.listarFormaDePagamento(pedidoBanco.getFormaDePagamento().getIdPagamento());


        if (pedidoBanco.getEstadoPedido().equals(EstadoPedido.ENVIADO) ) {
            pedidoBanco.setEstadoPedido(EstadoPedido.ENTREGUE);
        }

    }

    public void cancelarPedido(int idPedido) {

        var pedidoBanco =  pedidosRepository.findById(idPedido).orElseThrow();

        pedidoBanco.setEstadoPedido(EstadoPedido.CANCELADO);

        pedidosRepository.save(pedidoBanco);

    }

    public void rastreioPedido(int idPedido) {

        var pedidoBanco =  pedidosRepository.findById(idPedido).orElseThrow();

        if (pedidoBanco.getEstadoPedido().equals(EstadoPedido.ENVIADO) ){
            log.info("Pedido está em transito: ",pedidoBanco.getEstadoPedido());
        } else {
            log.warn("Pedido não está em transito: ",pedidoBanco.getEstadoPedido());
        }


    }

    public void aplicarDesconto(int idPedido,int desconto) {

        var pedidoBanco =  pedidosRepository.findById(idPedido).orElseThrow();

        pedidoBanco.setDesconto(pedidoBanco.getValorTotal() - desconto);

        pedidosRepository.save(pedidoBanco);

    }

    public double calcularFrete(int idPedido) {

        var pedidoBanco =  pedidosRepository.findById(idPedido).orElseThrow();
        var usuarioBanco = usuarioService.listarUsuario(pedidoBanco.getUsuario().getIdUsuario());

        var enderecoUsuario = usuarioBanco.getEnderecos().stream().findFirst();

        int cepEnderecoPedido = Integer.getInteger(pedidoBanco.getEndereco().getCEP());
        int cepEnderecoUsuario = Integer.getInteger(enderecoUsuario.get().getCEP());

        return (double) Math.abs(cepEnderecoPedido - cepEnderecoUsuario) /100;

    }

    public void formaEnvio() {

        log.info("As formas de envio são: ", FormaEnvio.values());

    }

    /**
     *
     * Este método atualiza o status do pedido recebendo o id do Pedido
     * @param idPedido
     */

    public EstadoPedido statusPedido(int idPedido) {
        var pedidoBanco = pedidosRepository.findById(idPedido).orElseThrow();
        return pedidoBanco.getEstadoPedido();
    }


    public void atualizarStatusPedido(int idPedido) {

        var pedidoBanco = pedidosRepository.findById(idPedido).orElseThrow();

        switch (pedidoBanco.getEstadoPedido()){

            case CRIADO:
                pedidoBanco.setEstadoPedido(EstadoPedido.ENVIADO);
                break;
            case ENVIADO:
                pedidoBanco.setEstadoPedido(EstadoPedido.ENTREGUE);
                break;
            default:
                pedidoBanco.setEstadoPedido(EstadoPedido.CRIADO);
                break;
        }

        pedidosRepository.save(pedidoBanco);

    }

}
