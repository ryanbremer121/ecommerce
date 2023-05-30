package br.edu.iesp.tecnologiasweb.luiz.ecommerce.service.implementacao;

import br.edu.iesp.tecnologiasweb.luiz.ecommerce.model.CarrinhoDeCompra;
import br.edu.iesp.tecnologiasweb.luiz.ecommerce.model.ItemProduto;
import br.edu.iesp.tecnologiasweb.luiz.ecommerce.repository.CarrinhoDeCompraRepository;
import br.edu.iesp.tecnologiasweb.luiz.ecommerce.service.ICarrinhoDeCompraService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarrinhoDeCompraService implements ICarrinhoDeCompraService {

    private final CarrinhoDeCompraRepository carrinhoDeCompraRepository;
    private final ItemProdutoService itemProdutoService;

    @Override
    public void cadastrarCarrinho(ItemProduto itemProduto) {

        var novoCarrinho = new CarrinhoDeCompra();

        novoCarrinho.setValorTotal(0.0);
        novoCarrinho.setDataEntrada(LocalDate.now());
        novoCarrinho.setDataEmissao(LocalDate.now());
        novoCarrinho.setItemProdutos(new ArrayList<ItemProduto>());

        novoCarrinho.getItemProdutos().add(itemProduto);

        carrinhoDeCompraRepository.save(novoCarrinho);

    }

    @Override
    public CarrinhoDeCompra listarCarrinho(int idCarrinho) {

        return carrinhoDeCompraRepository.findById(idCarrinho).orElseThrow();
    }

    @Override
    public void removerItemProduto(ItemProduto itemProduto, int idCarrinho) {

        try {
            var carrinhoAtual = this.listarCarrinho(idCarrinho);

            carrinhoAtual.getItemProdutos().remove(itemProduto);

            carrinhoDeCompraRepository.save(carrinhoAtual);

        } catch (Exception e) {
            log.error("Erro ao manipular criacao do carrinho", e);
        }
    }

    @Override
    public void adicionaItemProduto(ItemProduto itemProduto, int idCarrinho) {

        try {
            var carrinhoAtual = this.listarCarrinho(idCarrinho);

            carrinhoAtual.getItemProdutos().add(itemProduto);

            carrinhoDeCompraRepository.save(carrinhoAtual);

        } catch (Exception e) {
            log.error("Erro ao manipular criacao do carrinho", e);
        }
    }

    @Override
    public double valorTotal(int idCarrinho) {

        double valorTotal = 0;

        try {

            var carrinhoAtual = this.listarCarrinho(idCarrinho);

            for (ItemProduto itemProduto :carrinhoAtual.getItemProdutos()) {

                valorTotal += itemProdutoService.valorTotal(itemProduto.getIdItensProduto());
            }

        } catch (Exception e) {
            log.error("Erro ao manipular criacao do carrinho", e);
        }

        return valorTotal;
    }
}
