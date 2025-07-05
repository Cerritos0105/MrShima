package Back_end;

import Api.Conexion;
import Objetos.BordadoraO;
import Objetos.TegedorasO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class ObtenerD {
    private Conexion conexion;
    public ObtenerD(){
         this.conexion= new Conexion();
    }
    public TegedorasO obtenerT(String id){
        TegedorasO x=new TegedorasO();
        try (Connection conn = conexion.getConnection()) {
            // Consulta SQL
            String consulta = "select * from tejedora where ID = ?;";
            
            Statement stmn = conn.createStatement();
           try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                       pstmt.setString(1,id);
                       try (ResultSet rs = pstmt.executeQuery()) {
                                if (rs.next()) {
                                 int id2 = rs.getInt("ID");
                                 String modelo = rs.getString("modelo");
                                 String galga = rs.getString("galga");
                                 double precio = rs.getDouble("precio");
                                 String serie = rs.getString("serie");
                                 String sucursal = rs.getString("sucursal");
                                 double credito = rs.getDouble("credito");
                                 String propietario = rs.getString("propietario");
                                 int cabezas = rs.getInt("cabezas");
                                 int anio = rs.getInt("anio");
                                 x = new TegedorasO(id2, modelo,galga, precio, serie, sucursal, credito, propietario, cabezas, anio);
                            }
                        } 
                       
                   } 
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al buscar Tegedora: " + e.getMessage());
        }
        return x;
    }
    
    public BordadoraO obtenerB(String id) {
    BordadoraO b = null;
    try (Connection conn = conexion.getConnection()) {
        String sql = "SELECT * FROM bordadora WHERE ID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                
                int ID = rs.getInt("ID");
                double precio = rs.getDouble("precio");
                double credito = rs.getDouble("credito");
                String accesorios = rs.getString("accesorios");
                int anio = rs.getInt("anio");
                String area = rs.getString("area");
                int colores = rs.getInt("colores");
                int cabezas = rs.getInt("cabezas");
                String marca = rs.getString("marca");
                String numeroSerie = rs.getString("numero_serie"); // ✅ CAMBIADO
                boolean estado = rs.getBoolean("estado");
                double saldo = rs.getDouble("saldo");
                String propietario = rs.getString("propietario");

                b = new BordadoraO(ID, precio, credito, accesorios, anio, area, colores, cabezas, marca, numeroSerie, estado, saldo, propietario);
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("❌ Error al obtener la bordadora: " + e.getMessage());
    }
    return b;
}



}
