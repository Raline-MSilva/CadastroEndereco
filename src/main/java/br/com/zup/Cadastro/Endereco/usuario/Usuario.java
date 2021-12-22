package br.com.zup.Cadastro.Endereco.usuario;

import br.com.zup.Cadastro.Endereco.endereco.Endereco;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "usuarios")
@Data
public class Usuario {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String nome;
    private String cpf;
    @OneToMany
    private List <Endereco> endereco;

}
