package Back_end;

import Api.Conexion;
import Objetos.BordadoraO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Buscar_Bordadora {

    private Conexion conexion;

    public Buscar_Bordadora() {
        this.conexion = new Conexion();
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
