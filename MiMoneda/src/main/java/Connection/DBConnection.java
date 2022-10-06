/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author DirectorTic
 */
public class DBConnection {
            
    Connection connection;
    static String bd = "railway";
    static String port = "6434";
    static String login = "root";
    static String password = "bINOMgM2un5Do7UnksiP";

    public DBConnection() {        
        try {     
                        
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url="jdbc:mysql://containers-us-west-17.railway.app:" + this.port + "/" + this.bd;
            connection = DriverManager.getConnection(url,this.login,this.password);
            System.out.println("conexion establecida");            
        }
        catch (Exception ex)
        {
            System.out.println("Error en la conexion"); 
        }
    }
    
     public Connection getConnection(){
        return connection ;
    }   
    
    
     public void desconectar(){
        connection = null;
    }
}
