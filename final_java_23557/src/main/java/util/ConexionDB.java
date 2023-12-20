package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {

    private static final String URL = "jdbc:mysql://localhost:3306/integrador_cac";
    private static final String USER = "root";
    private static final String PASSWORD = "";

//    Bloque Est�tico (static {}):
//    Un bloque est�tico es una secci�n de c�digo que se ejecuta solo una vez, cuando la clase es cargada por el ClassLoader de Java.
//    Es �til para inicializar recursos est�ticos o realizar acciones de configuraci�n que solo necesitan realizarse una vez durante la vida �til de una aplicaci�n.
    
    static {
        try {
            // Carga din�micamente la clase especificada y la inicializa, retornando su objeto Class.
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al cargar el controlador JDBC");
        }
    }

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}