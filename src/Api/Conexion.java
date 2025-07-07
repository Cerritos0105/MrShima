package Api;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexion {
    // URL correcta para la conexión a MySQL
    private static final String URL = "jdbc:mysql://localhost:3306/MrShima";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public Connection getConnection() {
        Connection conn = null;
        try {
            // Establecer conexión a la base de datos
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            //System.out.println("Conectado a la base de datos");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error de Conexion");
        }
        return conn;
    }
}