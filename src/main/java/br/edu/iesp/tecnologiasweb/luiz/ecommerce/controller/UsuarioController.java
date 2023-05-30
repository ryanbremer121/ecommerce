package br.edu.iesp.tecnologiasweb.luiz.ecommerce.controller;


import br.edu.iesp.tecnologiasweb.luiz.ecommerce.model.Usuario;
import br.edu.iesp.tecnologiasweb.luiz.ecommerce.service.IUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/usuario")
@RequiredArgsConstructor
public class UsuarioController {


    private final IUsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public Usuario cadastrar(@RequestBody Usuario usuario){
       return usuarioService.cadastrarUsuario(usuario);

    }

    @PutMapping("/alterar/{idUsuario}")
    public void alterarUsuario(@RequestBody Usuario updateUsuario,
                               @PathVariable int idUsuario){
        usuarioService.alteraUsuario(updateUsuario, idUsuario);
    }

    @GetMapping("/listar/{idUsuario}")
    public Usuario listarUsuario(@PathVariable int idUsuario){
        return usuarioService.listarUsuario(idUsuario);
    }

    @DeleteMapping("/deletar/{idUsuario}")
    public void deletarUsuario(@PathVariable int idUsuario){
        usuarioService.removerUsuario(idUsuario);

    }




}
