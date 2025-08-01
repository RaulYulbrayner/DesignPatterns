package co.edu.uniquindio.poo.javacourse.controller;

import java.util.ArrayList;
import java.util.List;

import co.edu.uniquindio.poo.javacourse.model.Curso;
import co.edu.uniquindio.poo.javacourse.model.Estudiante;

public class CursoController {

    private final List<Curso> cursos;

    public CursoController() {
        this.cursos = new ArrayList<>();
    }

    public boolean registrarCurso(String nombre, String codigo) {
        if (buscarCursoPorCodigo(codigo) == null) {
            Curso nuevo = new Curso(nombre, codigo);
            cursos.add(nuevo);
            return true;
        }
        return false;
    }

    public Curso buscarCursoPorCodigo(String codigo) {
        for (Curso curso : cursos) {
            if (curso.getCodigo().equals(codigo)) {
                return curso;
            }
        }
        return null;
    }

    public boolean agregarEstudianteACurso(String codigoCurso, String nombreEst, String codigoEst) {
        Curso curso = buscarCursoPorCodigo(codigoCurso);
        if (curso != null) {
            Estudiante nuevo = new Estudiante(nombreEst, codigoEst);
            return curso.agregarEstudiante(nuevo);
        }
        return false;
    }

    public boolean eliminarCurso(String codigo) {
        Curso curso = buscarCursoPorCodigo(codigo);
        if (curso != null) {
            cursos.remove(curso);
            return true;
        }
        return false;
    }

    public List<Curso> obtenerCursos() {
        return cursos;
    }
}

