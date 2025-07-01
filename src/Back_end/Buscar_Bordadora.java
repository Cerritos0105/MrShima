/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Back_end;
import  Api.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Objetos.BordadoraO;
/**
 *
 * @author Think
 */
public class Buscar_Bordadora {
    private Conexion conexion;

    public Buscar_Bordadora() {
        this.conexion = new Conexion();
    }

    public List<BordadoraO> buscarActivas() {
        List<BordadoraO> lista = new ArrayList<>();
        try (Connection conn = conexion.getConnection()) {
            String consulta = "SELECT * FROM bordadora WHERE estado = true;";
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery(consulta);

            while (rs.next()) {
                BordadoraO b = new BordadoraO(
                    rs.getInt("ID"),
                    rs.getDouble("precio"),
                    rs.getDouble("credito"),
                    rs.getString("accesorios"),
                    rs.getInt("anio"),
                    rs.getString("area"),
                    rs.getInt("colores"),
                    rs.getInt("cabezas"),
                    rs.getString("marca"),
                    rs.getString("numero_serie"),
                    rs.getBoolean("estado"),
                    rs.getDouble("saldo"),
                    rs.getString("propietario")
                );
                lista.add(b);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al buscar bordadoras: " + e.getMessage());
        }
        return lista;
    }
}

