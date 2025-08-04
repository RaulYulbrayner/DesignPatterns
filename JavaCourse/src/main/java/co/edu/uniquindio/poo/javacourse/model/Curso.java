package co.edu.uniquindio.poo.javacourse.model;

import java.util.ArrayList;
import java.util.List;

public class Curso implements CursoComponent {

    private final String nombre;
    private final String codigo;
    private final List<Estudiante> estudiantes;
    private Profesor profesor;

    public Curso(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.estudiantes = new ArrayList<>();
    }

    public boolean agregarEstudiante(Estudiante estudiante) {
        for (Estudiante e : estudiantes) {
            if (e.getCodigo().equals(estudiante.getCodigo())) {
                return false;
            }
        }
        estudiantes.add(estudiante);
        return true;
    }

    public boolean eliminarEstudiante(String codigoEstudiante) {
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getCodigo().equals(codigoEstudiante)) {
                estudiantes.remove(i);
                return true;
            }
        }
        return false;
    }

    public List<Estudiante> getEstudiantes() {
        return new ArrayList<>(estudiantes);
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String mostrarContenido() {
        StringBuilder sb = new StringBuilder();

        sb.append("Curso: ").append(nombre).append("\n");

        if (profesor != null) {
            sb.append("Profesor: ").append(profesor.getNombre()).append("\n");
        } else {
            sb.append("Profesor: No asignado\n");
        }

        sb.append("\nEstudiantes registrados:\n");
        if (estudiantes.isEmpty()) {
            sb.append("No hay estudiantes registrados.\n");
        } else {
            int i = 1;
            for (Estudiante e : estudiantes) {
                sb.append(i++).append(". ").append(e.getNombre()).append("\n");
            }
        }

        sb.append("\nTotal de estudiantes: ").append(estudiantes.size()).append("\n");

        return sb.toString();
    }

    @Override
    public int contarSubComponentes() {
        return 1;
    }
}