package edu.mintic.empresa.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import edu.mintic.empresa.entidades.Empleado;
import edu.mintic.empresa.repositorio.EmpleadoRepository;

@RestController
public class EmpleadoController {
    private final EmpleadoRepository repository;

    EmpleadoController(EmpleadoRepository repository) {
        this.repository = repository;
    }

    // obtener/leer recursos
    @GetMapping("/empleados")
    public List<Empleado> listarEmpleados() {
        return repository.findAll();
    }

    @GetMapping("/empleado")
    public Empleado getEmpleado(@RequestParam(name = "idEmpleado",required = false, defaultValue = "1") long id) {
        return repository.findById(id).orElseThrow();
    }

    /* 
     @GetMapping("/empleado")
    public Empleado getEmpleado(@RequestParam(name = "idEmpleado") Optional<Long> id) {
        long idEmpleado = id.orElseGet(() -> 1L);
        return repository.findById(idEmpleado).orElseThrow();
    }
     */

    // crear recursos
    @PostMapping("/empleados")
    public Empleado crearEmpleado(@RequestBody Empleado empleado) {
        return repository.save(empleado);
    }

    // actualizar recurso
    @PutMapping("/empleados/{idEmpleado}")
    public Empleado actualizarEmpleado(@RequestBody Empleado empleado, @PathVariable long idEmpleado) {
        Empleado empleadoViejo = repository.findById(idEmpleado).orElseThrow();
        empleadoViejo.setApellido(empleado.getApellido());
        empleadoViejo.setNombre(empleado.getNombre());
        empleadoViejo.setCargo(empleado.getCargo());
        empleadoViejo.setSalario(empleado.getSalario());
        return repository.save(empleadoViejo);
    }

    @DeleteMapping("/empleados/{idEmpleado}")
    public void eliminarEmpleado(@PathVariable long idEmpleado){
        repository.deleteById(idEmpleado);
    }

    /* 
    //PENDIENTE
    @PatchMapping("/empleados/{idEmpleado}")
    public Empleado actualizacionParcialEmpleado(@RequestBody Empleado empleado, @PathVariable long idEmpleado) {
        repository.
    } */

}
