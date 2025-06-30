package Back_end;
import Api.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
public class Modificar {
    private Conexion conexion;
    public Modificar(){
         this.conexion= new Conexion();
    }
     public void Modificar(int ID, String Modelo, String galga, double precio,String serie, String sucursal,String propietario, double Credito, int cabezas, int anio){
         try (Connection conn = conexion.getConnection()) {
                   String consulta = "update tejedora set modelo = ?, galga = ?, precio = ? , serie = ?, sucursal = ?, propietario = ?, credito =?, cabezas = ?, anio = ? where ID = ?;";
                   try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                       pstmt.setString(1, Modelo);
                       pstmt.setString(2, galga);
                       pstmt.setDouble(3, precio);
                       pstmt.setString(4, serie);
                       pstmt.setString(5, sucursal);
                       pstmt.setString(6, propietario);
                       pstmt.setDouble(7, Credito);
                       pstmt.setInt(8, cabezas);
                       pstmt.setInt(9, anio);
                       pstmt.setInt(10, ID);  
                       pstmt.executeUpdate();
                       //System.out.println("Usuario Registrado");
                   }
               } catch (Exception e) {
                   e.printStackTrace(); 
                        System.out.println( "Error al modificar la tegedora: " + e.getMessage());
               }
     }
     public void Vender(int ID){
         try (Connection conn = conexion.getConnection()) {
                   String consulta = "update tejedora set credito = 0,  estado = false where ID = ?;";
                   try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                       pstmt.setInt(1, ID);  
                       pstmt.executeUpdate();
                       //System.out.println("Usuario Registrado");
                   }
               } catch (Exception e) {
                   e.printStackTrace(); 
                        System.out.println( "Error al vender la tegedora: " + e.getMessage());
               }
     }
     public void VenderD(int ID){
         try (Connection conn = conexion.getConnection()) {
                   String consulta = "update tejedora set  estado = false where ID = ?;";
                   try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                       pstmt.setInt(1, ID);  
                       pstmt.executeUpdate();
                       //System.out.println("Usuario Registrado");
                   }
               } catch (Exception e) {
                   e.printStackTrace(); 
                        System.out.println( "Error al vender la tejedora: " + e.getMessage());
               }
     }
     public void Agregrar_Abono_T(int ID, double cantidad) {
        double precio = 0;
        try (Connection conn = conexion.getConnection()) {

            // Obtener precio
            String consultaSelect = "SELECT credito FROM tejedora WHERE ID = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(consultaSelect)) {
                pstmt.setInt(1, ID);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    precio = rs.getDouble("credito");
                }
            }
            System.out.println(precio);
            precio-=cantidad;
            String consultaUpdate = "UPDATE tejedora SET credito = ? WHERE ID = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(consultaUpdate)) {
                pstmt.setDouble(1, precio); 
                pstmt.setInt(2, ID);
                pstmt.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al vender la tejedora: " + e.getMessage());
        }
    }
    public void Regresar(int ID){
         try (Connection conn = conexion.getConnection()) {
                   String consulta = "update tejedora set estado = true where ID = ?;";
                   try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                       pstmt.setInt(1, ID);  
                       pstmt.executeUpdate();
                       //System.out.println("Usuario Registrado");
                   }
               } catch (Exception e) {
                   e.printStackTrace(); 
                        System.out.println( "Error al Regresar la tegedora: " + e.getMessage());
               }
     }
    public void Modificar_A(int ID, String nombre, double precio, double credito, String Maquinas, int galga_men, int galga_may, int nivel, int cantidad, String tamano) {
        try (Connection conn = conexion.getConnection()) {
            String consulta = "UPDATE inventario_A SET nombre = ?, precio = ?, credito = ?, Maquinas = ?, galga_men = ?, galga_mayor = ?, nivel = ?, cantida = ?, tamano = ? WHERE ID = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                pstmt.setString(1, nombre);
                pstmt.setDouble(2, precio);
                pstmt.setDouble(3, credito);
                pstmt.setString(4, Maquinas);
                pstmt.setInt(5, galga_men);
                pstmt.setInt(6, galga_may);
                pstmt.setInt(7, nivel);
                pstmt.setInt(8, cantidad);
                pstmt.setString(9, tamano);
                pstmt.setInt(10, ID);
                pstmt.executeUpdate();
                System.out.println("Registro actualizado correctamente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al modificar: " + e.getMessage());
        }
    }
}
