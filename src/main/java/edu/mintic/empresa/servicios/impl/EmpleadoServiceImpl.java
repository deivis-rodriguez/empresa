package edu.mintic.empresa.servicios.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.mintic.empresa.entidades.Empleado;
import edu.mintic.empresa.excepciones.EmpleadoNoEncontradoException;
import edu.mintic.empresa.servicios.IEmpleadoService;
import edu.mintic.empresa.repositorio.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService {
   
    private final EmpleadoRepository repository;

    EmpleadoServiceImpl(EmpleadoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Empleado getEmpleado(long idEmpleado) {
        return repository.findById(idEmpleado).orElseThrow(() -> new EmpleadoNoEncontradoException(idEmpleado));
    }

    @Override
    public List<Empleado> listarEmpleados() {
        return repository.findAll();
    }

    @Override
    public Empleado crearEmpleado(Empleado empleado) {
        return repository.save(empleado);
    }

    @Override
    public Empleado actualizarEmpleado(Empleado empleado, long idEmpleado) {
        Empleado empleadoViejo = repository.findById(idEmpleado).orElseThrow();
        empleadoViejo.setApellido(empleado.getApellido());
        empleadoViejo.setNombre(empleado.getNombre());
        empleadoViejo.setCargo(empleado.getCargo());
        empleadoViejo.setSalario(empleado.getSalario());
        return repository.save(empleadoViejo);
    }

    @Override
    public void eliminarEmpleado(long idEmpleado) {
        repository.deleteById(idEmpleado);
    }

    @Override
    public Empleado buscarPorNombre(String nombreEmpleado) {
        return repository.findByNombre(nombreEmpleado).orElseThrow();
    }
    
}
