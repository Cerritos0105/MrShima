package Back_end;

import  Api.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Objetos.BordadoraO;


public class Buscar_Bordadora{
    private Conexion conexion;

    public Buscar_Bordadora() {
        this.conexion = new Conexion();
    }

    // Bordadoras disponibles para venta (estado = true)
    public List<BordadoraO> busca_V() {
        List<BordadoraO> lista = new ArrayList<>();
        try (Connection conn = conexion.getConnection()) {
            String consulta = "SELECT * FROM bordadora WHERE estado = true;";
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery(consulta);

            while (rs.next()) {
                BordadoraO bordadora = new BordadoraO(
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
                lista.add(bordadora);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Error al buscar bordadoras disponibles: " + e.getMessage());
        }
        return lista;
    }

    // Bordadoras vendidas a crédito (estado = false y crédito > 0)
    public List<BordadoraO> busca_D() {
        List<BordadoraO> lista = new ArrayList<>();
        try (Connection conn = conexion.getConnection()) {
            String consulta = "SELECT * FROM bordadora WHERE estado = false AND credito > 0;";
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery(consulta);

            while (rs.next()) {
                BordadoraO bordadora = new BordadoraO(
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
                lista.add(bordadora);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Error al buscar bordadoras a crédito: " + e.getMessage());
        }
        return lista;
    }
}