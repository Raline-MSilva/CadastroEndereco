package br.com.zup.Cadastro.Endereco.endereco.dtos;

import lombok.Data;

@Data
public class EnderecoExibirDTO {
    private int id;
    private String cep;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
}
