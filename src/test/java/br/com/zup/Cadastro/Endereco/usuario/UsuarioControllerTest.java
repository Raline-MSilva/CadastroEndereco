package br.com.zup.Cadastro.Endereco.usuario;

import br.com.zup.Cadastro.Endereco.componentes.Conversor;
import br.com.zup.Cadastro.Endereco.usuario.dtos.UsuarioEntradaDTO;
import br.com.zup.Cadastro.Endereco.usuario.dtos.UsuarioSaidaDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@WebMvcTest({UsuarioController.class, Conversor.class})
public class UsuarioControllerTest {
    @MockBean
    private UsuarioService usuarioService;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;
    private Usuario usuario;
    private UsuarioEntradaDTO usuarioEntradaDTO;
    private UsuarioSaidaDTO usuarioSaidaDTO;

    @BeforeEach
    public void setup (){
        usuario = new Usuario();
        usuario.setNome("Ana");

        usuarioEntradaDTO = new UsuarioEntradaDTO();
        usuarioEntradaDTO.setNome("Maria");
        usuarioEntradaDTO.setEmail("maria@maria");
        usuarioEntradaDTO.setCpf("094.408.150-94");

        usuarioSaidaDTO = new UsuarioSaidaDTO();
        usuarioSaidaDTO.setNome("Leo");

        objectMapper = new ObjectMapper();
    }

    @Test
    public void testarCadastrarUsuario () throws Exception{
        Mockito.when(usuarioService.salvar(Mockito.any(Usuario.class))).thenReturn(usuario);
        String json = objectMapper.writeValueAsString(usuarioEntradaDTO);

        ResultActions resultado = mockMvc.perform(MockMvcRequestBuilders.post("/usuarios")
                        .content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().is(201));

        String jsonResposta = resultado.andReturn().getResponse().getContentAsString();
        var resposta = objectMapper.readValue(jsonResposta, UsuarioSaidaDTO.class);
        Mockito.verify(usuarioService,Mockito.times(1)).salvar(Mockito.any(Usuario.class));
    }

}
