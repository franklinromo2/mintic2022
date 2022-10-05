/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import Beans.Usuarios;
import Connection.DBConnection;
import Controller.PlanesInversionController;
import Controller.UsuarioController;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author DirectorTic
 */
public class Pruebas {
    
    public static void main(String[] args) {
        //PruebaUsuario();
        //PuebaLogin();
       // PuebaRegistrar();
       //ConsultarUsuario();
      // ActualizarUsuario();
      ConsultarPlanes();
    }

    
     public static void ConsultarPlanes()
    {
        PlanesInversionController objplanes = new  PlanesInversionController();
         System.out.println(objplanes.consultar());
                
    }
   
     
     public static void ActualizarUsuario()
    {
        UsuarioController objusuario = new  UsuarioController();
        
         System.out.println(objusuario.actualizar("pepe","123","pepe mojica","correo@com.so"));
                
    }
   
     
    public static void ConsultarUsuario()
    {
        UsuarioController objusuario = new  UsuarioController();
        
         System.out.println(objusuario.consultar("pepe"));
                
    }
    
    public static void PuebaRegistrar()
    {
        UsuarioController objusuario = new  UsuarioController();
        
         System.out.println(objusuario.registrar("james23", "123","Franlin romo ","franklinrfom.cvom"));
        
        
    }
        
    
    public static void PuebaLogin()
    {
        UsuarioController objusuario = new  UsuarioController();
        
         System.out.println(objusuario.login("admin", "admin"));
        
        
    }
    
    
    
    public static void PruebaUsuario (){
        DBConnection con = new DBConnection();
        String sql = "SELECT * FROM  usuarios ";
        try{
            Statement st = con.getConnection().createStatement();            
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()){
                String pk_usr_login = rs.getString("pk_usr_login");
                String usr_password = rs.getString("usr_password");
                String usr_nombre = rs.getString("usr_nombre");
                String usr_email = rs.getString("usr_email");
                               
                               
                Usuarios objusuario = new Usuarios( pk_usr_login,  usr_password,  usr_nombre,  usr_email);
                
               System.out.println(objusuario.toString());

            }
                
            
           
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        finally{
                con.desconectar();
        }
        
    }
    
}
