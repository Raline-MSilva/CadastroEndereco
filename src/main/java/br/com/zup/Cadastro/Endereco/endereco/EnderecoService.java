package br.com.zup.Cadastro.Endereco.endereco;

import br.com.zup.Cadastro.Endereco.endereco.dtos.EnderecoEntradaDTO;
import br.com.zup.Cadastro.Endereco.endereco.dtos.EnderecoSaidaDTO;
import br.com.zup.Cadastro.Endereco.usuario.Usuario;
import br.com.zup.Cadastro.Endereco.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private UsuarioService usuarioService;

    public Endereco salvar(Endereco endereco, Integer usuarioId) {
        Usuario usuario = usuarioService.buscarUsuarioPorId(usuarioId);
        endereco.setUsuario(usuario);
        usuario.getEndereco().add(endereco);
        return enderecoRepository.save(endereco);
    }
    public List<Endereco> exibir (){
        List<Endereco> enderecos = (List<Endereco>) enderecoRepository.findAll();
        return enderecos;
    }
}
