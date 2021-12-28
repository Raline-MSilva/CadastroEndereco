package br.com.zup.Cadastro.Endereco.endereco;

import br.com.zup.Cadastro.Endereco.endereco.dtos.EnderecoEntradaDTO;
import br.com.zup.Cadastro.Endereco.endereco.dtos.EnderecoSaidaDTO;
import br.com.zup.Cadastro.Endereco.usuario.Usuario;
import br.com.zup.Cadastro.Endereco.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    /*public EnderecoSaidaDTO converterDto(Endereco endereco) {
        EnderecoSaidaDTO enderecoSaidaDTODTO = new EnderecoSaidaDTO();
        enderecoSaidaDTODTO.setCep(endereco.getCep());
        enderecoSaidaDTODTO.setLogradouro(endereco.getLogradouro());
        enderecoSaidaDTODTO.setNumero(endereco.getNumero());
        enderecoSaidaDTODTO.setComplemento(endereco.getComplemento());
        enderecoSaidaDTODTO.setBairro(endereco.getBairro());
        enderecoSaidaDTODTO.setCidade(endereco.getCidade());
        enderecoSaidaDTODTO.setEstado(endereco.getEstado());
        Usuario usuario = usuarioService.buscarUsuarioPorId(endereco.getUsuario().getId());
        enderecoSaidaDTODTO.setUsuario(usuarioService.converterUsuarioDto(usuario));
        return enderecoSaidaDTODTO;
    }

    public Endereco converterEntity(EnderecoEntradaDTO enderecoEntradaDTO) {
        Endereco endereco = new Endereco();
        endereco.setCep(enderecoEntradaDTO.getCep());
        endereco.setLogradouro(enderecoEntradaDTO.getLogradouro());
        endereco.setNumero(enderecoEntradaDTO.getNumero());
        endereco.setComplemento(enderecoEntradaDTO.getComplemento());
        endereco.setBairro(enderecoEntradaDTO.getBairro());
        endereco.setCidade(enderecoEntradaDTO.getCidade());
        endereco.setEstado(enderecoEntradaDTO.getEstado());
        Usuario usuario = usuarioService.buscarUsuarioPorId(enderecoEntradaDTO.getUsuarioId());
        endereco.setUsuario(usuario);
        return endereco;
    }

     */


}
