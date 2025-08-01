package co.edu.uniquindio.poo.javacourse.model;

public class CursoAdapter implements CursoComponent {

    private final CursoExterno cursoExterno;

    public CursoAdapter(CursoExterno cursoExterno) {
        this.cursoExterno = cursoExterno;
    }

    @Override
    public String mostrarContenido() {
        return cursoExterno.extraerDatos();
    }

    @Override
    public int contarSubComponentes() {
        return 1;
    }

    public CursoExterno getCursoExterno() {
        return cursoExterno;
    }
}
