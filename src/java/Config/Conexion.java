/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Config;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
}
