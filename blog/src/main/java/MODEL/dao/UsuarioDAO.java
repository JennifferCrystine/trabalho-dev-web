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

/**
 *
 * @author jenniffercrystine
 */
public class UsuarioDAO {
    private final int INF = -9999; //variavel usada para representar valor infinito
    
    public int criar(Usuario usuario) {
        Connection con = Conexao.getConnection();
        PreparedStatement stm= null;
        ResultSet resultado = null;
        int response = INF;
        try {
            stm=con.prepareStatement("INSERT into usuario(nome,email,"
                    + "senha,cpf,papel) VALUES (?,?,?,?,?)");
            stm.setString(1, usuario.getNome());
            stm.setString(2, usuario.getEmail());
            stm.setString(3, usuario.getSenha());
            stm.setString(4, usuario.getCpf());
            stm.setInt(5, usuario.getPapel());
            response = stm.executeUpdate();
            if (response == 1) {
                stm=con.prepareStatement("select LAST_INSERT_ID() as idUsuario");
                resultado = stm.executeQuery();
                if (resultado.next()) {
                    usuario.setIdUsuario(resultado.getInt("idUsuario"));
                }
            }
        }catch (SQLException ex) {
            System.out.println("Problemas ao conectar ao banco: "+ex);
        } finally{
            Conexao.closeConnection(con, stm);
        }
        return response;
    }  
    
    public Usuario buscaUsuario(int idUsuario) {
        Connection con = Conexao.getConnection();
        PreparedStatement stm= null;
        ResultSet resultado = null;
        Usuario usuario = new Usuario();
        try {
            stm = con.prepareStatement("select * from usuario where id=?");
            stm.setInt(1, idUsuario);
            resultado = stm.executeQuery();
            while(resultado.next()){
                usuario.setIdUsuario(resultado.getInt("id"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setEmail(resultado.getString("email"));   
                usuario.setCpf(resultado.getString("cpf"));
                usuario.setPapel(resultado.getInt("papel"));
                if (resultado.getString("cadastro_aprovado") != null) {                    
                    usuario.setAprovado(resultado.getString("cadastro_aprovado").charAt(0));
                }
            }            
        } catch (SQLException ex) {
            System.out.println("Problemas ao conectar com o banco: "+ex);
        } finally {
            Conexao.closeConnection(con, stm, resultado);
        }
        return usuario;
    }
     
    public void editar(Usuario usuario, int id, String acao) {
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        String cadAprov = null;
        try {
            stm=con.prepareStatement("UPDATE usuario\n" +
                                "SET nome = ?, email = ?, senha = ?, "
                    + "cpf = ?, cadastro_aprovado=?\n" +
                                "where id = ?;");

            if (usuario.getAprovado() == 'S') {
                cadAprov = "S";
            }
            stm.setString(1, usuario.getNome());
            stm.setString(2, usuario.getEmail());
            stm.setString(3, usuario.getSenha());
            stm.setString(4, usuario.getCpf());

            stm.setString(5, cadAprov);
            stm.setInt(6, usuario.getIdUsuario());
            stm.executeUpdate();            
        }catch (SQLException ex) {
            System.out.println("Problemas ao conectar ao banco: "+ex);
        } finally{
            Conexao.closeConnection(con, stm);
        }
    }
    
    public void aprovaCadastroUsuario(int id) {
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        try {
            stm=con.prepareStatement("UPDATE usuario cadastro_aprovado=?\n" +
                                "where id = ?;");
            stm.setString(1, "S");
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
    
    public boolean checaSeAprovado(int id) {
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        ResultSet resultado = null;
        char status = 'E'; //empty ou vazio
        try {
            stm = con.prepareStatement("SELECT cadastro_aprovado from usuario where id =?");
            stm.setInt(1, id);
            resultado = stm.executeQuery();            
            while(resultado.next()){
                status = resultado.getString("cadastro_aprovado").charAt(0);
            }
            if (status == 'N' || status == 'E'){
                return false;
            }
            else if (status == 'S') {
                return true;
            }
            
        }
        catch(SQLException ex){
            System.out.println("Problemas ao conectar ao banco: "+ex);
        }
        finally {
            Conexao.closeConnection(con, stm, resultado);            
        }
        return false;
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
            stm = con.prepareStatement("SELECT * from usuario where cadastro_aprovado=? "
                    + "or cadastro_aprovado is null");
            stm.setString(1, "N");
            resultado = stm.executeQuery();
            while(resultado.next()){
                Usuario usuario = new Usuario();
                usuario.setIdUsuario(resultado.getInt("id"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setCpf(resultado.getString("cpf"));
                usuario.setEmail(resultado.getString("email"));
                usuario.setPapel(resultado.getInt("papel"));
                usuarios.add(usuario);
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
   
     
    public int retornaPapel (Usuario usuario) {
        Connection con = Conexao.getConnection();
        PreparedStatement stm; 
        ResultSet resultado = null;
        int papel = INF;
        
        try {
            stm = con.prepareStatement("select papel from usuario where id = ?");
            stm.setInt(1, usuario.getIdUsuario());
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
        int papel = retornaPapel(usuario);       
        if (papel == 0){
            return true;
        }  
        else{
            return false;
        }        
    }
     
    public boolean isAutor(Usuario usuario) {
        int papel = retornaPapel(usuario);       
        if (papel == 1){
            return true;
        }  
        else{
            return false;
        }        
    }
    
    public boolean isComentarista(Usuario usuario) {
        int papel = retornaPapel(usuario);       
        if (papel == 2){
            return true;
        }  
        else{
            return false;
        }        
    }
}

