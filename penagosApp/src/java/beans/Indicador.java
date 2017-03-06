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
    float totalHorasMto;
    float totalHorasParada;
    int dia;
    int mes;
    int anno;
    int numeroOTs;

    public Indicador() {
        this.mantenibilidad=1;
        this.accidentabilidad=2;
        this.disponibilidad=3;
        this.confiabilidad=4;
    }
    
     public void sumarNumeroOt(){
        this.numeroOTs+=1;
    }
    public void sumarHorasParada(float horas){
        this.totalHorasParada+=horas;
    }
    public void sumarHorasMTO(float horas){
        this.totalHorasMto+=horas;
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

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public float getTotalHorasMto() {
        return totalHorasMto;
    }

    public void setTotalHorasMto(float totalHorasMto) {
        this.totalHorasMto = totalHorasMto;
    }

    public float getTotalHorasParada() {
        return totalHorasParada;
    }

    public void setTotalHorasParada(float totalHorasParada) {
        this.totalHorasParada = totalHorasParada;
    }

    public int getNumeroOTs() {
        return numeroOTs;
    }

    public void setNumeroOTs(int numeroOTs) {
        this.numeroOTs = numeroOTs;
    }
           
}
