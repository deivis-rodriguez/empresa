package edu.mintic.empresa.excepciones;

public class EmpleadoNoEncontradoException extends RuntimeException {

    public EmpleadoNoEncontradoException(long idEmpleado) {
        super("No existe un empleado en la BD con id: " + idEmpleado);
    }

}
