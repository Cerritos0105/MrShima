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
                        //System.out.println( "Error al modificar la tegedora: " + e.getMessage());
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
                        //System.out.println( "Error al vender la tegedora: " + e.getMessage());
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

                        //System.out.println( "Error al vender la tegedora: " + e.getMessage());
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
            //System.out.println("Error al vender la tejedora: " + e.getMessage());
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
                        //System.out.println( "Error al Regresar la tegedora: " + e.getMessage());
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
            //System.out.println("Error al modificar: " + e.getMessage());
        }
    }


    public void Agregrar_Abono_A(int ID, double cantidad) {
        double precio = 0; 
        try (Connection conn = conexion.getConnection()) {

            // Obtener precio
            String consultaSelect = "SELECT credito FROM inventario_A WHERE ID = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(consultaSelect)) {
                pstmt.setInt(1, ID);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    precio = rs.getDouble("credito");
                }
            }
            //System.out.println(ID);
            precio-=cantidad;
            String consultaUpdate = "UPDATE inventario_A SET credito = ? WHERE ID = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(consultaUpdate)) {
                pstmt.setDouble(1, precio); 
                pstmt.setInt(2, ID);
                pstmt.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("Error al vender la tejedora: " + e.getMessage());
        }
    }
    public void Modificar_Bor(int id, String marca, double precio, String area, int cabezas, int colores,
                          double credito, String propietario, String numeroSerie, String accesorios,
                          int anio, double saldo) {
    try (Connection conn = conexion.getConnection()) {
        String sql = "UPDATE bordadora SET marca = ?, precio = ?, area = ?, cabezas = ?, colores = ?, credito = ?, propietario = ?, numero_serie = ?, accesorios = ?, anio = ?, saldo = ? WHERE ID = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, marca);
            pstmt.setDouble(2, precio);
            pstmt.setString(3, area);
            pstmt.setInt(4, cabezas);
            pstmt.setInt(5, colores);
            pstmt.setDouble(6, credito);
            pstmt.setString(7, propietario);
            pstmt.setString(8, numeroSerie);
            pstmt.setString(9, accesorios);
            pstmt.setInt(10, anio);
            pstmt.setDouble(11, saldo);
            pstmt.setInt(12, id); // 🔁 Aquí va el ID en el WHERE
            pstmt.executeUpdate();
            //System.out.println("✅ Bordadora modificada con éxito.");
        }
    } catch (Exception e) {
        e.printStackTrace();
        //System.out.println("❌ Error al modificar la bordadora: " + e.getMessage());
    }
}
    
    
    public void Agregrar_Abono_B(int ID, double cantidad) {
        double precio = 0;
        try (Connection conn = conexion.getConnection()) {

            // Obtener precio
            String consultaSelect = "SELECT credito FROM bordadora WHERE ID = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(consultaSelect)) {
                pstmt.setInt(1, ID);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    precio = rs.getDouble("credito");
                }
            }
            System.out.println(precio);
            precio-=cantidad;
            String consultaUpdate = "UPDATE bordadora SET credito = ? WHERE ID = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(consultaUpdate)) {
                pstmt.setDouble(1, precio); 
                pstmt.setInt(2, ID);
                pstmt.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("Error al vender la bordadora: " + e.getMessage());
        }
    }
    public void RegresarB(int ID){
         try (Connection conn = conexion.getConnection()) {
                   String consulta = "update bordadora set estado = true where ID = ?;";
                   try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                       pstmt.setInt(1, ID);  
                       pstmt.executeUpdate();
                       //System.out.println("Usuario Registrado");
                   }
               } catch (Exception e) {
                   e.printStackTrace(); 
                        //System.out.println( "Error al Regresar la bordadora: " + e.getMessage());
               }
     }
    public void Modificar_B(String ID,String etiqueta, int cantidad, double precio, double credito, String desc,
                             String Maquinas, int galga_men, int galga_may, int nivel,
                             String unidad) {
        try (Connection conn = conexion.getConnection()) {
            String consulta = "update  invetario_b set etiqueta=?, cantidad=?, precio=?, credito=?, descripcion=?, maquinas=?, galga_men=?, galga_mayor=?, nivel=?, unidad=? where ID = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                pstmt.setString(1, etiqueta);
                pstmt.setInt(2, cantidad);
                pstmt.setDouble(3, precio);
                pstmt.setDouble(4, credito);
                pstmt.setString(5, desc);
                pstmt.setString(6, Maquinas);
                pstmt.setInt(7, galga_men);
                pstmt.setInt(8, galga_may);
                pstmt.setInt(9, nivel);
                pstmt.setString(10, unidad);
                pstmt.setString(11, ID);
                pstmt.executeUpdate();
                System.out.println("Registro actualizado correctamente.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("Error al modificar: " + e.getMessage());
        }
    }
    public void Agregrar_Abono_R(int ID, double cantidad) {
        double precio = 0; 
        try (Connection conn = conexion.getConnection()) {

            // Obtener precio
            String consultaSelect = "SELECT credito FROM invetario_b WHERE ID = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(consultaSelect)) {
                pstmt.setInt(1, ID);
                ResultSet rs = pstmt.executeQuery();

                if (rs.next()) {
                    precio = rs.getDouble("credito");
                }
            }
            //System.out.println(ID);
            precio-=cantidad;
            String consultaUpdate = "UPDATE invetario_b SET credito = ? WHERE ID = ?;";
            try (PreparedStatement pstmt = conn.prepareStatement(consultaUpdate)) {
                pstmt.setDouble(1, precio); 
                pstmt.setInt(2, ID);
                pstmt.executeUpdate();
            }

        } catch (Exception e) {
            e.printStackTrace();
            //System.out.println("Error al vender la tejedora: " + e.getMessage());
        }
    }
}