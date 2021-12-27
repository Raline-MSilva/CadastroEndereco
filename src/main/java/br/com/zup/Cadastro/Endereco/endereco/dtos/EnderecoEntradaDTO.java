package br.com.zup.Cadastro.Endereco.endereco.dtos;

import br.com.zup.Cadastro.Endereco.usuario.Usuario;
import lombok.Data;

@Data
public class EnderecoEntradaDTO {
    private String cep;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private Usuario usuario;
}
