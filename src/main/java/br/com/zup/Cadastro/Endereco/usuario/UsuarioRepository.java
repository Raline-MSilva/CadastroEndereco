package br.com.zup.Cadastro.Endereco.usuario;

import org.springframework.data.repository.CrudRepository;


public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    boolean existsByEmail(String email);
    boolean existsByCpf(String cpf);
}
