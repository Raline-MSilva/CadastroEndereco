package br.com.zup.Cadastro.Endereco.usuario;

import br.com.zup.Cadastro.Endereco.endereco.Endereco;
import br.com.zup.Cadastro.Endereco.endereco.dtos.EnderecoExibirDTO;
import br.com.zup.Cadastro.Endereco.usuario.dtos.UsuarioEntradaDTO;
import br.com.zup.Cadastro.Endereco.usuario.dtos.UsuarioSaidaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioSaidaDTO cadastrar(@RequestBody @Valid UsuarioEntradaDTO usuarioEntradaDTO) {
        Usuario usuario = modelMapper.map(usuarioEntradaDTO, Usuario.class);
        return modelMapper.map(usuarioService.salvar(usuario), UsuarioSaidaDTO.class);
    }

    @GetMapping
    public List<UsuarioSaidaDTO> exibirUsuarios() {
        List<UsuarioSaidaDTO> listarUsuarios = new ArrayList<>();
        for (Usuario usuarios : usuarioService.exibir()) {
            UsuarioSaidaDTO usuarioSaidaDTO = modelMapper.map(usuarios, UsuarioSaidaDTO.class);
            listarUsuarios.add(usuarioSaidaDTO);
        }
        return listarUsuarios;
    }
}
