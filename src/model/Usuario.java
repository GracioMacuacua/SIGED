package model;

import java.io.Serializable;

/**
 *
 * @author Grácio Macuácua
 */

public class Usuario implements Serializable{

    private String nome;
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
