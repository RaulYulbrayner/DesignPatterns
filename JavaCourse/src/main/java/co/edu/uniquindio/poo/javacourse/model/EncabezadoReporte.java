package co.edu.uniquindio.poo.javacourse.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class EncabezadoReporte extends DecoradorReporte {

    public EncabezadoReporte(CursoComponent componente) {
        super(componente);
    }

    @Override
    public String mostrarContenido() {
        StringBuilder sb = new StringBuilder();

        sb.append("                  REPORTE DETALLADO DEL CURSO\n");

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        sb.append("Fecha de generación: ").append(LocalDateTime.now().format(formatter)).append("\n\n");

        sb.append(componente.mostrarContenido());

        return sb.toString();
    }

    @Override
    public int contarSubComponentes() {
        return componente.contarSubComponentes();
    }
}
