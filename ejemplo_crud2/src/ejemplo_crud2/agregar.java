/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo_crud2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author Nelson
 */
public class agregar {
   public void agregarcliente(String Cedula, String Nombre, String Direccion, String Ciudad, String Pais) throws SQLException {
        String sqlInsert = "INSERT INTO cliente (Cedula, Nombre, Direccion, Ciudad, Pais) VALUES (?, ?, ?, ?, ?)";
        try (Connection cn = new conexion().getConection();
             PreparedStatement pstmt = cn.prepareStatement(sqlInsert)) {

            pstmt.setString(1, Cedula);
            pstmt.setString(2, Nombre);
            pstmt.setString(3, Direccion);
            pstmt.setString(4, Ciudad);
            pstmt.setString(5, Pais);

            pstmt.executeUpdate();
            // su función es agregar nuevos registros a la base de datos
}
}
}
