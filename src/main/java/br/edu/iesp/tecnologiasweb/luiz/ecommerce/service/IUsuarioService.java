package br.edu.iesp.tecnologiasweb.luiz.ecommerce.service;

import br.edu.iesp.tecnologiasweb.luiz.ecommerce.model.Usuario;

public interface IUsuarioService {
    Usuario cadastrarUsuario(Usuario usuario);

    void removerUsuario(int idUsuario);

    Usuario alteraUsuario(Usuario updateUsuario, int idUsuario);

    Usuario listarUsuario(int idUsuario);
}
