package co.edu.uniquindio.poo.javacourse.model;

public class CursoExterno {
    private final String datos;

    public CursoExterno(String datos) {
        this.datos = datos;
    }

    public String extraerDatos() {
        return "Curso externo importado: " + datos;
    }
}
