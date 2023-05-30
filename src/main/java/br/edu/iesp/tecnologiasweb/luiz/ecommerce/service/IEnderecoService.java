package br.edu.iesp.tecnologiasweb.luiz.ecommerce.service;

import br.edu.iesp.tecnologiasweb.luiz.ecommerce.model.Endereco;

public interface IEnderecoService {
    void cadastrarEndereco(Endereco endereco);

    void editarEndereco(int idEndereco, Endereco novoEndereco);

    Endereco listarEndereco(int idEndereco);

    void removerEndereco(int idEndereco);
}
