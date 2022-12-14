package edu.mintic.empresa.controladores;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.mintic.empresa.entidades.Empleado;
import edu.mintic.empresa.servicios.impl.EmpleadoServiceImpl;

@RestController
public class EmpleadoController {

    EmpleadoServiceImpl empleadoService;

    EmpleadoController(EmpleadoServiceImpl empleadoService) {
        this.empleadoService = empleadoService;
    }

    // obtener/leer recursos
    @GetMapping("/empleados")
    public List<Empleado> listarEmpleados() {
        return empleadoService.listarEmpleados();
    }

    @GetMapping("/empleado")
    public Empleado getEmpleado(@RequestParam(name = "idEmpleado",required = false, defaultValue = "1") long id) {
        return empleadoService.getEmpleado(id);
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
    @ResponseStatus(code = HttpStatus.CREATED)
    public Empleado crearEmpleado(@RequestBody Empleado empleado) {
        return empleadoService.crearEmpleado(empleado);
    }

    // actualizar recurso
    @PutMapping("/empleados/{idEmpleado}")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public Empleado actualizarEmpleado(@RequestBody Empleado empleado, @PathVariable long idEmpleado) {
        return empleadoService.actualizarEmpleado(empleado, idEmpleado);
    }

    @DeleteMapping("/empleados/{idEmpleado}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void eliminarEmpleado(@PathVariable long idEmpleado){
        empleadoService.eliminarEmpleado(idEmpleado);
    }

    @GetMapping("/empleados/{nombre}")
    public Empleado buscarPorNombre(@PathVariable String nombre){
        return empleadoService.buscarPorNombre(nombre);
    }

    /* 
    //PENDIENTE
    @PatchMapping("/empleados/{idEmpleado}")
    public Empleado actualizacionParcialEmpleado(@RequestBody Empleado empleado, @PathVariable long idEmpleado) {
        repository.
    } */

}
