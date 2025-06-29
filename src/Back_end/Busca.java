package Back_end;

import Api.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import Objetos.*;
public class Busca {
    private Conexion conexion;
     public Busca(){
         this.conexion= new Conexion();
     }
     public List<TegedorasO> TegdoraV(String Modelo, String galga, double precio,String serie, String sucursal,String propietario, double Credito, int cabezas, int anio){
       TegedorasO x=new TegedorasO();
       List<TegedorasO> productos = new ArrayList<>();
        try (Connection conn = conexion.getConnection()) {
            // Consulta SQL
            String consulta = "select * from tejedora";
            int cs = 0;
            if(!Modelo.isEmpty() || !galga.isEmpty() || !"0".equals(String.valueOf(precio)) || !serie.isEmpty() || !sucursal.isEmpty() || propietario.isEmpty() || "0".equals(String.valueOf(Credito)) || "0".equals(String.valueOf(cabezas)) || "0".equals(String.valueOf(anio))){
                consulta += " where";
                if(!Modelo.isEmpty()){
                    cs += 1;
                    if(cs >= 2) consulta += " and";
                    consulta += " modelo like '%" + Modelo + "%'";
                }
                if(!galga.isEmpty()){
                    cs += 1;
                    if(cs >= 2) consulta += " and";
                    consulta += " galga like '%" + galga + "%'";
                }
                if(!"0.0".equals(String.valueOf(precio))){
                    cs += 1;
                    if(cs >= 2) consulta += " and";
                    consulta += " precio <= ?";
                }
                if(!serie.isEmpty()){
                    cs += 1;
                    if(cs >= 2) consulta += " and";
                    consulta += " serie like '%" + serie + "%'";
                }
                if(!sucursal.isEmpty()){
                    cs += 1;
                    if(cs >= 2) consulta += " and";
                    consulta += " sucursal like '%" + sucursal + "%'";
                }
                if(!propietario.isEmpty()){
                    cs += 1;
                    if(cs >= 2) consulta += " and";
                    consulta += " propietario like '%" + propietario + "%'";
                }
                if(!"0.0".equals(String.valueOf(Credito))){
                    cs += 1;
                    if(cs >= 2) consulta += " and";
                    consulta += " credito <= ?";
                }
                if(!"0".equals(String.valueOf(cabezas))){
                    cs += 1;
                    if(cs >= 2) consulta += " and";
                    consulta += " cabezas = ?";
                }
                if(!"0".equals(String.valueOf(anio))){
                    cs += 1;
                    if(cs >= 2) consulta += " and";
                    consulta += " precio = ?";
                }
            }
            consulta += " and estado = true;";
            System.out.println(consulta);
            System.out.println(precio);
            //System.out.println(consulta);
            Statement stmn = conn.createStatement();
            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                cs = 0;
                if(!"0.0".equals(String.valueOf(precio))){
                    cs += 1;
                    pstmt.setDouble(cs, precio);
                }
                if(!"0.0".equals(String.valueOf(Credito))){
                    cs += 1;
                    pstmt.setDouble(cs, Credito);
                }
                if(!"0".equals(String.valueOf(cabezas))){
                    cs += 1;
                    pstmt.setInt(cs, cabezas);
                }
                if(!"0".equals(String.valueOf(anio))){
                    cs += 1;
                    pstmt.setInt(cs, anio);
                }
                    try (ResultSet rs = pstmt.executeQuery()) {
                         while (rs.next()) {
                            Modelo = rs.getString("modelo");
                            galga = rs.getString("galga");
                            precio = rs.getDouble("precio");
                            serie = rs.getString("serie");
                            sucursal = rs.getString("sucursal");
                            Credito = rs.getDouble("credito");
                            propietario = rs.getString("propietario");
                            cabezas = rs.getInt("cabezas");
                            anio = rs.getInt("anio");
                

                            TegedorasO producto = new TegedorasO(0, Modelo,galga, precio, serie, sucursal, Credito, propietario, cabezas, anio);
                            productos.add(producto);
                         }
                     } 

                } 
            
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al buscar productos: " + e.getMessage());
        }

        if(productos.isEmpty()) JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
        return productos;
    }
     
    public List<InventarioA> busca_A(){
        List<InventarioA> T = new ArrayList<>();
         try (Connection conn = conexion.getConnection()) {
            // Consulta SQL
            String consulta = "select * from Inventario_A where estado= true;";
            Statement stmn = conn.createStatement();
            ResultSet rs = stmn.executeQuery(consulta);

            while (rs.next()) {
                int id = rs.getInt("ID");
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                double credito = rs.getDouble("credito");
                String maquinas = rs.getString("Maquinas");
                int galga_men = rs.getInt("galga_men");
                int galga_may = rs.getInt("galga_mayor");
                int nivel = rs.getInt("nivel");
                int cabezas = rs.getInt("cantida");
                String tamano = rs.getString("tamano");
                

                InventarioA producto = new InventarioA(id,nombre, precio, credito, maquinas, galga_men, galga_may, nivel, cabezas, tamano);
                T.add(producto);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al buscar Tgedoras: " + e.getMessage());
        }
        return T;
    }
}
