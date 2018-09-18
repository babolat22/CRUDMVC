/*
 *ESTA CLASE HACE LA PRESISTENCIA EN LA BASE DE DATOS CON UNA ENTIDAD que es parametro
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author juanj
 */
public class ConsultasProducto extends Conexion {
   
    public boolean registrar(Producto pro){
        PreparedStatement ps;
        Connection con = getConection();
        String sql ="INSERT INTO PRODUCTO (codigo, nombre, precio, cantidad) VALUES (?,?,?,?)";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getCantidad());
            ps.execute();
            return true;
        }
        catch(SQLException e){
            System.err.print(e);
            return false;
        }
        finally{
            try{
                con.close();
            }
            catch(SQLException e){
                System.err.print(e);
            return false;
            }
        }
    }
    
    public boolean modificar(Producto pro){
        PreparedStatement ps;
        Connection con = getConection();
        String sql ="UPDATE PRODUCTO SET codigo=?, nombre=?, precio=?, cantidad=? WHERE id=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            ps.setString(2, pro.getNombre());
            ps.setDouble(3, pro.getPrecio());
            ps.setInt(4, pro.getCantidad());
            ps.setInt(5, pro.getId());
            ps.execute();
            return true;
        }
        catch(SQLException e){
            System.err.print(e);
            return false;
        }
        finally{
            try{
                con.close();
            }
            catch(SQLException e){
                System.err.print(e);
            return false;
            }
        }
    }
    
    public boolean eliminar(Producto pro){
        PreparedStatement ps;
        Connection con = getConection();
        String sql ="DELETE FROM PRODUCTO WHERE id=?";
        try{
            ps = con.prepareStatement(sql);
            ps.setInt(1, pro.getId());
            ps.execute();
            return true;
        }
        catch(SQLException e){
            System.err.print(e);
            return false;
        }
        finally{
            try{
                con.close();
            }
            catch(SQLException e){
                System.err.print(e);
            return false;
            }
        }
    }
    
    public boolean buscar(Producto pro){
        
        Connection con = getConection();
        String sql ="SELECT * FROM PRODUCTO WHERE codigo=?";
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, pro.getCodigo());
            rs= ps.executeQuery();  // execute  query
            while (rs.next()){    //while si son varias filas
                pro.setId(Integer.parseInt(rs.getString("id")));
                pro.setCodigo(rs.getString("codigo"));
                pro.setNombre(rs.getString("nombre"));
                pro.setPrecio(Double.parseDouble(rs.getString("precio")));
                pro.setCantidad(Integer.parseInt(rs.getString("cantidad")));
            }
            return true;
        }
        catch(SQLException e){
            System.err.print(e);
            return false;
        }
        finally{
            try{
                con.close();
            }
            catch(SQLException e){
                System.err.print(e);
            return false;
            }
        }
    }
}
