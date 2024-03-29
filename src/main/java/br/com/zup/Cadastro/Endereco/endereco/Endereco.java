package br.com.zup.Cadastro.Endereco.endereco;

import br.com.zup.Cadastro.Endereco.usuario.Usuario;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "enderecos")
@Data
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String cep;
    private String logradouro;
    private int numero;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private Usuario usuario;
}
