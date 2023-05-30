package br.edu.iesp.tecnologiasweb.luiz.ecommerce.repository;

import br.edu.iesp.tecnologiasweb.luiz.ecommerce.model.CarrinhoDeCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarrinhoDeCompraRepository extends JpaRepository<CarrinhoDeCompra,Integer> {
}
