package Back_end;

import Api.Conexion;
import java.sql.PreparedStatement;

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
}
