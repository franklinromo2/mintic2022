/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

/**
 *
 * @author DirectorTic
 */
public class Usuarios {
    
    private String pk_usr_login;
    private String usr_password;
    private String usr_nombre;
    private String usr_email;

    public Usuarios(String pk_usr_login, String usr_password, String usr_nombre, String usr_email) {
        this.pk_usr_login = pk_usr_login;
        this.usr_password = usr_password;
        this.usr_nombre = usr_nombre;
        this.usr_email = usr_email;
    }

    public String getPk_usr_login() {
        return pk_usr_login;
    }

    public void setPk_usr_login(String pk_usr_login) {
        this.pk_usr_login = pk_usr_login;
    }

    public String getUsr_password() {
        return usr_password;
    }

    public void setUsr_password(String usr_password) {
        this.usr_password = usr_password;
    }

    public String getUsr_nombre() {
        return usr_nombre;
    }

    public void setUsr_nombre(String usr_nombre) {
        this.usr_nombre = usr_nombre;
    }

    public String getUsr_email() {
        return usr_email;
    }

    public void setUsr_email(String usr_email) {
        this.usr_email = usr_email;
    }

    @Override
    public String toString() {
        return "Usuarios{" + "pk_usr_login=" + pk_usr_login + ", usr_password=" + usr_password + ", usr_nombre=" + usr_nombre + ", usr_email=" + usr_email + '}';
    }
    
    
}
