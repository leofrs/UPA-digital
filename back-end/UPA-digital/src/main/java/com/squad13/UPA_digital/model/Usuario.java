package com.squad13.UPA_digital.model;

import com.squad13.UPA_digital.utils.TipoUsuario;
import jakarta.persistence.*;

// @Entity Define que a classe Usuario será uma entidade gerenciada pelo JPA.
@Entity
//@Table (Opcional) Especifica o nome da tabela no banco de dados. Sem essa anotação, o JPA usará o nome da classe como padrão.
@Table(name="usuarios")
public class Usuario {

    //TODO: ver se consegue ajeitar a classe para padronizar para usuário, médico e enfermeiro
//  @Id: Marca o atributo como chave primária. (PODEMOS CONVERSAR PARA FAZER DO cpf O ID)
    @Id
//  @GeneratedValue(strategy = GenerationType.IDENTITY): Informa que o banco será responsável por gerar os IDs automaticamente.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


//@Column: faz o banco de dados criar uma coluna a partir desse atributo (nullable = false) não pode ser nulo e (unique = true) não pode ser igual de outro
    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private String crm;

    @Column(nullable = false)
    private String coren;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;

    // contrutor do usuário
    public Usuario(String cpf, String senha) {
        this.cpf = cpf;
        this.senha = senha;
        this.tipoUsuario = tipoUsuario.USUARIO;
    }

    // construtor do médico
    public Usuario(String cpf, String senha, String credencial, TipoUsuario tipoUsuario) {
        this.cpf = cpf;
        this.senha = senha;
        if(tipoUsuario == TipoUsuario.MEDICO) {
            this.crm = credencial;
        } else if (tipoUsuario == TipoUsuario.ENFERMEIRO) {
            this.coren = credencial;
        }
    }

    //construtor vazio - obrigatório por causa da @Entity
    public Usuario() {    }

    //Getters e Setters
    public Long getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    /* toString() A função toString() é uma sobrescrita do método padrão toString da classe Object. Ela é usada para
    fornecer uma representação textual (em forma de String) do objeto da classe, geralmente útil para debugging ou
    logging. */
    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", cpf='" + cpf + '\'' +
                ", senha='" + senha + '\'' +
                '}';
    }
}
