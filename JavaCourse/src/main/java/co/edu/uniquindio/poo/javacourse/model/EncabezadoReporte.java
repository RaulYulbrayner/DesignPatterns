package co.edu.uniquindio.poo.javacourse.model;

public class EncabezadoReporte extends DecoradorReporte {

    public EncabezadoReporte(CursoComponent componente) {
        super(componente);
    }

    @Override
    public String mostrarContenido() {
        return "== REPORTE CURSO ==\n" + componente.mostrarContenido();
    }

    @Override
    public int contarSubComponentes() {
        return componente.contarSubComponentes();
    }
}
