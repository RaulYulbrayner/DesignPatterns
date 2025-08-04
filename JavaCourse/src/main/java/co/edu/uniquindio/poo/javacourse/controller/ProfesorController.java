package co.edu.uniquindio.poo.javacourse.controller;

import co.edu.uniquindio.poo.javacourse.model.Profesor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProfesorController {

    private static final ObservableList<Profesor> profesores = FXCollections.observableArrayList();

    public static boolean registrarProfesor(String nombre, String codigo) {
        if (buscarPorCodigo(codigo) == null) {
            profesores.add(new Profesor(nombre, codigo));
            return true;
        }
        return false;
    }

    public static Profesor buscarPorCodigo(String codigo) {
        for (Profesor p : profesores) {
            if (p.getCodigo().equals(codigo)) {
                return p;
            }
        }
        return null;
    }

    public static ObservableList<Profesor> obtenerProfesores() {
        return profesores;
    }
}

