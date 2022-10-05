/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

/**
 *
 * @author DirectorTic
 */
public class PlanesInversion {

    private int pk_pln_codigo;
    private String pln_nombre;
    private String pln_porcentaje;
    private String pln_periodicidad;

    public PlanesInversion(int pk_pln_codigo, String pln_nombre, String pln_porcentaje, String pln_periodicidad) {
        this.pk_pln_codigo = pk_pln_codigo;
        this.pln_nombre = pln_nombre;
        this.pln_porcentaje = pln_porcentaje;
        this.pln_periodicidad = pln_periodicidad;
    }

 

    public int getPk_pln_codigo() {
        return pk_pln_codigo;
    }

    public void setPk_pln_codigo(int pk_pln_codigo) {
        this.pk_pln_codigo = pk_pln_codigo;
    }

    public String getPln_nombre() {
        return pln_nombre;
    }

    public void setPln_nombre(String pln_nombre) {
        this.pln_nombre = pln_nombre;
    }

    public String getPln_porcentaje() {
        return pln_porcentaje;
    }

    public void setPln_porcentaje(String pln_porcentaje) {
        this.pln_porcentaje = pln_porcentaje;
    }

    public String getPln_periodicidad() {
        return pln_periodicidad;
    }

    @Override
    public String toString() {
        return "PlanesInversion{" + "pk_pln_codigo=" + pk_pln_codigo + ", pln_nombre=" + pln_nombre + ", pln_porcentaje=" + pln_porcentaje + ", pln_periodicidad=" + pln_periodicidad + '}';
    }

    public void setPln_periodicidad(String pln_periodicidad) {
        this.pln_periodicidad = pln_periodicidad;
    }
    

}
