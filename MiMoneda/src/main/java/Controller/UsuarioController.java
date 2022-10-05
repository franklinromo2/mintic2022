/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Beans.Usuarios;
import Connection.DBConnection;
import com.google.gson.Gson;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DirectorTic
 */
public class UsuarioController implements IUsuarioController {

    @Override
    public String login(String pk_usr_login, String usr_password) {
        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select * from usuarios where pk_usr_login = '" + pk_usr_login
                + "' and usr_password = '" + usr_password + "'";

        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String usr_nombre = rs.getString("usr_nombre");
                String usr_email = rs.getString("usr_email");

                Usuarios objusuario = new Usuarios(pk_usr_login, usr_password, usr_nombre, usr_email);

               // System.out.println(objusuario.toString());

                return gson.toJson(objusuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
    
    
    @Override
    public String registrar(String pk_usr_login, String usr_password, String usr_nombre, String usr_email) {
        
        DBConnection con = new DBConnection();
        String sql =  "INSERT INTO usuarios (pk_usr_login,usr_password,usr_nombre,usr_email) VALUES (" +
        "'"+pk_usr_login+"','"+usr_password+"','"+usr_nombre+"','"+usr_email+"')";
 
        try {
            Statement st = con.getConnection().createStatement();
            st.execute(sql);            
            st.close();            
            return "OK";        
            
        } catch (SQLException ex) {
             System.out.println( ex.getMessage());
        }
         finally {
            con.desconectar();
        }
        
        return "false";
    }

 
    
    @Override
    public String consultar(String pk_usr_login) {
        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select * from usuarios where pk_usr_login = '" + pk_usr_login + "'";

        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                String usr_password = rs.getString("usr_password");
                String usr_nombre = rs.getString("usr_nombre");
                String usr_email = rs.getString("usr_email");
                

                Usuarios objusuario = new Usuarios(pk_usr_login, usr_password, usr_nombre, usr_email);

               // System.out.println(objusuario.toString());

                return gson.toJson(objusuario);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return "false";
    }
    
    
    @Override
    public String actualizar(String pk_usr_login, String usr_password, String usr_nombre, String usr_email) {
        
        DBConnection con = new DBConnection();
        String sql =  "UPDATE usuarios SET usr_password= '"+usr_password+"', usr_nombre= '"+usr_nombre+"', "+
                "usr_email = '"+usr_email+"' WHERE pk_usr_login = '"+pk_usr_login+"'";
 
        try {
            Statement st = con.getConnection().createStatement();
            st.execute(sql);            
            st.close();            
            return "OK";        
            
        } catch (SQLException ex) {
             System.out.println( ex.getMessage());
        }
         finally {
            con.desconectar();
        }
        
        return "false";
    }

    
     @Override
    public String eliminar(String pk_usr_login) {
        
        DBConnection con = new DBConnection();
        String sql =  "DELETE FROM  usuarios WHERE pk_usr_login = '"+pk_usr_login+"'";
 
        try {
            Statement st = con.getConnection().createStatement();
            st.execute(sql);            
            st.close();            
            return "OK";        
            
        } catch (SQLException ex) {
             System.out.println( ex.getMessage());
        }
         finally {
            con.desconectar();
        }        
        return "false";
    }

    
    
}
