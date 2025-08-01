package co.edu.uniquindio.poo.javacourse.controller;

import co.edu.uniquindio.poo.javacourse.model.Curso;
import co.edu.uniquindio.poo.javacourse.model.CursoComponent;
import co.edu.uniquindio.poo.javacourse.model.EncabezadoReporte;
import co.edu.uniquindio.poo.javacourse.model.PiePaginaReporte;

/**
 * Controlador para generación de reportes de cursos usando el patrón Facade.
 */
public class ReporteFacadeController {

    public ReporteFacadeController() {
    }

    public String generarReporteCurso(Curso curso, boolean incluirEncabezado, boolean incluirPiePagina) {
        CursoComponent componente = curso;

        if (incluirEncabezado) {
            componente = new EncabezadoReporte(componente);
        }

        if (incluirPiePagina) {
            componente = new PiePaginaReporte(componente);
        }

        return componente.mostrarContenido();
    }
}
