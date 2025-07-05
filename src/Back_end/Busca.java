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
    public InventarioA busca_A_ID(int ID){
        InventarioA producto= new InventarioA();
         try (Connection conn = conexion.getConnection()) {
            
            String consulta = "select * from Inventario_A where estado= true and ID = ?;";
             try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                pstmt.setInt(1,ID);
                Statement stmn = conn.createStatement();
                ResultSet rs = pstmt.executeQuery();

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


                    producto = new InventarioA(id,nombre, precio, credito, maquinas, galga_men, galga_may, nivel, cabezas, tamano);
            }
        }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al buscar Aguja: " + e.getMessage());
        }
        return producto;
    }
    public List<InventarioA> buscarInventarioA(String nomabre, double precio, double credito, String maquias, int galta_men, int gaslga_may, int nivel, int cantidad, String tamano) {
        List<InventarioA> productos = new ArrayList<>();

        try (Connection conn = conexion.getConnection()) {
            String consulta = "SELECT * FROM inventario_A WHERE estado = true and";
            int cs = 0;

            // Construcción dinámica de la consulta
            if (!nomabre.isEmpty()) {
                cs += 1;
                if(cs >= 2) consulta += " and";
                consulta += " nombre LIKE '%" + nomabre + "%'";
            }
            if (precio > 0) {
                cs += 1;
                if(cs >= 2) consulta += " and";
                consulta += " precio <= ?";
            }
            if (credito > 0) {
                cs += 1;
                if(cs >= 2) consulta += " and";
                consulta += " credito <= ?";
            }
            if (!maquias.isEmpty()) {
                cs += 1;
                if(cs >= 2) consulta += " and";
                consulta += "Maquinas LIKE '%" + maquias + "%'";
            }
            if (galta_men > 0) {
                cs += 1;
                if(cs >= 2) consulta += " and";
                consulta += " galga_men = ?";
            }
            if (gaslga_may > 0) {
                cs += 1;
                if(cs >= 2) consulta += " and";
                consulta += " galga_mayor = ?";
            }
            if (nivel > 0) {
                cs += 1;
                if(cs >= 2) consulta += " and";
                consulta += " nivel = ?";
            }
            if (cantidad > 0) {
                cs += 1;
                if(cs >= 2) consulta += " and";
                consulta += " cantida = ?";
            }
            if (!tamano.isEmpty()) {
                cs += 1;
                if(cs >= 2) consulta += " and";
                consulta += " tamano LIKE '%" + tamano + "%'";
            }
            consulta +=";";
            System.out.println(consulta);

            try (PreparedStatement pstmt = conn.prepareStatement(consulta)) {
                int index = 1;

               
                if (precio > 0) {
                    pstmt.setDouble(index++, precio);
                }
                if (credito > 0) {
                    pstmt.setDouble(index++, credito);
                }
                if (galta_men > 0) {
                    pstmt.setInt(index++, galta_men);
                }
                if (gaslga_may > 0) {
                    pstmt.setInt(index++, gaslga_may);
                }
                if (nivel > 0) {
                    pstmt.setInt(index++, nivel);
                }
                if (cantidad > 0) {
                    pstmt.setInt(index++, cantidad);
                }
                
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        InventarioA producto = new InventarioA(
                            rs.getInt("ID"),
                            rs.getString("nombre"),
                            rs.getDouble("precio"),
                            rs.getDouble("credito"),
                            rs.getString("Maquinas"),
                            rs.getInt("galga_men"),
                            rs.getInt("galga_mayor"),
                            rs.getInt("nivel"),
                            rs.getInt("cantida"),
                            rs.getString("tamano")
                        );
                        productos.add(producto);
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al buscar productos: " + e.getMessage());
        }
        
        

        if (productos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
        }

        return productos;
    }
    
    
    // Busca sin filtros (activas)
    public List<BordadoraO> buscarActivas() {
        return buscarBordadoras(null, null, null, null, null, null, null, null, null, null, null, true);
    }

    // Búsqueda con filtros opcionales
    public List<BordadoraO> buscarBordadoras(
        String marca,        Double precio,    String area,
        Integer cabezas,     Integer colores,  Double credito,
        String propietario,  String numeroSerie, String accesorios,
        Integer anio,        Double saldo,     Boolean estado
    ) {
        StringBuilder sql = new StringBuilder("SELECT * FROM bordadora WHERE 1=1");
        List<Object> params = new ArrayList<>();

        if (marca != null && !marca.isBlank()) {
            sql.append(" AND marca LIKE ?");
            params.add("%" + marca + "%");
        }
        if (precio != null) {
            sql.append(" AND precio = ?");
            params.add(precio);
        }
        if (area != null && !area.isBlank()) {
            sql.append(" AND area LIKE ?");
            params.add("%" + area + "%");
        }
        if (cabezas != null) {
            sql.append(" AND cabezas = ?");
            params.add(cabezas);
        }
        if (colores != null) {
            sql.append(" AND colores = ?");
            params.add(colores);
        }
        if (credito != null) {
            sql.append(" AND credito = ?");
            params.add(credito);
        }
        if (propietario != null && !propietario.isBlank()) {
            sql.append(" AND propietario LIKE ?");
            params.add("%" + propietario + "%");
        }
        if (numeroSerie != null && !numeroSerie.isBlank()) {
            sql.append(" AND numero_serie LIKE ?");
            params.add("%" + numeroSerie + "%");
        }
        if (accesorios != null && !accesorios.isBlank()) {
            sql.append(" AND accesorios LIKE ?");
            params.add("%" + accesorios + "%");
        }
        if (anio != null) {
            sql.append(" AND anio = ?");
            params.add(anio);
        }
        if (saldo != null) {
            sql.append(" AND saldo = ?");
            params.add(saldo);
        }
        if (estado != null) {
            sql.append(" AND estado = ?");
            params.add(estado);
        }

        List<BordadoraO> lista = new ArrayList<>();

        try (Connection conn = conexion.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql.toString())) {

            for (int i = 0; i < params.size(); i++) {
                ps.setObject(i + 1, params.get(i));
            }

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BordadoraO b = new BordadoraO(
                    rs.getInt("ID"),
                    rs.getDouble("precio"),
                    rs.getDouble("credito"),
                    rs.getString("accesorios"),
                    rs.getInt("anio"),
                    rs.getString("area"),
                    rs.getInt("colores"),
                    rs.getInt("cabezas"),
                    rs.getString("marca"),
                    rs.getString("numero_serie"),
                    rs.getBoolean("estado"),
                    rs.getDouble("saldo"),
                    rs.getString("propietario")
                );
                lista.add(b);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error al buscar bordadoras: " + e.getMessage());
        }

        return lista;
    }


}
