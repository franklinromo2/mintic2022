/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Beans.PlanesInversion;
import Connection.DBConnection;
import com.google.gson.Gson;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author DirectorTic
 */
public class PlanesInversionController implements IPlanesInversionController {

    @Override
    public String consultar() {
        Gson gson = new Gson();

        DBConnection con = new DBConnection();

        String sql = "Select * from planes_inversion";

        List<String> listPlanesUsuarios = new ArrayList<String>();

        try {
            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                int pk_pln_codigo = rs.getInt("pk_pln_codigo");
                String pln_nombre = rs.getString("pln_nombre");
                String pln_porcentaje = rs.getString("pln_porcentaje");
                String pln_periodicidad = rs.getString("pln_periodicidad");

                PlanesInversion objplanes = new PlanesInversion(pk_pln_codigo, pln_nombre, pln_porcentaje, pln_periodicidad);

                listPlanesUsuarios.add(gson.toJson(objplanes));

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return gson.toJson(listPlanesUsuarios);
    }
}
