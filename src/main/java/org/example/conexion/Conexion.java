package org.example.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    public static Connection getConexion() {
        Connection conexion = null;
        var baseDatos = "estudiantes_db";
        var url = "jdbc:mysql://localhost:3306/" + baseDatos;
        var usuario = "root";
        var password = "123456";

        try {
            // Cargamos la clase del driver de mysql en memoria
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(url, usuario, password);
        } catch (ClassNotFoundException e) {
            System.out.println("Ocurrió un error en la conexión: " + e.getMessage());
        } catch (SQLException e){
            System.out.println("Ocurrió un error en SQLException: " + e.getMessage());
        }
        return conexion;
    }

    public static void main(String[] args) {
        try (Connection conexion = Conexion.getConexion()) {
            if (conexion != null)
                System.out.println("Conexión exitosa: " + conexion);
            else
                System.out.println("Error al conectarse");
        } catch (SQLException e) {
            System.out.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
}