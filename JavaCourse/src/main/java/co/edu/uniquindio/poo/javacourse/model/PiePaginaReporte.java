package co.edu.uniquindio.poo.javacourse.model;

public class PiePaginaReporte extends DecoradorReporte {

    public PiePaginaReporte(CursoComponent componente) {
        super(componente);
    }

    @Override
    public String mostrarContenido() {
        return componente.mostrarContenido() + "\n== FIN DEL REPORTE ==";
    }

    @Override
    public int contarSubComponentes() {
        return componente.contarSubComponentes();
    }
}
