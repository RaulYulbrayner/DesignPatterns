package co.edu.uniquindio.poo.javacourse.viewController;

import co.edu.uniquindio.poo.javacourse.App;
import co.edu.uniquindio.poo.javacourse.controller.CursoController;
import co.edu.uniquindio.poo.javacourse.controller.ReporteFacadeController;
import co.edu.uniquindio.poo.javacourse.model.Curso;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class GestionCursosViewController {

    private App app;
    private final CursoController cursoController;
    private final ReporteFacadeController reporteController;

    public GestionCursosViewController() {
        this.cursoController = new CursoController();
        this.reporteController = new ReporteFacadeController();
    }

    @FXML
    private TextField txtNombreCurso;

    @FXML
    private TextField txtCodigoCurso;

    @FXML
    private TextField txtNombreEstudiante;

    @FXML
    private TextField txtCodigoEstudiante;

    @FXML
    private TextArea areaReporte;

    @FXML
    private CheckBox chkEncabezado;

    @FXML
    private CheckBox chkPiePagina;

    @FXML
    private Button btnVolver;

    @FXML
    private void onRegistrarCurso() {
        String nombre = txtNombreCurso.getText();
        String codigo = txtCodigoCurso.getText();

        if (cursoController.registrarCurso(nombre, codigo)) {
            mostrarMensaje("Curso registrado exitosamente.");
        } else {
            mostrarMensaje("Ya existe un curso con ese código.");
        }
    }

    @FXML
    private void onAgregarEstudiante() {
        String codigoCurso = txtCodigoCurso.getText();
        String nombreEst = txtNombreEstudiante.getText();
        String codigoEst = txtCodigoEstudiante.getText();

        if (cursoController.agregarEstudianteACurso(codigoCurso, nombreEst, codigoEst)) {
            mostrarMensaje("Estudiante agregado.");
        } else {
            mostrarMensaje("No se pudo agregar. Verifique datos o duplicado.");
        }
    }

    @FXML
    private void onGenerarReporte() {
        String codigoCurso = txtCodigoCurso.getText();
        Curso curso = cursoController.buscarCursoPorCodigo(codigoCurso);

        if (curso != null) {
            String reporte = reporteController.generarReporteCurso(
                    curso,
                    chkEncabezado.isSelected(),
                    chkPiePagina.isSelected()
            );
            areaReporte.setText(reporte);
        } else {
            mostrarMensaje("Curso no encontrado.");
        }
    }

    @FXML
    private void onVolverMenu() {
        app.mostrarMenuPrincipal();
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Mensaje");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void setApp(App app) {
        this.app = app;
    }
}
