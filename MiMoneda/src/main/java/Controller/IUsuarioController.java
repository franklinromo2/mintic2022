/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Controller;

/**
 *
 * @author DirectorTic
 */
public interface IUsuarioController {
    
        public String login(String pk_usr_login, String usr_password);

        public String registrar(String pk_usr_login, String usr_password, String usr_nombre, String usr_email);

        public String consultar(String pk_usr_login);

        public String actualizar(String pk_usr_login, String usr_password, String usr_nombre, String usr_email);

        public String eliminar(String pk_usr_login);
        
}
