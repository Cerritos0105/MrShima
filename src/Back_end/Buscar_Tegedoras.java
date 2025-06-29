package Back_end;
import  Api.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import Objetos.TegedorasO;
public class Buscar_Tegedoras {
    private Conexion conexion;
    public Buscar_Tegedoras(){
         this.conexion= new Conexion();
    }
    //Se seleccionan todos los ususarios y sus columnas, y de todas la colummnas solo se selecionan 4 que son las que se muestran en el panel 
    public List<TegedorasO> busca_V(){
        List<TegedorasO> T = new ArrayList<>();
         try (Connection conn = conexion.getConnection()) {
            // Consulta SQL
            String consulta = "select * from tejedora where estado= true;";
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery(consulta);

            while (rs.next()) {
                int id = rs.getInt("ID");
                String modelo = rs.getString("modelo");
                String galga = rs.getString("galga");
                double precio = rs.getDouble("precio");
                String serie = rs.getString("serie");
                String sucursal = rs.getString("sucursal");
                double credito = rs.getDouble("credito");
                String propietario = rs.getString("propietario");
                int cabezas = rs.getInt("cabezas");
                int anio = rs.getInt("anio");
                

                TegedorasO producto = new TegedorasO(id, modelo,galga, precio, serie, sucursal, credito, propietario, cabezas, anio);
                T.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al buscar Tgedoras: " + e.getMessage());
        }
        return T;
    }
    public List<TegedorasO> busca_D(){
        List<TegedorasO> T = new ArrayList<>();
         try (Connection conn = conexion.getConnection()) {
            // Consulta SQL
            String consulta = "select * from tejedora where estado = false and credito !=0;";
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery(consulta);

            while (rs.next()) {
                int id = rs.getInt("ID");
                String modelo = rs.getString("modelo");
                String galga = rs.getString("galga");
                double precio = rs.getDouble("precio");
                String serie = rs.getString("serie");
                String sucursal = rs.getString("sucursal");
                double credito = rs.getDouble("credito");
                String propietario = rs.getString("propietario");
                int cabezas = rs.getInt("cabezas");
                int anio = rs.getInt("anio");
                

                TegedorasO producto = new TegedorasO(id, modelo,galga, precio, serie, sucursal, credito, propietario, cabezas, anio);
                T.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al buscar Usuarios: " + e.getMessage());
        }
        return T;
    }
}
