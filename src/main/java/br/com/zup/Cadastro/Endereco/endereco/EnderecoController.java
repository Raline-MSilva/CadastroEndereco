package br.com.zup.Cadastro.Endereco.endereco;

import br.com.zup.Cadastro.Endereco.endereco.dtos.EnderecoEntradaDTO;
import br.com.zup.Cadastro.Endereco.endereco.dtos.EnderecoExibirDTO;
import br.com.zup.Cadastro.Endereco.endereco.dtos.EnderecoSaidaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus (HttpStatus.CREATED)
    public EnderecoSaidaDTO cadastrar (@RequestBody EnderecoEntradaDTO enderecoEntradaDTO){
        Integer usuarioId = enderecoEntradaDTO.getUsuarioDTO().getId();
        Endereco endereco = modelMapper.map(enderecoEntradaDTO, Endereco.class);
        return modelMapper.map(enderecoService.salvar(endereco, usuarioId),
                EnderecoSaidaDTO.class);
    }
    @GetMapping
    public List<EnderecoExibirDTO> exibirEndereco (){
        List<EnderecoExibirDTO> enderecos = new ArrayList<>();
        for (Endereco endereco: enderecoService.exibir()){
            EnderecoExibirDTO enderecoExibirDTO = modelMapper.map(endereco, EnderecoExibirDTO.class);
            enderecos.add(enderecoExibirDTO);
        }
        return enderecos;
    }
}
