/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.dao;
import MODEL.classes.Comentario;
import MODEL.classes.Artigo;
import MODEL.utilitarios.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jenniffercrystine
 */
public class ComentarioDAO {
    
    public void criar(Comentario comentario) throws SQLException{
        Connection con = Conexao.getConnection();
        PreparedStatement stm= null;
        try {
            stm=con.prepareStatement("INSERT into comentario(comentario, id_artigo, "
                    + "id_usuario) VALUES (?,?,?) ");
            stm.setString(1, comentario.getComentario());
            stm.setInt(2, comentario.getArtigo().getIdArtigo());
            stm.setInt(3, comentario.getUsuario().getIdUsuario());
            stm.executeUpdate();
        }catch (SQLException ex) {
            throw new SQLException("Problemas ao conectar ao banco.");
        } finally{
            Conexao.closeConnection(con, stm);
        }
    }   
     
    public void editar(Comentario comentario, int id) throws SQLException{
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        try {
            stm=con.prepareStatement("UPDATE comentario\n" +
                                    "SET comentario = ?,\n" +
                                    "where id = ?;");
            stm.setString(1, comentario.getComentario());
            stm.setInt(2, comentario.getIdComentario());
            stm.executeUpdate();
            
        }catch (SQLException ex) {
            throw new SQLException("Problemas ao conectar ao banco.");
        } finally{
            Conexao.closeConnection(con, stm);
        }
    }
        
    public void remover(Comentario comentario) throws SQLException {
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("DELETE from categoria where id=?");
            stm.setInt(1, comentario.getIdComentario());
            stm.executeUpdate();
        }
        catch(SQLException ex){
            throw new SQLException("Problemas ao conectar ao banco.");
        }
        finally {
            Conexao.closeConnection(con, stm);
        }
    }  
    
    public List<Comentario> getArtigoComentarios(Artigo artigo) throws SQLException {
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        ResultSet resultado = null;
        List <Comentario> comentarios = new ArrayList();
        try {
            stm = con.prepareStatement("SELECT * from comentario where id_artigo=?");
            stm.setInt(1, artigo.getIdArtigo());
            resultado = stm.executeQuery();
            while(resultado.next()){
                comentarios.add((Comentario)resultado);
            }
            
        }
        catch(SQLException ex){
            throw new SQLException("Problemas ao conectar ao banco.");
        }
        finally {
            Conexao.closeConnection(con, stm, resultado);            
        }
        return comentarios;
    }
    
}
