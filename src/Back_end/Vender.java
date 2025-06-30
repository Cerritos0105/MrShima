package Back_end;

import Api.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Vender {
    private Conexion conexion;
     public Vender(){
         this.conexion= new Conexion();
     }
     public void VenderTD(int ID, String p){
         try (Connection conn = conexion.getConnection()) {
                   String consulta = "update tejedora set  estado = false, propietario = ? where ID = ?;";
                   try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                       pstmt.setString(1, p);
                       pstmt.setInt(2, ID);  
                       pstmt.executeUpdate();
                       //System.out.println("Usuario Registrado");
                   }
               } catch (Exception e) {
                   e.printStackTrace(); 
                        System.out.println( "Error al vender la tegedora: " + e.getMessage());
               }
     }
     public void VenderT(int ID, String p){
         try (Connection conn = conexion.getConnection()) {
                   String consulta = "update tejedora set credito=0, estado = false, propietario = ? where ID = ?;";
                   try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                       pstmt.setString(1, p);
                       pstmt.setInt(2, ID);  
                       pstmt.executeUpdate();
                       //System.out.println("Usuario Registrado");
                   }
               } catch (Exception e) {
                   e.printStackTrace(); 
                        System.out.println( "Error al vender la tegedora: " + e.getMessage());
               }
     }
     public void VenderA(int ID,int cantidad, double precio){
         try (Connection conn = conexion.getConnection()) {
                   String consulta = "INSERT INTO inventario_A (nombre, precio, credito, Maquinas, galga_men, galga_mayor, nivel, cantida, estado, tamano)\n" +
                                    "SELECT nombre, ?, 0, Maquinas, galga_men, galga_mayor, nivel, ? , false, tamano\n" +
                                    "FROM inventario_A\n" +
                                    "WHERE ID = ?;";
                   try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                       pstmt.setDouble(1, precio*cantidad);
                       pstmt.setInt(2, cantidad);
                       pstmt.setInt(3, ID);  
                       pstmt.executeUpdate();
                       //System.out.println("Usuario Registrado");
                   }
               } catch (Exception e) {
                   e.printStackTrace(); 
                        System.out.println( "Error al vender la tegedora: " + e.getMessage());
               }
         try (Connection conn = conexion.getConnection()) {
                   String consulta = "UPDATE inventario_A SET cantida = cantida - ? WHERE ID = ?;";
                   try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                       pstmt.setInt(1, cantidad);
                       pstmt.setInt(2, ID);  
                       pstmt.executeUpdate();
                       //System.out.println("Usuario Registrado");
                   }
               } catch (Exception e) {
                   e.printStackTrace(); 
                        System.out.println( "Error al vender la tegedora: " + e.getMessage());
               }
     }
}
