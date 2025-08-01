package co.edu.uniquindio.poo.javacourse.model;

import java.util.ArrayList;
import java.util.List;

public class Curso implements CursoComponent {
    private final String nombre;
    private final String codigo;
    private final List<Estudiante> estudiantes;

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

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String mostrarContenido() {
        StringBuilder sb = new StringBuilder("Curso: " + nombre + " (" + codigo + ")\n");
        sb.append("  Estudiantes:\n");
        for (Estudiante e : estudiantes) {
            sb.append("    - ").append(e.toString()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public int contarSubComponentes() {
        return 1;
    }
}
