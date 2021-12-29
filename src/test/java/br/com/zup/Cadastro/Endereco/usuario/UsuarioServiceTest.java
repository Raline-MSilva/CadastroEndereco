package br.com.zup.Cadastro.Endereco.usuario;

import br.com.zup.Cadastro.Endereco.Excecoes.UsuarioJaCadastradoException;
import br.com.zup.Cadastro.Endereco.Excecoes.UsuarioNaoEncontradoException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class UsuarioServiceTest {
    @MockBean
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioService usuarioService;

    private Usuario usuario;
    List<Usuario> usuarios;

    @BeforeEach
    public void setup() {
        usuario = new Usuario();
        usuario.setNome("Maria");
        usuario.setCpf("094.408.150-94");
        usuario.setEmail("maria@maria");

        usuarios = new ArrayList<>();
    }

    @Test
    public void testarCadastrarUsuario() {
        Mockito.when(usuarioRepository.save(Mockito.any(Usuario.class))).thenReturn(usuario);
        Mockito.when(usuarioRepository.existsByEmail(usuario.getEmail())).thenReturn(false);
        Mockito.when(usuarioRepository.existsByCpf(usuario.getCpf())).thenReturn(false);
        usuarioService.salvar(usuario);
        Mockito.verify(usuarioRepository, Mockito.times(1)).save(Mockito.any(Usuario.class));
        Mockito.verify(usuarioRepository, Mockito.times(1)).existsByEmail(usuario.getEmail());
        Mockito.verify(usuarioRepository, Mockito.times(1)).existsByCpf(usuario.getCpf());
    }

    @Test
    public void testarCadastrarUsuarioCaminhoNegativoPorEmailRepetido() {
        Mockito.when(usuarioRepository.save(Mockito.any(Usuario.class))).thenReturn(usuario);
        Mockito.when(usuarioRepository.existsByEmail(usuario.getEmail())).thenReturn(true);
        UsuarioJaCadastradoException exception = Assertions.assertThrows(UsuarioJaCadastradoException.class,
                () -> {
                    usuarioService.salvar(usuario);
                });
        Assertions.assertEquals("usuario ja cadastrado", exception.getMessage());
    }

    @Test
    public void testarCadastrarUsuarioCaminhoNegativoPorCpfRepetido(){
        Mockito.when(usuarioRepository.save(Mockito.any(Usuario.class))).thenReturn(usuario);
        Mockito.when(usuarioRepository.existsByCpf(usuario.getCpf())).thenReturn(true);
        UsuarioJaCadastradoException exception = Assertions.assertThrows(UsuarioJaCadastradoException.class,
                () -> {
                    usuarioService.salvar(usuario);
                });
        Assertions.assertEquals("usuario ja cadastrado", exception.getMessage());
    }

    @Test
    public void testarDeletarusuarioCaminhoPositivo(){
        Mockito.when(usuarioRepository.existsById(usuario.getId())).thenReturn(true);
        usuarioService.deletar(usuario.getId());
        Mockito.verify(usuarioRepository, Mockito.times(1)).deleteById(usuario.getId());
    }

}
