package br.com.zup.Cadastro.Endereco.Excecoes;

public class UsuarioJaCadastradoException extends RuntimeException{
    public UsuarioJaCadastradoException(String message) {
        super(message);
    }
}
