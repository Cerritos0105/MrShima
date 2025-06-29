package Back_end;
import Api.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Agregar {
    private Conexion conexion;
    public Agregar(){
         this.conexion= new Conexion();
    }
    public void Agrgar_T(String Modelo, String galga, double precio,String serie, String sucursal, boolean estado,String propietario, double Credito, int cabezas, int anio){
        try (Connection conn = conexion.getConnection()) {
            String consulta = "INSERT INTO tejedora (modelo,galga,precio,serie, sucursal,estado,credito,propietario,cabezas, anio) VALUES (?,?,?,?,?,?,?,?,?,?);";
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                pstmt.setString(1, Modelo);
                pstmt.setString(2, galga);
                pstmt.setDouble(3, precio);
                pstmt.setString(4, serie);
                pstmt.setString(5, sucursal);
                pstmt.setBoolean(6, estado);
                pstmt.setDouble(7, Credito);
                pstmt.setString(8, propietario);
                pstmt.setInt(9, cabezas);
                pstmt.setInt(10, anio);
                pstmt.executeUpdate();
                System.out.println("Registrado Correctamente");
            }
        }catch (Exception e) {
            e.printStackTrace(); 
            System.out.println( "Error al registrar la tegedora: " + e.getMessage());
        }
    }
}
