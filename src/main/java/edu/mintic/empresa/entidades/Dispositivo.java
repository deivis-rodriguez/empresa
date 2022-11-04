package edu.mintic.empresa.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Dispositivo {

    private @Id @GeneratedValue int idDispositivo;
    private String nombre;
    private String referencia;
    @ManyToOne
    @JoinColumn(name = "idEmpleado")
    private Empleado empleado;


    public Dispositivo() {
    }
    
    public Dispositivo(String nombre, String referencia, Empleado empleado) {
        this.nombre = nombre;
        this.referencia = referencia;
        this.empleado = empleado;
    }


    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getReferencia() {
        return this.referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public Empleado getEmpleado() {
        return this.empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public String toString() {
        return "Dispositivos [nombre=" + nombre + ", referencia=" + referencia + ", empleado=" + empleado + "]";
    }

    public int getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(int idDispositivo) {
        this.idDispositivo = idDispositivo;
    }


}
