package br.com.zup.Cadastro.Endereco.endereco.dtos;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class EnderecoEntradaDTO {
    @NotBlank
    private String cep;
    @NotBlank
    private String logradouro;
    @NotBlank
    private int numero;
    private String complemento;
    @NotBlank
    private String bairro;
    @NotBlank
    private String cidade;
    @NotBlank
    private String estado;
    @NotBlank
    private int usuarioId;
}
