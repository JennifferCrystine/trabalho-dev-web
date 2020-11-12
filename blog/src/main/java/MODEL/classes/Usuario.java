/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.classes;

/**
 *
 * @author jenniffercrystine
 */
public class Usuario {
    private int idUsuario;
    private String nome;
    private String email;
    private String senha;
    private String cpf;
    private byte aprovado;
    private int papel;

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }  
    

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setAprovado(byte aprovado) {
        this.aprovado = aprovado;
    }

    public void setPapel(int papel) {
        this.papel = papel;
    }    

    public int getIdUsuario() {
        return idUsuario;
    } 

    
    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getCpf() {
        return cpf;
    }

    public byte getAprovado() {
        return aprovado;
    }

    public int getPapel() {
        return papel;
    }
    
    public String getPapel(int papel) {
        String r;
        switch (papel) {
            case 0:
                r = "Admin";
                break;
            case 1:
                r = "Autor";
                break;
            case 2:
                r = "Comentarista";
                break;
            default:
                r = null;
        }
        return r;        
    }
}
