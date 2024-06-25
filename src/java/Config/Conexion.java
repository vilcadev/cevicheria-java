/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author user
 */
public class Conexion {
    
    
    Connection con;
    String url="jdbc:mysql://localhost:3306/bd_ventas";
    String user="root";
    String pass="12345";
    public Connection Conexion(){
        try{
            Class.forName("com.mysql.jdbc.driver");
            con = DriverManager.getConnection(url,user,pass);
        }catch(ClassNotFoundException | SQLException e){
            
        }
        return con;
    }
    
    
     public void consultaDePrueba() {
        Connection con = Conexion();

        if (con != null) {
            System.out.println("Conexión exitosa a la base de datos.");
            try {
                Statement stmt = con.createStatement();
                String query = "SELECT * FROM categoria"; // Consulta de prueba
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next()) {
                    int id = rs.getInt("Id");
                    String nombre = rs.getString("Nombre");
                    System.out.println("Id: " + id + ", Nombre: " + nombre);
                }

                rs.close();
                stmt.close();
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Error en la conexión a la base de datos.");
        }
    }
     
     
     public static void main(String[] args) {
        Conexion conexion = new Conexion();
        conexion.consultaDePrueba();
    }
}
