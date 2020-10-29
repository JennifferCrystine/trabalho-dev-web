/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.dao;

import MODEL.classes.Artigo;
import MODEL.utilitarios.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author jenniffercrystine
 */
public class ArtigoDAO {
    
    public void criar(Artigo artigo) throws SQLException{
        Connection con = Conexao.getConnection();
        PreparedStatement stm= null;
        try {
            stm=con.prepareStatement("INSERT into artigo((usuario,categoria,titulo,"
                    + "conteudo,liberar,aprovado) VALUES (?,?,?,?,?,?)) ");
            stm.setInt(1, artigo.getUsuario().getIdUsuario());
            stm.setInt(2, artigo.getCategoria().getIdCategoria());
            stm.setString(3, artigo.getTitulo());
            stm.setString(4, artigo.getConteudo());
            stm.setString(5, String.valueOf(artigo.isLiberado()));
            stm.setString(6, String.valueOf(artigo.isAprovado()));
            stm.executeUpdate();
        }catch (SQLException ex) {
            throw new SQLException("Problemas ao conectar ao banco.");
        } finally{
            Conexao.closeConnection(con, stm);
        }
    }   
     
    public void editar(Artigo artigo, int id) throws SQLException{
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        try {
            stm=con.prepareStatement("UPDATE categoria\n" +
                                    "SET titulo = ?, conteudo = ?\n" +
                                    "where id = ?;");
            stm.setString(1, artigo.getTitulo());
            stm.setString(2, artigo.getConteudo());
            stm.setInt(3, artigo.getIdArtigo());
            stm.executeUpdate();            
        }catch (SQLException ex) {
            throw new SQLException("Problemas ao conectar ao banco.");
        } finally{
            Conexao.closeConnection(con, stm);
        }
    }
        
    public void remover(Artigo artigo) throws SQLException {
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("DELETE from categoria where id=?");
            stm.setInt(1, artigo.getIdArtigo());
            stm.executeUpdate();
        }
        catch(SQLException ex){
            throw new SQLException("Problemas ao conectar ao banco.");
        }
        finally {
            Conexao.closeConnection(con, stm);
        }
    }   
}
