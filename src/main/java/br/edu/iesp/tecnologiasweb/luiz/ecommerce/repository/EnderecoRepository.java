package br.edu.iesp.tecnologiasweb.luiz.ecommerce.repository;

import br.edu.iesp.tecnologiasweb.luiz.ecommerce.model.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Integer> {
}
