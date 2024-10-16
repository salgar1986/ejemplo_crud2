/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejemplo_crud2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


/**
 *
 * @author Nelson
 */

public class editar {

    private Connection conexion;

    // Constructor de la clase, donde inicializamos la conexión
    public editar() {
        try {
            // Reemplaza estos valores con los de tu base de datos
           Class.forName("com.mysql.cj.jdbc.Driver");
            // Establece la conexión a la base de datos
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto25", "root", "86112273400NsM");
        } catch (ClassNotFoundException e) {
            System.err.println("Driver no encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    
    

    public void editarcliente(int id, String Cedula, String Nombre, String Direccion, String Ciudad, String Pais) throws SQLException {
        // Crear una consulta SQL para actualizar el cliente
        String sql = "UPDATE cliente SET Cedula = COALESCE(NULLIF(?, ''), Cedula), " +
                     "Nombre = COALESCE(NULLIF(?, ''), Nombre), " +
                     "Direccion = COALESCE(NULLIF(?, ''), Direccion), " +
                     "Ciudad = COALESCE(NULLIF(?, ''), Ciudad), " +
                     "Pais = COALESCE(NULLIF(?, ''), Pais) " +
                     "WHERE id = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setString(1, Cedula);
            stmt.setString(2, Nombre);
            stmt.setString(3, Direccion);
            stmt.setString(4, Ciudad);
            stmt.setString(5, Pais);
            stmt.setInt(6, id);

            stmt.executeUpdate();
        }
    }

    // Método para cerrar la conexión cuando ya no sea necesaria
    public void close() {
        try {
            if (conexion != null && !conexion.isClosed()) {
                conexion.close();
            }
        } catch (SQLException e) {
            System.err.println("Error al cerrar la conexión a la base de datos: " + e.getMessage());
            // Su función es editar registros de la base de datos
}
}
}
