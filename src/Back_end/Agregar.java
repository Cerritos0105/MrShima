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
    public void Agrgar_A(String nombre, double precio, double credito, String maquinas, int galga_men, int galga_may, int nivel , int cantidad, String tamano){
        try (Connection conn = conexion.getConnection()) {
            String consulta = "INSERT INTO inventario_A(nombre,precio, credito , Maquinas,galga_men, galga_mayor, nivel, cantida, estado, tamano) VALUES (?,?,?,?,?,?,?,?,?,?);";
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                pstmt.setString(1, nombre);
                pstmt.setDouble(2, precio);
                pstmt.setDouble(3, credito);
                pstmt.setString(4, maquinas);
                pstmt.setInt(5, galga_men);
                pstmt.setInt(6, galga_may);
                pstmt.setInt(7, nivel);
                pstmt.setInt(8, cantidad);
                pstmt.setBoolean(9, true);
                pstmt.setString(10, tamano);
                pstmt.executeUpdate();
                System.out.println("Registrado Correctamente");
            }
        }catch (Exception e) {
            e.printStackTrace(); 
            System.out.println( "Error al registrar : " + e.getMessage());
        }
    }
    
    public void agregarBordadora(double precio, double credito, String accesorios, int anio, String area,
                             int colores, int cabezas, String marca, String numeroSerie,
                             boolean estado, double saldo, String propietario) {
        try (Connection conn = conexion.getConnection()) {
            String consulta = "INSERT INTO Bordadora (precio, credito, accesorios, anio, area, colores, cabezas, marca, numero_serie, estado, saldo, propietario) " +
                              "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                pstmt.setDouble(1, precio);
                pstmt.setDouble(2, credito);
                pstmt.setString(3, accesorios);
                pstmt.setInt(4, anio);
                pstmt.setString(5, area);
                pstmt.setInt(6, colores);
                pstmt.setInt(7, cabezas);
                pstmt.setString(8, marca);
                pstmt.setString(9, numeroSerie);
                pstmt.setBoolean(10, estado);
                pstmt.setDouble(11, saldo);
                pstmt.setString(12, propietario);
                pstmt.executeUpdate();
                System.out.println("✅ Bordadora registrada correctamente");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Error al registrar la bordadora: " + e.getMessage());
        }
    }
    public void agregarB(String etiqueta, int cantidad, double precio, double credito, String desc,
                             String Maquinas, int galga_men, int galga_may, int nivel,
                             String unidad) {
        try (Connection conn = conexion.getConnection()) {
            String consulta = "INSERT INTO invetario_b (etiqueta, cantidad, precio, credito, descripcion, maquinas, galga_men, galga_mayor, nivel, estado, unidad) " +
                              "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, true, ?)";
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
                
                pstmt.executeUpdate();
                System.out.println("✅ Refaccion registrada correctamente");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("❌ Error al registrar la refaccion: " + e.getMessage());
        }
    }
    
}   
