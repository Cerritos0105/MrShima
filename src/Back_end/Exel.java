
package Back_end;

import Api.Conexion;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.io.output.UnsynchronizedByteArrayOutputStream;

/**
 *
 * @author lupit
 */
public class Exel {
    private Conexion conexion;
    public Exel(){
         this.conexion= new Conexion();
    }
     public void exportarTodoExcel() {
        String archivoExcel = "InventarioCompleto.xlsx";

        try (Connection conn = conexion.getConnection()) {

            Workbook workbook = new XSSFWorkbook();

            // Exportar cada tabla a una hoja
            exportarTabla(conn, workbook, "tejedora");
            exportarTabla(conn, workbook, "bordadora");
            exportarTabla(conn, workbook, "inventario_A");
            exportarTabla(conn, workbook, "invetario_b");
            exportarTabla_V(conn, workbook, "tejedora");
            exportarTabla_V(conn, workbook, "bordadora");
            exportarTabla_V(conn, workbook, "inventario_A");
            exportarTabla_V(conn, workbook, "invetario_b");
            exportarTabla_D(conn, workbook, "tejedora");
            exportarTabla_D(conn, workbook, "bordadora");
            exportarTabla_D(conn, workbook, "inventario_A");
            exportarTabla_D(conn, workbook, "invetario_b");

            // Guardar el archivo
            try (FileOutputStream fileOut = new FileOutputStream(archivoExcel)) {
                workbook.write(fileOut);
            }

            workbook.close();

            JOptionPane.showMessageDialog(null, "¡Excel exportado con éxito!");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al exportar: " + e.getMessage());
        }
    }
     private void exportarTabla(Connection conn, Workbook workbook, String nombreTabla) {
        try {
            String consulta = "SELECT * FROM " + nombreTabla + " WHERE  estado = true;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            Sheet hoja = workbook.createSheet(nombreTabla+" a la venta");

            // Crear cabecera
            Row header = hoja.createRow(0);
            int columnas = rs.getMetaData().getColumnCount();

            for (int i = 1; i <= columnas; i++) {
                header.createCell(i - 1).setCellValue(rs.getMetaData().getColumnName(i));
            }

            // Llenar datos
            int rowIndex = 1;
            while (rs.next()) {
                Row fila = hoja.createRow(rowIndex++);
                for (int i = 1; i <= columnas; i++) {
                    fila.createCell(i - 1).setCellValue(rs.getString(i));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error exportando la tabla: " + nombreTabla + "\n" + e.getMessage());
        }
    }
     private void exportarTabla_V(Connection conn, Workbook workbook, String nombreTabla) {
        try {
            String consulta = "SELECT * FROM " + nombreTabla + " WHERE  estado = false and credito = 0;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            Sheet hoja = workbook.createSheet(nombreTabla+" Vendido");

            // Crear cabecera
            Row header = hoja.createRow(0);
            int columnas = rs.getMetaData().getColumnCount();

            for (int i = 1; i <= columnas; i++) {
                header.createCell(i - 1).setCellValue(rs.getMetaData().getColumnName(i));
            }

            // Llenar datos
            int rowIndex = 1;
            while (rs.next()) {
                Row fila = hoja.createRow(rowIndex++);
                for (int i = 1; i <= columnas; i++) {
                    fila.createCell(i - 1).setCellValue(rs.getString(i));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error exportando la tabla: " + nombreTabla + "\n" + e.getMessage());
        }
    }
     private void exportarTabla_D(Connection conn, Workbook workbook, String nombreTabla) {
        try {
            String consulta = "SELECT * FROM " + nombreTabla + " WHERE  estado = false and precio = 0;";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(consulta);

            Sheet hoja = workbook.createSheet(nombreTabla+" Deuda");

            // Crear cabecera
            Row header = hoja.createRow(0);
            int columnas = rs.getMetaData().getColumnCount();

            for (int i = 1; i <= columnas; i++) {
                header.createCell(i - 1).setCellValue(rs.getMetaData().getColumnName(i));
            }

            // Llenar datos
            int rowIndex = 1;
            while (rs.next()) {
                Row fila = hoja.createRow(rowIndex++);
                for (int i = 1; i <= columnas; i++) {
                    fila.createCell(i - 1).setCellValue(rs.getString(i));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error exportando la tabla: " + nombreTabla + "\n" + e.getMessage());
        }
    }

}
