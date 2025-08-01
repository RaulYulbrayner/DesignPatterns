package co.edu.uniquindio.poo.javacourse.model;

// Patrón Decorator - base abstracta

public abstract class DecoradorReporte implements CursoComponent {

    protected final CursoComponent componente;

    public DecoradorReporte(CursoComponent componente) {
        this.componente = componente;
    }

    public CursoComponent getComponente() {
        return componente;
    }
}
