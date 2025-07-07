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
                        //System.out.println( "Error al vender la tegedora: " + e.getMessage());
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
                        //System.out.println( "Error al vender la tegedora: " + e.getMessage());
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
                        //System.out.println( "Error al vender la tegedora: " + e.getMessage());
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
                        //System.out.println( "Error al vender la tegedora: " + e.getMessage());
               }
     }
     public void VenderAD(int ID,int cantidad, double precio){
         try (Connection conn = conexion.getConnection()) {
                   String consulta = "INSERT INTO inventario_A (nombre, precio, credito, Maquinas, galga_men, galga_mayor, nivel, cantida, estado, tamano)\n" +
                                    "SELECT nombre, 0, ?, Maquinas, galga_men, galga_mayor, nivel, ? , false, tamano\n" +
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
                        //System.out.println( "Error al vender la tegedora: " + e.getMessage());
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
                        //System.out.println( "Error al vender la tegedora: " + e.getMessage());
               }
     }

    
     
    // Parte de vender de Boradora no te revuelvas o eres my nub att Jorgito
     // Vender con crédito conservado
    public void VenderBD(int ID, String propietario) {
        try (Connection conn = conexion.getConnection()) {
            String consulta = "UPDATE bordadora SET estado = false, propietario = ? WHERE ID = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                pstmt.setString(1, propietario);
                pstmt.setInt(2, ID);
                pstmt.executeUpdate();
                //System.out.println("✅ Bordadora vendida (con crédito intacto).");
            }
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("❌ Error al vender la bordadora: " + e.getMessage());
        }
    }

    // Vender y borrar el crédito (contado)
    public void VenderB(int ID, String propietario) {
        try (Connection conn = conexion.getConnection()) {
            String consulta = "UPDATE bordadora SET credito = 0, estado = false, propietario = ? WHERE ID = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                pstmt.setString(1, propietario);
                pstmt.setInt(2, ID);
                pstmt.executeUpdate();
                //System.out.println("✅ Bordadora vendida al contado (crédito = 0).");
            }
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("❌ Error al vender la bordadora al contado: " + e.getMessage());
        }
    }
    public void VenderR(int ID, int cantidad, double precio) {
        try (Connection conn = conexion.getConnection()) {
            String consulta = "INSERT INTO invetario_b (etiqueta, cantidad, precio, credito, descripcion, maquinas, galga_men, galga_mayor, nivel, estado, unidad) " +
                              "SELECT etiqueta, ?, ?, 0, descripcion, maquinas, galga_men, galga_mayor, nivel, false, unidad " +
                              "FROM invetario_b " +
                              "WHERE ID = ?;";

            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                pstmt.setInt(1, cantidad);               // Nueva cantidad
                pstmt.setDouble(2, precio * cantidad);   // Nuevo crédito (precio total)
                pstmt.setInt(3, ID);                     // ID que buscas en invetario_b

                pstmt.executeUpdate();
                //System.out.println("Venta registrada correctamente en invetario_b.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("Error al registrar la venta: " + e.getMessage());
        }

        try (Connection conn = conexion.getConnection()) {
            String consulta = "UPDATE invetario_b SET cantidad = cantidad - ? WHERE ID = ?;";

            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                pstmt.setInt(1, cantidad);   // Cantidad vendida
                pstmt.setInt(2, ID);         // ID que vas a actualizar

                pstmt.executeUpdate();
                //System.out.println("Cantidad actualizada correctamente en invetario_b.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("Error al actualizar cantidad: " + e.getMessage());
        }
    }
    public void VenderRD(int ID, int cantidad, double precio) {
        try (Connection conn = conexion.getConnection()) {
            String consulta = "INSERT INTO invetario_b (etiqueta, cantidad, precio, credito, descripcion, maquinas, galga_men, galga_mayor, nivel, estado, unidad) " +
                              "SELECT etiqueta, ?, 0, ?, descripcion, maquinas, galga_men, galga_mayor, nivel, false, unidad " +
                              "FROM invetario_b " +
                              "WHERE ID = ?;";

            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                pstmt.setInt(1, cantidad);               // Nueva cantidad
                pstmt.setDouble(2, precio * cantidad);   // Nuevo crédito (precio total)
                pstmt.setInt(3, ID);                     // ID que buscas en invetario_b

                pstmt.executeUpdate();
                //System.out.println("Venta registrada correctamente en invetario_b.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("Error al registrar la venta: " + e.getMessage());
        }

        try (Connection conn = conexion.getConnection()) {
            String consulta = "UPDATE invetario_b SET cantidad = cantidad - ? WHERE ID = ?;";

            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                pstmt.setInt(1, cantidad);   // Cantidad vendida
                pstmt.setInt(2, ID);         // ID que vas a actualizar

                pstmt.executeUpdate();
                //System.out.println("Cantidad actualizada correctamente en invetario_b.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("Error al actualizar cantidad: " + e.getMessage());
        }
    }

}
