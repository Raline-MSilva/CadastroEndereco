package br.com.zup.Cadastro.Endereco.endereco;

import br.com.zup.Cadastro.Endereco.endereco.dtos.EnderecoEntradaDTO;
import br.com.zup.Cadastro.Endereco.endereco.dtos.EnderecoSaidaDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

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
        Endereco endereco = enderecoService.converterEntity(enderecoEntradaDTO);
        return enderecoService.converterDto(enderecoService.salvar(endereco));
    }
}
