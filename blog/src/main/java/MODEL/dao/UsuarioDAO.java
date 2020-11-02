/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL.dao;
import MODEL.classes.Usuario;
import MODEL.utilitarios.Conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jenniffercrystine
 */
public class UsuarioDAO {
    private final int INF = -9999; //variavel usada para representar valor infinito
    
    public void criar(Usuario usuario) {
        Connection con = Conexao.getConnection();
        PreparedStatement stm= null;
        try {
            stm=con.prepareStatement("INSERT into usuario(nome,email,"
                    + "senha,cpf,papel) VALUES (?,?,?,?,?) ");
            stm.setString(1, usuario.getNome());
            stm.setString(2, usuario.getEmail());
            stm.setString(3, usuario.getSenha());
            stm.setString(4, usuario.getCpf());
            stm.setInt(5, usuario.getPapel());
            stm.executeUpdate();
        }catch (SQLException ex) {
            System.out.println("Problemas ao conectar ao banco: "+ex);
        } finally{
            Conexao.closeConnection(con, stm);
        }
    }   
     
    public void editar(Usuario usuario, int id) {
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        try {
            stm=con.prepareStatement("UPDATE usuario\n" +
                                    "SET nome = ?, email = ?, senha = ?, cpf = ?,\n" +
                                    "where id = ?;");
            stm.setString(1, usuario.getNome());
            stm.setString(2, usuario.getEmail());
            stm.setString(3, usuario.getSenha());
            stm.setString(4, usuario.getCpf());
            stm.setInt(5, usuario.getIdUsuario());
            stm.executeUpdate();
            
        }catch (SQLException ex) {
            System.out.println("Problemas ao conectar ao banco: "+ex);
        } finally{
            Conexao.closeConnection(con, stm);
        }
    }
        
    public void remover(Usuario usuario) {
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        try {
            stm = con.prepareStatement("DELETE from usuario where id=?");
            stm.setInt(1, usuario.getIdUsuario());
            stm.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println("Problemas ao conectar ao banco: "+ex);
        }
        finally {
            Conexao.closeConnection(con, stm);
        }
    }
    
    public List<Usuario> getUsuariosAprovados() {
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        ResultSet resultado = null;
        List <Usuario> usuarios = new ArrayList();
        try {
            stm = con.prepareStatement("SELECT * from usuario where cadastro_aprovado=?");
            stm.setInt(1, 1);
            resultado = stm.executeQuery();            
            while(resultado.next()){
                usuarios.add((Usuario)resultado);
            }
            
        }
        catch(SQLException ex){
            System.out.println("Problemas ao conectar ao banco: "+ex);
        }
        finally {
            Conexao.closeConnection(con, stm, resultado);            
        }
        return usuarios;
    }
    
     public List<Usuario> getUsuariosNaoAprovados() {
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        ResultSet resultado = null;
        List <Usuario> usuarios = new ArrayList();
        try {
            stm = con.prepareStatement("SELECT * from usuario where cadastro_aprovado=?");
            stm.setInt(1, 0);
            resultado = stm.executeQuery();
            while(resultado.next()){
                usuarios.add((Usuario)resultado);
            }
            
        }
        catch(SQLException ex){
            System.out.println("Problemas ao conectar ao banco: "+ex);
        }
        finally {
            Conexao.closeConnection(con, stm, resultado);            
        }
        return usuarios;
    }
     
     public Usuario validarUsuario (String cpf, String senha) {
        Connection con = Conexao.getConnection();
        PreparedStatement stm; 
        ResultSet resultado = null;
        Usuario usuario = new Usuario();
        try{
            stm = con.prepareStatement("select * from usuario where cpf = ? and "
                    + "senha = ?");
            stm.setString(1, cpf);
            stm.setString(2, senha);
            resultado = stm.executeQuery();
            while(resultado.next()){
               usuario.setIdUsuario(resultado.getInt("id"));
               usuario.setNome(resultado.getString("nome"));
               usuario.setEmail(resultado.getString("email"));
               usuario.setSenha(resultado.getString("senha"));
               usuario.setCpf(resultado.getString("cpf"));
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao conectar ao banco: "+ex);
        } finally{
            Conexao.closeConnection(con, null, resultado);
        }
        return usuario;
    } 
     
   
     
    public int checaPapel (Usuario usuario) {
        Connection con = Conexao.getConnection();
        PreparedStatement stm; 
        ResultSet resultado = null;
        int papel = INF;
        
        try {
            stm = con.prepareStatement("select papel from usuario where id = ?");
            stm.setInt(0, usuario.getIdUsuario());
            resultado = stm.executeQuery();
            while(resultado.next()) {
                papel = resultado.getInt("papel");
            }    
        } catch(SQLException ex) {
            System.out.println("Problemas ao conectar ao banco: "+ex);
        } 
        return papel;
    }
    
     public boolean isAdmin(Usuario usuario) {
        int papel = checaPapel(usuario);
        if (papel == INF || papel != 0){
            return false;
        }        
        else if (papel == 0){
            return true;
        }        
        return false;
    }
     
    public boolean isAutor(Usuario usuario) {
        int papel = checaPapel(usuario);
        if (papel == INF || papel != 1){
            return false;
        }        
        else if (papel == 1){
            return true;
        }        
        return false;
    }
    
    public boolean isComentarista(Usuario usuario) {
        int papel = checaPapel(usuario);
        if (papel == INF || papel != 2){
            return false;
        }        
        else if (papel == 2){
            return true;
        }        
        return false;
    }
}

