package br.edu.iesp.tecnologiasweb.luiz.ecommerce.service.implementacao;

import br.edu.iesp.tecnologiasweb.luiz.ecommerce.repository.FornecedorRepository;
import br.edu.iesp.tecnologiasweb.luiz.ecommerce.model.Fornecedor;
import br.edu.iesp.tecnologiasweb.luiz.ecommerce.service.IFornecedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FornecedorService implements IFornecedorService {

   private final FornecedorRepository fornecedorRepository;

   public Fornecedor listarFornecedor(int idFornecedor){

      return fornecedorRepository.findById(idFornecedor).orElseThrow();

   }

   public void cadastrarFornecedor(String nomeFornecedor, String CNPJFornecedor){

      fornecedorRepository.save(new Fornecedor(nomeFornecedor,CNPJFornecedor));

   }
}
