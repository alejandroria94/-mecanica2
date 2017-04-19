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
public class Instructivo {

    private int idinstructivos;
    private String sistema;
    private String herramientas;
    private String actividades;
    private String recomendaciones;
    private String repuestos;
    private String generalidades;
    private String nombre;

    public boolean guardarInstructivo(String idEquipo) throws SQLException {
        boolean exito = false;
        ConexionBD conexion = new ConexionBD();
        String sentencia = "INSERT INTO instructivos( sistema, herramientas, actividades, recomendaciones,repuestos,generalidades,nombre) "
                + " VALUES ( '" + this.sistema + "','" + this.herramientas + "','" + this.actividades + "','" + this.recomendaciones + "','"
                + repuestos + "','" + generalidades + "','" + this.nombre + "');";
        if (conexion.setAutoCommitBD(false)) {
            boolean inserto = conexion.insertarBD(sentencia);
            if (inserto) {
                conexion.commitBD();
                exito = true;
            } else {
                conexion.rollbackBD();
            }
        }
        if (exito) {
            String sql = "SELECT LAST_INSERT_ID() AS Id FROM `instructivos`";
            ResultSet rs = conexion.consultarBD(sql);
            if (rs.next()) {
                String idIntrictivo = rs.getString("Id");
                String sentencia1 = "INSERT INTO instructivos_has_equipos(instructivos_idinstructivos,equipos_idequipos) values('" + idIntrictivo + "','" + idEquipo + "');";
                exito = false;
                if (conexion.setAutoCommitBD(false)) {
                    boolean inserto = conexion.insertarBD(sentencia1);
                    if (inserto) {
                        conexion.commitBD();
                        exito = true;
                    } else {
                        conexion.rollbackBD();
                    }
                }

            }
        }
        conexion.cerrarConexion();
        return exito;
    }

    public boolean borrarInstructivo(String idinstructivo) {
        boolean exito = false;
        ConexionBD conexion = new ConexionBD();
        if (conexion.setAutoCommitBD(false)) {
//            String sql = "DELETE FROM `comentarios` WHERE `NoIdent`='"+NoIdent+"'";
//            boolean borro = conexion.borrarBD(sql);
            String sql2 = "DELETE FROM `instructivos` WHERE `idinstructivos`='" + idinstructivo + "'";
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

    public ArrayList<Instructivo> listaInstructivos() throws SQLException {
        ConexionBD conexion = new ConexionBD();
        Instructivo i;
        ArrayList<Instructivo> listaInstructivos = new ArrayList<>();
        String sql = "select * from proveedores";
        ResultSet rs = conexion.consultarBD(sql);
        while (rs.next()) {
            i = new Instructivo();

            i.setIdinstructivos(rs.getInt("idinstructivos"));
            i.setSistema(rs.getString("sistema"));
            i.setHerramientas(rs.getString("herramientas"));
            i.setActividades(rs.getString("actividades"));
            i.setRecomendaciones(rs.getString("recomendaciones"));
            i.setRepuestos(rs.getString("repuestos"));
            i.setGeneralidades(rs.getString("generalidades"));
            i.setNombre(rs.getString("nombre"));
            
            listaInstructivos.add(i);
        }
        return listaInstructivos;
    }

    public int getIdinstructivos() {
        return idinstructivos;
    }

    public void setIdinstructivos(int idinstructivos) {
        this.idinstructivos = idinstructivos;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public String getHerramientas() {
        return herramientas;
    }

    public void setHerramientas(String herramientas) {
        this.herramientas = herramientas;
    }

    public String getActividades() {
        return actividades;
    }

    public void setActividades(String actividades) {
        this.actividades = actividades;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public String getRepuestos() {
        return repuestos;
    }

    public void setRepuestos(String repuestos) {
        this.repuestos = repuestos;
    }

    public String getGeneralidades() {
        return generalidades;
    }

    public void setGeneralidades(String generalidades) {
        this.generalidades = generalidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
