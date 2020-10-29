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
public class Comentario {
    private int idComentario;
    private String comentario;
    private Artigo artigo;
    private Usuario usuario;

    public void setIdComentario(int idComentario) {
        this.idComentario = idComentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public void setArtigo(Artigo artigo) {
        this.artigo = artigo;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }    
    

    public int getIdComentario() {
        return idComentario;
    }

    public String getComentario() {
        return comentario;
    }

    public Artigo getArtigo() {
        return artigo;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    
    
    
}
