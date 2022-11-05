package edu.mintic.empresa.entidades;

import java.util.List;

//import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
//import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;

@Entity
//@Table(name = "tbl_empleado")
public class Empleado {

    //@Column(name = "id_empleado")
    private @Id @GeneratedValue long idEmpleado;
    private String nombre;
    private String apellido;
    private double salario;
    private String cargo;
    @OneToMany(mappedBy = "empleado")
    private List<Dispositivo> dispositivos;

    public Empleado() {
    }

    public Empleado(String nombre, String apellido, double salario, String cargo, List<Dispositivo> dispositivos) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.salario = salario;
        this.cargo = cargo;
        this.dispositivos = dispositivos;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return this.apellido;
    }

    public String getCargo() {
        return this.cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSalario() {
        return this.salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public long getIdEmpleado() {
        return this.idEmpleado;
    }

    public void setIdEmpleado(long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String toString() {
        return "idEmpleado: " + idEmpleado + "\n"
                + "nombre: " + nombre + "\n"
                + "apellido: " + apellido + "\n"
                + "cargo: " + cargo + "\n"
                + "salario: " + salario + "\n";
    }

    public List<Dispositivo> getDispositivos() {
        return dispositivos;
    }

    public void setDispositivos(List<Dispositivo> dispositivos) {
        this.dispositivos = dispositivos;
    }

}
