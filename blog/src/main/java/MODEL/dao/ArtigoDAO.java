/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.dao;

import MODEL.classes.Artigo;
import MODEL.classes.Categoria;
import MODEL.dao.CategoriaDAO;
import MODEL.classes.Usuario;
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
public class ArtigoDAO {
    
    public void criar(Artigo artigo) {
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
            System.out.println("Problemas ao conectar ao banco: "+ex);
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
    
    
    public List<Artigo> getArtigos() {
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        ResultSet resultado = null;
        List <Artigo> artigos = new ArrayList();
        
        try {
            stm = con.prepareStatement("select * from artigo");
            resultado = stm.executeQuery();
            while(resultado.next()) {
                Artigo artigo = new Artigo();
                Categoria categoria = new Categoria();
                CategoriaDAO categoriaDAO = new CategoriaDAO();
                Usuario usuario = new Usuario();
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                artigo.setIdArtigo(resultado.getInt("id"));
                int idCategoria = resultado.getInt("id_categoria");                
                categoria = categoriaDAO.buscaCategoria(idCategoria);
                artigo.setCategoria(categoria);
                int idUsuario = resultado.getInt("id_usuario");
                usuario = usuarioDAO.buscaUsuario(idUsuario);
                artigo.setUsuario(usuario);                
                artigos.add(artigo);                
            }
        }
        catch(SQLException ex){
            System.out.println("Problemas ao conectar ao banco: "+ex);
        }
        finally {
            Conexao.closeConnection(con, stm, resultado);
        }
        return artigos;
    }
}
