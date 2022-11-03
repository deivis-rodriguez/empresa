package edu.mintic.empresa.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.mintic.empresa.entidades.Empleado;
import edu.mintic.empresa.repositorio.EmpleadoRepository;

@RestController
public class EmpleadoController {
    private final EmpleadoRepository repository;

    EmpleadoController(EmpleadoRepository repository){
        this.repository = repository;
    }

    @GetMapping("/empleados")
    public List<Empleado> listarEmpleados(){
        return repository.findAll();
    }
    
}
