/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.dao;

import MODEL.classes.Artigo;
import MODEL.classes.Categoria;
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
    
    public Categoria buscaCategoria(int idCategoria) {
        Connection con = Conexao.getConnection();
        PreparedStatement stm= null;
        ResultSet resultado = null;
        Categoria categoria = new Categoria();
        try {
            stm = con.prepareStatement("select * from categoria where id=?");
            stm.setInt(1, idCategoria);
            resultado = stm.executeQuery();
            while(resultado.next()){
                categoria.setIdCategoria(resultado.getInt("id"));
                categoria.setDescricao(resultado.getString("descricao"));                
            }            
        } catch (SQLException ex) {
            System.out.println("Problemas ao conectar com o banco: "+ex);
        } finally {
            Conexao.closeConnection(con, stm, resultado);
        }
        return categoria;
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
    
    public List<Categoria> getCategorias() {
        Connection con = Conexao.getConnection();
        PreparedStatement stm= null;
        ResultSet resultado = null;        
        List <Categoria> categorias = new ArrayList();
        
        try {
            stm = con.prepareStatement("select * from categoria");
            resultado = stm.executeQuery();
            while(resultado.next()){
                Categoria categoria = new Categoria();
                categoria.setIdCategoria(resultado.getInt("id"));
                categoria.setDescricao(resultado.getString("descricao"));  
                categorias.add(categoria);
            }            
        } catch (SQLException ex) {
            System.out.println("Problemas ao conectar com o banco: "+ex);
        } finally {
            Conexao.closeConnection(con, stm, resultado);
        }
        return categorias;
    }
}
