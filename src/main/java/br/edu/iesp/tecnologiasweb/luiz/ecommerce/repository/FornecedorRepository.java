package br.edu.iesp.tecnologiasweb.luiz.ecommerce.repository;

import br.edu.iesp.tecnologiasweb.luiz.ecommerce.model.Fornecedor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor,Integer> {

    Optional<Fornecedor> findById(Integer idFornecedor);

}
