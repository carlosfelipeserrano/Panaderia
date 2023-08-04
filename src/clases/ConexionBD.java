/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3308/panaderia";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";
    private Connection con = null;

    public Connection getConexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.out.println("Error: No se encontró el controlador JDBC");
            e.printStackTrace(); // Imprimir el error completo para depuración
        } catch (SQLException e) {
            System.out.println("Error al establecer la conexión con la base de datos: " + e.getMessage());
            e.printStackTrace(); // Imprimir el error completo para depuración
        }
        return con;
    }
}



