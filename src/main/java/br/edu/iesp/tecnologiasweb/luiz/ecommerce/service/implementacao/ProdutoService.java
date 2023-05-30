package br.edu.iesp.tecnologiasweb.luiz.ecommerce.service.implementacao;

import br.edu.iesp.tecnologiasweb.luiz.ecommerce.model.Produto;
import br.edu.iesp.tecnologiasweb.luiz.ecommerce.repository.ProdutoRepository;
import br.edu.iesp.tecnologiasweb.luiz.ecommerce.service.IProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProdutoService implements IProdutoService {

    private final ProdutoRepository produtoRepository;

    public void cadastrarProduto(Produto produto) {

        try {
            log.info("Tentando salvar produto no banco de dados");
            if (produto != null ){
                log.info("Salvando produto no banco de dados");
                produtoRepository.save(produto);
            }
        } catch (Exception e){
            log.error("Erro ao salvar item no banco de dados",e);
        }

    }

    public void removerProduto(int idProduto) {

        var produtoOptional = Optional.of(produtoRepository.findById(idProduto).orElseThrow());

        produtoRepository.delete(produtoOptional.get());

    }

    public void alterarProduto(int idProduto, Produto produto) {
        var produtoBanco = produtoRepository.findById(idProduto).orElseThrow();

        produtoBanco.setItemProduto(produto.getItemProduto());
        produtoBanco.setNomeProduto(produto.getNomeProduto());
        produtoBanco.setPrecoProduto(produto.getPrecoProduto());
        produtoBanco.setQtdEstoque(produto.getQtdEstoque());
        produtoBanco.setFornecedores(produto.getFornecedores());

        produtoRepository.save(produtoBanco);

    }

    public Produto listaProduto(int idProduto) {

        var produtoOptional = Optional.of(produtoRepository.findById(idProduto).orElseThrow());

        return produtoOptional.get();

    }

}
