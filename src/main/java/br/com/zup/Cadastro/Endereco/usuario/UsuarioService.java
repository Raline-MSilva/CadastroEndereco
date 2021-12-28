package br.com.zup.Cadastro.Endereco.usuario;

import br.com.zup.Cadastro.Endereco.Excecoes.UsuarioNaoEncontradoException;
import br.com.zup.Cadastro.Endereco.Excecoes.UsuarioJaCadastradoException;
import br.com.zup.Cadastro.Endereco.usuario.dtos.UsuarioSaidaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario salvar(Usuario usuario){
        if (usuarioRepository.existsByEmail(usuario.getEmail()) || usuarioRepository.existsByCpf(usuario.getCpf())) {
            throw new UsuarioJaCadastradoException("usuario ja cadastrado");
        }

        return usuarioRepository.save(usuario);
    }

    public Usuario buscarUsuarioPorId (int id){
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()){
            throw new UsuarioNaoEncontradoException("Usuario não encontrado");
        }

        return usuario.get();
    }

    public UsuarioSaidaDTO converterUsuarioDto (Usuario usuario){
        UsuarioSaidaDTO usuarioDto = new UsuarioSaidaDTO();
        usuarioDto.setCpf(usuario.getCpf());
        usuarioDto.setEmail(usuario.getEmail());
        usuarioDto.setNome(usuario.getNome());
        return usuarioDto;
    }
}
