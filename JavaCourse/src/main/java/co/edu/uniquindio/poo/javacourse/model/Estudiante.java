package co.edu.uniquindio.poo.javacourse.model;

public class Estudiante {
    private final String nombre;
    private final String codigo;

    public Estudiante(String nombre, String codigo) {
        this.nombre = nombre;
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public String toString() {
        return nombre + " (" + codigo + ")";
    }
}

