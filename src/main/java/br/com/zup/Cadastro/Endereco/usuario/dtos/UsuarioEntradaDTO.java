package br.com.zup.Cadastro.Endereco.usuario.dtos;

import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Data
public class UsuarioEntradaDTO {
    @NotBlank
    private String nome;
    @CPF
    private String cpf;
    @Email
    @NotBlank
    private String email;

}
