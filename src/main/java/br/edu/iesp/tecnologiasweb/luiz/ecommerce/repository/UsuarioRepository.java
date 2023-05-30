package br.edu.iesp.tecnologiasweb.luiz.ecommerce.repository;

import br.edu.iesp.tecnologiasweb.luiz.ecommerce.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findById(Integer integer);
}
