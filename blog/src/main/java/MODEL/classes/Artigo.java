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
public class Artigo {
    
    private int idArtigo;
    private Usuario usuario;
    private Categoria categoria;
    private String titulo;
    private String conteudo;
    private char liberado;
    private char aprovado;

    public void setIdArtigo(int idArtigo) {
        this.idArtigo = idArtigo;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public void setLiberar(char liberado) {
        this.liberado = liberado;
    }

    public void setAprovado(char aprovado) {
        this.aprovado = aprovado;
    }    
    

    public int getIdArtigo() {
        return idArtigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public char isLiberado() {
        return liberado;
    }

    public char isAprovado() {
        return aprovado;
    }
    
    
    
}
