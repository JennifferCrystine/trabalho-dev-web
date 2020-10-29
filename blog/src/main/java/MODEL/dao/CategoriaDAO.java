/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.dao;

import MODEL.classes.Categoria;
import MODEL.utilitarios.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author jenniffercrystine
 */
public class CategoriaDAO {
    
    public void criar(Categoria categoria) throws SQLException{
        Connection con = Conexao.getConnection();
        PreparedStatement stm= null;
        try {
            stm=con.prepareStatement("INSERT into categoria(descricao) VALUES (?) ");
            stm.setString(1, categoria.getDescricao());
            stm.executeUpdate();
        }catch (SQLException ex) {
            throw new SQLException("Problemas ao conectar ao banco.");
        } finally{
            Conexao.closeConnection(con, stm);
        }
    }   
     
    public void editar(Categoria categoria, int id) throws SQLException{
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        try {
            stm=con.prepareStatement("UPDATE categoria\n" +
                                    "SET descricao = ?,\n" +
                                    "where id = ?;");
            stm.setString(1, categoria.getDescricao());
            stm.setInt(2, categoria.getIdCategoria());
            stm.executeUpdate();
            
        }catch (SQLException ex) {
            throw new SQLException("Problemas ao conectar ao banco.");
        } finally{
            Conexao.closeConnection(con, stm);
        }
    }
        
    public void remover(Categoria categoria) throws SQLException {
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("DELETE from categoria where id=?");
            stm.setInt(1, categoria.getIdCategoria());
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
