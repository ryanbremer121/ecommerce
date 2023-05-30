package br.edu.iesp.tecnologiasweb.luiz.ecommerce.service.implementacao;

import br.edu.iesp.tecnologiasweb.luiz.ecommerce.model.Endereco;
import br.edu.iesp.tecnologiasweb.luiz.ecommerce.repository.EnderecoRepository;
import br.edu.iesp.tecnologiasweb.luiz.ecommerce.service.IEnderecoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EnderecoService implements IEnderecoService {

    private final EnderecoRepository enderecoRepository;

    public void cadastrarEndereco(Endereco endereco) {

        try {
            if (endereco != null){
                enderecoRepository.save(endereco);
            }
        } catch (Exception e){
            log.error("Erro ao salvar dados no banco de dados");
        }

    }

    public void editarEndereco(int idEndereco, Endereco novoEndereco) {

        var enderecoBanco = enderecoRepository.findById(idEndereco).orElseThrow();

        enderecoBanco.setCEP(novoEndereco.getCEP());
        enderecoBanco.setLogradouro(novoEndereco.getLogradouro());
        enderecoBanco.setBairro(novoEndereco.getBairro());
        enderecoBanco.setCidade(novoEndereco.getCidade());
        enderecoBanco.setEstado(novoEndereco.getEstado());
        enderecoBanco.setPedido(novoEndereco.getPedido());
        enderecoBanco.setUsuario(novoEndereco.getUsuario());

        enderecoRepository.save(enderecoBanco);


    }

    public Endereco listarEndereco(int idEndereco) {

        var enderecoBanco = enderecoRepository.findById(idEndereco).orElseThrow();

        return enderecoBanco;
    }

    public void removerEndereco(int idEndereco) {

        var enderecoBanco = enderecoRepository.findById(idEndereco).orElseThrow();

        enderecoRepository.delete(enderecoBanco);

    }
}
