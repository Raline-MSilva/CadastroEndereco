package br.com.zup.Cadastro.Endereco.usuario;

import br.com.zup.Cadastro.Endereco.dtos.UsuarioEntradaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioEntradaDTO cadastrar (@RequestBody UsuarioEntradaDTO usuarioEntradaDTO){
        Usuario usuario = modelMapper.map(usuarioEntradaDTO, Usuario.class);
        return modelMapper.map(usuarioService.salvar(usuario), UsuarioEntradaDTO.class);
    }
}
