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
                    + "senha,cpf,papel,cadastro_aprovado) VALUES (?,?,?,?,?,?)");
            stm.setString(1, usuario.getNome());
            stm.setString(2, usuario.getEmail());
            stm.setString(3, usuario.getSenha());
            stm.setString(4, usuario.getCpf());
            stm.setInt(5, usuario.getPapel());            
            stm.setString(6, "N");
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
    
    public Usuario buscaUsuario(String cpf) {
        Connection con = Conexao.getConnection();
        PreparedStatement stm= null;
        ResultSet resultado = null;
        Usuario usuario = new Usuario();
        try {
            stm = con.prepareStatement("select * from usuario where cpf=? limit 1");
            stm.setString(1, cpf);
            resultado = stm.executeQuery();
            if (resultado.next()){
                usuario.setIdUsuario(resultado.getInt("id"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setEmail(resultado.getString("email"));   
                usuario.setCpf(resultado.getString("cpf"));
                usuario.setPapel(resultado.getInt("papel"));
                char cad = resultado.getString("cadastro_aprovado").charAt(0);
                usuario.setAprovado(cad);
            }            
        } catch (SQLException ex) {
            System.out.println("Problemas ao conectar com o banco: "+ex);
        } finally {
            Conexao.closeConnection(con, stm, resultado);
        }
        return usuario;
    }
    
    public boolean verificaCPF(Object object) {
        
        Connection con = Conexao.getConnection();
        PreparedStatement stm= null;
        ResultSet resultado = null;
        boolean existeCPF = false;
        String cpf = null;
        try {
            if (object instanceof Usuario){
                cpf = ((Usuario) object).getCpf();                
            }
            else if (object instanceof String) {
                cpf = (String)object;
            }
            stm = con.prepareStatement("select * from usuario where cpf=?");
            stm.setString(1, cpf);
            resultado = stm.executeQuery();
            if (resultado.next()){ //existe usuario com aquele cpf
                existeCPF = true;
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao conectar com o banco: "+ex);
        } finally {
            Conexao.closeConnection(con, stm, resultado);
        }
        return existeCPF; 
    }
    
    public Usuario buscaUsuario(int id) {
        Connection con = Conexao.getConnection();
        PreparedStatement stm= null;
        ResultSet resultado = null;
        Usuario usuario = new Usuario();
        try {
            stm = con.prepareStatement("select * from usuario where id=?");
            stm.setInt(1, id);
            resultado = stm.executeQuery();
            while(resultado.next()){
                usuario.setIdUsuario(resultado.getInt("id"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setEmail(resultado.getString("email"));   
                usuario.setCpf(resultado.getString("cpf"));
                usuario.setPapel(resultado.getInt("papel"));
                usuario.setAprovado(resultado.getString("cadastro_aprovado").charAt(0));
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
        String cadAprov = "N";
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
            stm=con.prepareStatement("UPDATE usuario set cadastro_aprovado=?\n" +
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
        char status = 'N'; //empty ou vazio
        boolean aprovado = false;
        try {
            stm = con.prepareStatement("SELECT cadastro_aprovado from usuario where id =?");
            stm.setInt(1, id);
            resultado = stm.executeQuery();            
            if(resultado.next()){
                status = resultado.getString("cadastro_aprovado").charAt(0);    
            }
            if (status == 'S'){
                aprovado = true;
            }            
        }
        catch(SQLException ex){
            System.out.println("Problemas ao conectar ao banco: "+ex);
        }
        finally {
            Conexao.closeConnection(con, stm, resultado);            
        }
        return aprovado;
    }
    
    public List<Usuario> getUsuariosAprovados() {
        Connection con = Conexao.getConnection();
        PreparedStatement stm = null;
        ResultSet resultado = null;
        List <Usuario> usuarios = new ArrayList();
        try {
            stm = con.prepareStatement("SELECT * from usuario where cadastro_aprovado=?");
            stm.setString(1, "S");
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

    public boolean validarUsuario (String cpf, String senha) {
        Connection con = Conexao.getConnection();
        PreparedStatement stm; 
        ResultSet resultado = null;
        boolean existe = false;
        try{
            stm = con.prepareStatement("select * from usuario where cpf = ? and "
                    + "senha = ?");
            stm.setString(1, cpf);
            stm.setString(2, senha);
            resultado = stm.executeQuery();
            if(resultado.next() == true){
                existe = true;
            }
        } catch (SQLException ex) {
            System.out.println("Problemas ao conectar ao banco: "+ex);
        } finally{
            Conexao.closeConnection(con, null, resultado);
        }
        return existe;
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
        return usuario.getPapel() == 0;    
    }
     
    public boolean isAutor(Usuario usuario) {
        return usuario.getPapel() == 1;         
    }
    
    public boolean isComentarista(Usuario usuario) {
        return usuario.getPapel() == 2;         
    }
}

