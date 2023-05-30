package br.edu.iesp.tecnologiasweb.luiz.ecommerce.service.implementacao;

import br.edu.iesp.tecnologiasweb.luiz.ecommerce.model.ItemProduto;
import br.edu.iesp.tecnologiasweb.luiz.ecommerce.model.Produto;
import br.edu.iesp.tecnologiasweb.luiz.ecommerce.repository.ItemProdutoRepository;
import br.edu.iesp.tecnologiasweb.luiz.ecommerce.service.IItemProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ItemProdutoService implements IItemProdutoService {

    private final ItemProdutoRepository itemProdutoRepository;

    public void cadastrarItemProduto(Produto produto, int quantidade){

        ItemProduto novoItemProduto = new ItemProduto();

        novoItemProduto.setProduto(produto);
        novoItemProduto.setQuantidade(quantidade);

        itemProdutoRepository.save(novoItemProduto);
    }

    public ItemProduto listarItemProduto(int idItemProduto){

        return itemProdutoRepository.findById(idItemProduto).orElseThrow();

    }

    public double valorTotal(int idItemProduto){

        double valorTotal = 0;

        try {

            var itemProduto = this.listarItemProduto(idItemProduto);

            valorTotal += itemProduto.getProduto().getPrecoProduto() * itemProduto.getQuantidade();

        } catch (Exception e) {
            log.error("Erro ao manipular criacao do carrinho", e);
        }

        return valorTotal;

    }

}
