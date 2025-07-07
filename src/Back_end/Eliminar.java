package Back_end;

import Api.Conexion;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Eliminar {
    private Conexion conexion;
    public Eliminar(){
         this.conexion= new Conexion();
    }
    public void Tegedora(String id){
         String consulta = "delete from Tejedora where ID=?;";
        try (PreparedStatement pstmt = conexion.getConnection().prepareStatement(consulta)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            //System.out.println("YES");
        } catch(Exception e){
            //System.out.println(e);
        }
    }
    public void Inventario_A(String id) throws SQLException{
         String consulta = "delete from Inventario_A where ID=?;";
        try (PreparedStatement pstmt = conexion.getConnection().prepareStatement(consulta)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            //System.out.println("YES");
        } catch(Exception e){
            //System.out.println(e);
        }
    }
    public void Bordadora(String id){
         String consulta = "delete from Bordadora where ID=?;";
        try (PreparedStatement pstmt = conexion.getConnection().prepareStatement(consulta)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            //System.out.println("YES");
        } catch(Exception e){
            //System.out.println(e);
        }
    }
    public void Inventario_b(String id) throws SQLException{
         String consulta = "delete from Invetario_b where ID=?;";
        try (PreparedStatement pstmt = conexion.getConnection().prepareStatement(consulta)) {
            pstmt.setString(1, id);
            pstmt.executeUpdate();
            //System.out.println("YES");
        } catch(Exception e){
            //System.out.println(e);
        }
    }
    private void Inventario_b_v() throws SQLException{
         String consulta = "delete from Invetario_b where estado = false and credito <1;";
        try (PreparedStatement pstmt = conexion.getConnection().prepareStatement(consulta)) {
            //pstmt.setString(1, id);
            pstmt.executeUpdate();
            //System.out.println("YES");
        } catch(Exception e){
            //System.out.println(e);
        }
    }
    private void Inventario_a_v(){
         String consulta = "delete from Inventario_A where estado = false and credito <1 ;";
        try (PreparedStatement pstmt = conexion.getConnection().prepareStatement(consulta)) {
            //pstmt.setString(1, id);
            pstmt.executeUpdate();
            //System.out.println("YES");
        } catch(Exception e){
            //System.out.println(e);
        }
    }
    private void Tejedoras_v(){
         String consulta = "delete from Tejedora where estado = false and credito <1 ;";
        try (PreparedStatement pstmt = conexion.getConnection().prepareStatement(consulta)) {
            //pstmt.setString(1, id);
            pstmt.executeUpdate();
            //System.out.println("YES");
        } catch(Exception e){
            //System.out.println(e);
        }
    }
    private void Bordadoras_v(){
         String consulta = "delete from Bordadora where estado = false and credito <1 ;";
        try (PreparedStatement pstmt = conexion.getConnection().prepareStatement(consulta)) {
            //pstmt.setString(1, id);
            pstmt.executeUpdate();
            //System.out.println("YES");
        } catch(Exception e){
            //System.out.println(e);
        }
    }
    public void vendidos() throws SQLException{
        Inventario_b_v();
        Inventario_a_v();
        Tejedoras_v();
        Bordadoras_v();
    }
}
