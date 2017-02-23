/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Fido
 */
public class Tarea {

    private int idTareas;
    private String fechaInicio;
    private String fechaFin;
    private String materiales;
    private String nombre;
    private float costo;
    //private int OrdenesDeTrabajo_idOrdenesDeTrabajo;
    // private int OrdenesDeTrabajo_Equipos_idEquipos;

    public boolean guardarTarea(String idOrdenDeTrabajo, String idEquipo) {
        boolean exito = false;
        ConexionBD conexion = new ConexionBD();
        String sentencia = "INSERT INTO Tareas(fechaInicio, fechaFin, materiales, nombre, OrdenesDeTrabajo_idOrdenesDeTrabajo, OrdenesDeTrabajo_Equipos_idEquipos,costo) "
                + " VALUES ( '" + this.fechaInicio + "','" + this.fechaFin + "','" + this.materiales + "','" + this.nombre + "','" + idOrdenDeTrabajo + "','" + idEquipo + "','" + this.costo + "');";
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

    public boolean borrarTarea(String idTareas) {
        boolean exito = false;
        ConexionBD conexion = new ConexionBD();
        if (conexion.setAutoCommitBD(false)) {
//            String sql = "DELETE FROM `comentarios` WHERE `NoIdent`='"+NoIdent+"'";
//            boolean borro = conexion.borrarBD(sql);
            String sql2 = "DELETE FROM `Tareas` WHERE `idTareas`='" + idTareas + "'";
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

    public int getIdTareas() {
        return idTareas;
    }

    public void setIdTareas(int idTareas) {
        this.idTareas = idTareas;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(String fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getMateriales() {
        return materiales;
    }

    public void setMateriales(String materiales) {
        this.materiales = materiales;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

//    public int getOrdenesDeTrabajo_idOrdenesDeTrabajo() {
//        return OrdenesDeTrabajo_idOrdenesDeTrabajo;
//    }
//
//    public void setOrdenesDeTrabajo_idOrdenesDeTrabajo(int OrdenesDeTrabajo_idOrdenesDeTrabajo) {
//        this.OrdenesDeTrabajo_idOrdenesDeTrabajo = OrdenesDeTrabajo_idOrdenesDeTrabajo;
//    }
//
//    public int getOrdenesDeTrabajo_Equipos_idEquipos() {
//        return OrdenesDeTrabajo_Equipos_idEquipos;
//    }
//
//    public void setOrdenesDeTrabajo_Equipos_idEquipos(int OrdenesDeTrabajo_Equipos_idEquipos) {
//        this.OrdenesDeTrabajo_Equipos_idEquipos = OrdenesDeTrabajo_Equipos_idEquipos;
//    }
    public float getCosto() {
        return costo;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }

}
