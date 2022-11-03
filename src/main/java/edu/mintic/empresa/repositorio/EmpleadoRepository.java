package edu.mintic.empresa.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import edu.mintic.empresa.entidades.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {

}
