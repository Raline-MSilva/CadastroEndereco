package br.com.zup.Cadastro.Endereco.endereco.dtos;

import br.com.zup.Cadastro.Endereco.usuario.dtos.UsuarioSaidaDTO;
import lombok.Data;

@Data
public class EnderecoSaidaDTO {
    private String cep;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private UsuarioSaidaDTO usuario;
}
