/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Fido
 */
public class Proveedor {

    private int idproveedores;
    private String nombre;
    private String telefono;
    private String direccion;
    private String correoElectronico;
    ArrayList<Proveedor> listaProveedores;

    public boolean guardarProveedor() {
        boolean exito = false;
        ConexionBD conexion = new ConexionBD();
        String sentencia = "INSERT INTO proveedores( nombre, telefono, direccion, correoElectronico) "
                + " VALUES ( '" + this.nombre + "','" + this.telefono + "','" + this.direccion + "','" + this.correoElectronico + "');";
        if (conexion.setAutoCommitBD(false)) {
            boolean inserto = conexion.insertarBD(sentencia);
            if (inserto) {
                conexion.commitBD();
                exito = true;
            } else {
                conexion.rollbackBD();
            }
        }
        return exito;
    }

    public boolean borrarProveedor(String idproveedores) {
        boolean exito = false;
        ConexionBD conexion = new ConexionBD();
        if (conexion.setAutoCommitBD(false)) {
//            String sql = "DELETE FROM `comentarios` WHERE `NoIdent`='"+NoIdent+"'";
//            boolean borro = conexion.borrarBD(sql);
            String sql2 = "DELETE FROM `proveedores` WHERE `idproveedores`='" + idproveedores + "'";
            boolean borro2 = conexion.borrarBD(sql2);
            if (borro2) {
                conexion.commitBD();
                exito = true;
            } else {
                conexion.rollbackBD();
            }
        }
        return exito;
    }

    public ArrayList<Proveedor> listarProveedores() throws SQLException {
        ConexionBD conexion = new ConexionBD();
        Proveedor p;
        this.listaProveedores = new ArrayList<>();
        String sql = "select * from proveedores";
        ResultSet rs = conexion.consultarBD(sql);
        while (rs.next()) {
            p = new Proveedor();

            p.setIdproveedores(rs.getInt("idproveedores"));
            p.setNombre(rs.getString("nombre"));
            p.setTelefono(rs.getString("telefono"));
            p.setDireccion(rs.getString("direccion"));
            p.setCorreoElectronico(rs.getString("correoElectronico"));
            listaProveedores.add(p);
        }
        return this.listaProveedores;
    }

    public int getIdproveedores() {
        return idproveedores;
    }

    public void setIdproveedores(int idproveedores) {
        this.idproveedores = idproveedores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

}
