/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crudmvc;

import Controlador.ctrlProducto;
import Modelo.ConsultasProducto;
import Modelo.Producto;
import Vista.frmProducto;

/**
 *
 * @author juanj
 */
public class CRUDMVC {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Producto mod = new Producto();
        ConsultasProducto modc = new ConsultasProducto();
        frmProducto frm = new frmProducto();
        
        ctrlProducto ctrl = new ctrlProducto(mod, modc, frm);
        ctrl.iniciar();
        frm.setVisible(true);
        
        
    }
    
}
