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
            stm=con.prepareStatement("INSERT into artigo(id_usuario,id_categoria,titulo,"
                    + "conteudo,liberar,aprovado) VALUES (?,?,?,?,?,?) ");
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
     
    public void editar(int idArtigo, String titulo, String conteudo, int idCategoria) {
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;        
        try {
            if (idCategoria == 0) {
                Artigo artigo = this.buscaArtigo(idArtigo);
                idCategoria = artigo.getCategoria().getIdCategoria();
            }
            stm=con.prepareStatement("UPDATE artigo\n" +
                                    "SET titulo = ?, conteudo = ?, id_categoria = ?\n" +
                                    "where id = ?;");
            stm.setString(1, titulo);
            stm.setString(2, conteudo);
            stm.setInt(4, idArtigo);
            stm.setInt(3, idCategoria);
            stm.executeUpdate();            
        }catch (SQLException ex) {
            System.out.println("Problemas ao conectar ao banco: "+ex);
        } finally{
            Conexao.closeConnection(con, stm);
        }
    }
        
    public void remover(int id) {
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("DELETE from artigo where id=?");
            stm.setInt(1, id);
            stm.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println("Problemas ao conectar ao banco: "+ex);
        }
        finally {
            Conexao.closeConnection(con, stm);
        }
    }   
    
    
    public void aprovaArtigo(int id) {
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        try {
            stm=con.prepareStatement("update artigo set aprovado=? " +
                                "where id = ?");
            stm.setString(1, "S");
            stm.setInt(2, id);
            stm.executeUpdate();            
        }catch (SQLException ex) {
            System.out.println("Problemas ao conectar ao banco: "+ex);
        } finally{
            Conexao.closeConnection(con, stm);
        } 
    }
    
    
    public void reprovaArtigo(int id) {
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        try {
            stm=con.prepareStatement("update artigo set aprovado=? " +
                                "where id = ?");
            stm.setString(1, "N");
            stm.setInt(2, id);
            stm.executeUpdate();            
        }catch (SQLException ex) {
            System.out.println("Problemas ao conectar ao banco: "+ex);
        } finally{
            Conexao.closeConnection(con, stm);
        } 
    }
    
    public Artigo buscaArtigo(int idArtigo) {
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        ResultSet resultado = null;
        Artigo artigo = new Artigo();
        Categoria categoria;
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        Usuario usuario;
        UsuarioDAO usuarioDAO = new UsuarioDAO();            
        try {
            stm = con.prepareStatement("select * from artigo where id = ?");
            stm.setInt(1, idArtigo);
            resultado = stm.executeQuery();
            if (resultado.next()) {
                artigo.setIdArtigo(resultado.getInt("id"));
                int idCategoria = resultado.getInt("id_categoria");                
                categoria = categoriaDAO.buscaCategoria(idCategoria);
                artigo.setCategoria(categoria);
                int idUsuario = resultado.getInt("id_usuario");
                usuario = usuarioDAO.buscaUsuario(idUsuario);
                artigo.setUsuario(usuario);                
                artigo.setTitulo(resultado.getString("titulo"));
                artigo.setConteudo(resultado.getString("conteudo"));                
            }
        }
        catch(SQLException ex){
            System.out.println("Problemas ao conectar ao banco: "+ex);
        }
        finally {
            Conexao.closeConnection(con, stm, resultado);
        }
        return artigo;
    }
    
    
    public List<Artigo> getArtigos(String aprovado) {
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        ResultSet resultado = null;
        String s = null;
        List <Artigo> artigos = new ArrayList();
        if (aprovado.equals("S")) {
            s = "S";
        }
        else if (aprovado.equals("N")) {
            s = "N";        
        }
            
        try {
            stm = con.prepareStatement("select * from artigo where aprovado = ?");
            stm.setString(1, s);
            resultado = stm.executeQuery();
            while(resultado.next()) {
                Artigo artigo = new Artigo();
                Categoria categoria;
                CategoriaDAO categoriaDAO = new CategoriaDAO();
                Usuario usuario;
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                artigo.setIdArtigo(resultado.getInt("id"));
                int idCategoria = resultado.getInt("id_categoria");                
                categoria = categoriaDAO.buscaCategoria(idCategoria);
                artigo.setCategoria(categoria);
                int idUsuario = resultado.getInt("id_usuario");
                usuario = usuarioDAO.buscaUsuario(idUsuario);
                artigo.setUsuario(usuario);                
                artigo.setTitulo(resultado.getString("titulo"));
                artigo.setConteudo(resultado.getString("conteudo"));
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
    
    public List<Artigo> getUsuarioArtigos(int id, String aprovado) {
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        ResultSet resultado = null;
        List <Artigo> artigos = new ArrayList();
        String s = null;
        if (aprovado.equals("S")) {
            s = "S";
        }
        else if (aprovado.equals("N")) {
            s = "N";        
        }
        
        try {
            stm = con.prepareStatement("select * from artigo where id_usuario = ?  "
                    + "and aprovado = ?");
            stm.setInt(1, id);
            stm.setString(2, s);
            resultado = stm.executeQuery();
            while(resultado.next()) {
                Artigo artigo = new Artigo();
                Categoria categoria;
                CategoriaDAO categoriaDAO = new CategoriaDAO();
                Usuario usuario;
                UsuarioDAO usuarioDAO = new UsuarioDAO();
                artigo.setIdArtigo(resultado.getInt("id"));
                int idCategoria = resultado.getInt("id_categoria");                
                categoria = categoriaDAO.buscaCategoria(idCategoria);
                artigo.setCategoria(categoria);
                int idUsuario = resultado.getInt("id_usuario");
                usuario = usuarioDAO.buscaUsuario(idUsuario);
                artigo.setUsuario(usuario);                
                artigo.setTitulo(resultado.getString("titulo"));
                artigo.setConteudo(resultado.getString("conteudo"));
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
