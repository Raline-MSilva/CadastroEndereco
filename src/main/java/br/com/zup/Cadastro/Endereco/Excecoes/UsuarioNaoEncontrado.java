package br.com.zup.Cadastro.Endereco.Excecoes;

public class UsuarioNaoEncontrado extends RuntimeException{
    public UsuarioNaoEncontrado(String message) {
        super(message);
    }
}
