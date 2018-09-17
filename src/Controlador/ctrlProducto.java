/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasProducto;
import Modelo.Producto;
import Vista.frmProducto;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author juanj
 */
public class ctrlProducto implements ActionListener {

    private Producto mod;
    private ConsultasProducto modc;
    private frmProducto frm;
    
     public ctrlProducto(Producto mod, ConsultasProducto modc, frmProducto frm) {
        this.mod = mod;
        this.modc = modc;
        this.frm = frm;
        frm.btnBusca.addActionListener(this);
        frm.btnElimina.addActionListener(this);
        frm.btnGuarda.addActionListener(this);
        frm.btnModifica.addActionListener(this);
        frm.btnLimpia.addActionListener(this);
    }
     
    //iniciar la vista . posicion titulo del formulario 
     public void iniciar(){
         frm.setTitle("Formulario Productos");
         frm.setLocationRelativeTo(frm);
         frm.txtID.setVisible(true);
        
     }
     
     // ARMA LA ENTIDAD Y DA LA ORDEN DE PERSISTENCIA A LA CLASE CONSULTA
    @Override
     public void actionPerformed(ActionEvent e){
         //SI OPRIME GUARDAR
         if(e.getSource()==frm.btnGuarda){
             //tomamos lo que viene de la vista y lo mandamos al modelo
             mod.setCodigo(frm.txtCodigo.getText());
             mod.setNombre(frm.txtNombre.getText());
             mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
             mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
                   // en registrar de la consulta es true o false
             if(modc.registrar(mod))
                 JOptionPane.showMessageDialog(null, "Registro Guardado!");
                 
             else
                 JOptionPane.showMessageDialog(null, "Error al guardar..");
             Limpiar();
         }
         //SI OPRIME MODIFICAR
            if(e.getSource()==frm.btnModifica){
             frm.txtID.setVisible(true);
             mod.setId(Integer.parseInt(frm.txtID.getText()));
            //tomamos lo que viene de la vista y lo mandamos al modelo
             mod.setCodigo(frm.txtCodigo.getText());
             mod.setNombre(frm.txtNombre.getText());
             mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
             mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
                   // en MODIFICAR de la consulta es true o false
             if(modc.modificar(mod))
                 JOptionPane.showMessageDialog(null, "Registro Modificado!");
             else
                 JOptionPane.showMessageDialog(null, "Error al Modificar..");
             Limpiar();
         }
            
            
          //SI OPRIME ELIMINAR
        if(e.getSource()==frm.btnElimina){
             mod.setId(Integer.parseInt(frm.txtID.getText()));
            //tomamos lo que viene de la vista y lo mandamos al modelo
             //mod.setCodigo(frm.txtCodigo.getText());
             //mod.setNombre(frm.txtNombre.getText());
             //mod.setPrecio(Double.parseDouble(frm.txtPrecio.getText()));
            // mod.setCantidad(Integer.parseInt(frm.txtCantidad.getText()));
                   // en registrar de la consulta es true o false
             if(modc.eliminar(mod))
                 JOptionPane.showMessageDialog(null, "Registro Eliminado!");
                 
             else
                 JOptionPane.showMessageDialog(null, "Error al Eliminar..");
             Limpiar();
         }   
            
                //SI OPRIME buscar
        if(e.getSource()==frm.btnBusca){
             mod.setCodigo(frm.txtCodigo.getText());  // codigo
            
             // en BUSCAR de la consulta es true o false
             if(modc.buscar(mod)){
                 
                 //USAR String.valueOf PARA EL PARSEO  !!!
                 frm.txtID.setText(String.valueOf(mod.getId()));
                 frm.txtCodigo.setText(mod.getCodigo());
                 frm.txtNombre.setText(mod.getNombre());
                 frm.txtPrecio.setText(String.valueOf(mod.getPrecio()));
                 frm.txtCantidad.setText(String.valueOf(mod.getCantidad()));
             }                 
                 else{
                 JOptionPane.showMessageDialog(null, "Error al Buscar..");
                 Limpiar();
            }
        }   
            
        if(e.getSource()==frm.btnLimpia){
            Limpiar();
        }    
     }
    public void Limpiar(){  //las cajas de texto
        frm.txtCodigo.setText(null);
        frm.txtNombre.setText(null);
        frm.txtPrecio.setText(null);
        frm.txtCantidad.setText(null);
        frm.txtID.setText(null);
               
    }
}
