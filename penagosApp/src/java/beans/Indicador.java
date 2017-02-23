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
public class Indicador {
    float mantenibilidad;
    float accidentabilidad;
    float disponibilidad;
    float confiabilidad;
    int dia;

    public Indicador() {
        this.mantenibilidad=1;
        this.accidentabilidad=2;
        this.disponibilidad=3;
        this.confiabilidad=4;
    }

    public float getMantenibilidad() {
        return mantenibilidad;
    }

    public void setMantenibilidad(float mantenibilidad) {
        this.mantenibilidad = mantenibilidad;
    }

    public float getAccidentabilidad() {
        return accidentabilidad;
    }

    public void setAccidentabilidad(float accidentabilidad) {
        this.accidentabilidad = accidentabilidad;
    }

    public float getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(float disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public float getConfiabilidad() {
        return confiabilidad;
    }

    public void setConfiabilidad(float confiabilidad) {
        this.confiabilidad = confiabilidad;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }
    
    
    
    
    
    
}
