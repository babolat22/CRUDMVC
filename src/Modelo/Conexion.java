package Modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author juanj
 */
public class Conexion {
    private final String base = "tienda";
    private final String url = "jdbc:mysql://localhost:3306/"+base;
    private final String user = "root";
    private final String pass = "";
    private Connection con;
    
    public Connection getConection() {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection(url, user, pass);
        }
        catch(SQLException | ClassNotFoundException e){
            System.err.print(e);
        
        }
        return  con;
    }
}
