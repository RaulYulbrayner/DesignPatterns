package co.edu.uniquindio.poo.javacourse.model;

public class PiePaginaReporte extends DecoradorReporte {

    public PiePaginaReporte(CursoComponent componente) {
        super(componente);
    }

    @Override
    public String mostrarContenido() {
        StringBuilder sb = new StringBuilder();

        sb.append(componente.mostrarContenido());
        sb.append("\n---------------------------------------------------------\n");
        sb.append("Este reporte fue generado automáticamente por el sistema.\n");

        return sb.toString();
    }

    @Override
    public int contarSubComponentes() {
        return componente.contarSubComponentes();
    }
}
