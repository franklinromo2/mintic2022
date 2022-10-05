/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import java.sql.Date;

/**
 *
 * @author DirectorTic
 */
public class PlanesUsuarios {

    private int pk_piu_codigo_planusuario;
    private int fk_piu_codigo_inversion;
    private String fk_piu_login;
    private Date piu_fecha;
    private float piu_valor;

    public int getPk_piu_codigo_planusuario() {
        return pk_piu_codigo_planusuario;
    }

    public void setPk_piu_codigo_planusuario(int pk_piu_codigo_planusuario) {
        this.pk_piu_codigo_planusuario = pk_piu_codigo_planusuario;
    }

    public int getFk_piu_codigo_inversion() {
        return fk_piu_codigo_inversion;
    }

    public void setFk_piu_codigo_inversion(int fk_piu_codigo_inversion) {
        this.fk_piu_codigo_inversion = fk_piu_codigo_inversion;
    }

    public String getFk_piu_login() {
        return fk_piu_login;
    }

    public void setFk_piu_login(String fk_piu_login) {
        this.fk_piu_login = fk_piu_login;
    }

    public Date getPiu_fecha() {
        return piu_fecha;
    }

    public void setPiu_fecha(Date piu_fecha) {
        this.piu_fecha = piu_fecha;
    }

    public float getPiu_valor() {
        return piu_valor;
    }

    public void setPiu_valor(float piu_valor) {
        this.piu_valor = piu_valor;
    }

    public PlanesUsuarios(int pk_piu_codigo_planusuario, int fk_piu_codigo_inversion, String fk_piu_login, Date piu_fecha, float piu_valor) {
        this.pk_piu_codigo_planusuario = pk_piu_codigo_planusuario;
        this.fk_piu_codigo_inversion = fk_piu_codigo_inversion;
        this.fk_piu_login = fk_piu_login;
        this.piu_fecha = piu_fecha;
        this.piu_valor = piu_valor;
    }
}
