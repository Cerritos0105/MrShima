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
                b = new BordadoraO(
                    rs.getString("marca"),
                    rs.getDouble("precio"),
                    rs.getString("area"),
                    rs.getInt("cabezas"),
                    rs.getInt("colores"),
                    rs.getDouble("credito"),
                    rs.getString("propietario"),
                    rs.getString("numero_serie"),
                    rs.getString("accesorios"),
                    rs.getInt("anio"),
                    rs.getDouble("saldo")
                );
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Error al obtener la bordadora: " + e.getMessage());
    }
    return b;
}


}
