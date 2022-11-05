package edu.mintic.empresa.servicios;

import java.util.List;

import edu.mintic.empresa.entidades.Empleado;

public interface IEmpleadoService {

    public Empleado getEmpleado(long idEmpleado);
    public List<Empleado> listarEmpleados();
    public Empleado crearEmpleado(Empleado empleado);
    public Empleado actualizarEmpleado(Empleado empleado, long idEmpleado);
    public void eliminarEmpleado(long idEmpleado);
    public Empleado buscarPorNombre(String nombreEmpleado);
    
}
