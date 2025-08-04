package co.edu.uniquindio.poo.javacourse.controller;

import co.edu.uniquindio.poo.javacourse.model.Estudiante;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class EstudianteController {

    private static final ObservableList<Estudiante> estudiantes = FXCollections.observableArrayList();

    public static boolean registrarEstudiante(String nombre, String codigo) {
        if (buscarEstudiantePorCodigo(codigo) == null) {
            estudiantes.add(new Estudiante(nombre, codigo));
            return true;
        }
        return false;
    }

    public static Estudiante buscarEstudiantePorCodigo(String codigo) {
        for (Estudiante estudiante : estudiantes) {
            if (estudiante.getCodigo().equals(codigo)) {
                return estudiante;
            }
        }
        return null;
    }

    public static ObservableList<Estudiante> obtenerEstudiantes() {
        return estudiantes;
    }

}
