package br.com.zup.Cadastro.Endereco.usuario;

import br.com.zup.Cadastro.Endereco.Excecoes.UuarioJaCadastradoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario){
        if (usuarioRepository.existsByEmail(usuario.getEmail()) || usuarioRepository.existsByCpf(usuario.getCpf())) {
            throw new UuarioJaCadastradoException("usuario ja cadastrado");
        }

        return usuarioRepository.save(usuario);
    }

}
