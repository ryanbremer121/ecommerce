package br.edu.iesp.tecnologiasweb.luiz.ecommerce.service.implementacao;

import br.edu.iesp.tecnologiasweb.luiz.ecommerce.model.Usuario;
import br.edu.iesp.tecnologiasweb.luiz.ecommerce.repository.UsuarioRepository;
import br.edu.iesp.tecnologiasweb.luiz.ecommerce.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService implements IUsuarioService {


    private final UsuarioRepository usuarioRepository;

    public Usuario cadastrarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }


    public void removerUsuario(int idUsuario){
        var usuario = usuarioRepository.findById(idUsuario).orElseThrow();
        usuarioRepository.delete(usuario);
    }

    public Usuario alteraUsuario(Usuario updateUsuario, int idUsuario){
        var usuario = usuarioRepository.findById(idUsuario).orElseThrow();
        usuario.setCpfUsuario(updateUsuario.getCpfUsuario());
        usuario.setEmailUsuario(updateUsuario.getEmailUsuario());
        usuario.setSenhaUsuario(updateUsuario.getSenhaUsuario());
        usuario.setEnderecos(updateUsuario.getEnderecos());
        return usuarioRepository.save(usuario);
    }

    public Usuario listarUsuario(int idUsuario){
        return usuarioRepository.findById(idUsuario).orElseThrow();
    }

}
