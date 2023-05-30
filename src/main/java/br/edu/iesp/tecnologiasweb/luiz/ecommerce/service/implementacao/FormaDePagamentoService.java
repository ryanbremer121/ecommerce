package br.edu.iesp.tecnologiasweb.luiz.ecommerce.service.implementacao;

import br.edu.iesp.tecnologiasweb.luiz.ecommerce.enumeration.TipoPagamento;
import br.edu.iesp.tecnologiasweb.luiz.ecommerce.model.FormaDePagamento;
import br.edu.iesp.tecnologiasweb.luiz.ecommerce.repository.FormaDePagamentoRepository;
import br.edu.iesp.tecnologiasweb.luiz.ecommerce.service.IFormaDePagamentoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FormaDePagamentoService implements IFormaDePagamentoService {

    private final FormaDePagamentoRepository formaDePagamentoRepository;

    public void cadastrarFormaDePagamento(TipoPagamento tipoPagamento){

        formaDePagamentoRepository.save(new FormaDePagamento(tipoPagamento));

    }

    public FormaDePagamento listarFormaDePagamento(int idFormaDePagamento){
        return formaDePagamentoRepository.findById(idFormaDePagamento).orElseThrow();
    }

}
