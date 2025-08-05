package co.edu.uniquindio.poo.javacourse.viewController;

import co.edu.uniquindio.poo.javacourse.App;
import co.edu.uniquindio.poo.javacourse.controller.CursoController;
import co.edu.uniquindio.poo.javacourse.controller.EstudianteController;
import co.edu.uniquindio.poo.javacourse.controller.ProfesorController;
import co.edu.uniquindio.poo.javacourse.controller.ReporteFacadeController;
import co.edu.uniquindio.poo.javacourse.model.Curso;
import co.edu.uniquindio.poo.javacourse.model.Estudiante;
import co.edu.uniquindio.poo.javacourse.model.Profesor;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class GestionCursosViewController {

    private App app;
    private final CursoController cursoController;
    private final ReporteFacadeController reporteController;

    private ObservableList<Estudiante> estudiantesCurso;

    public GestionCursosViewController() {
        this.cursoController = new CursoController();
        this.reporteController = new ReporteFacadeController();
        this.estudiantesCurso = FXCollections.observableArrayList();
    }

    @FXML
    private TextField txtNombreCurso;

    @FXML
    private TextField txtCodigoCurso;

    @FXML
    private ComboBox<Estudiante> comboEstudiantes;

    @FXML
    private ComboBox<Profesor> comboProfesor;

    @FXML
    private TableView<Estudiante> tblEstudiantesCurso;

    @FXML
    private TableColumn<Estudiante, String> colNombre;

    @FXML
    private TableColumn<Estudiante, String> colCodigo;

    @FXML
    private CheckBox chkEncabezado;

    @FXML
    private CheckBox chkPiePagina;

    @FXML
    private TextArea areaReporte;

    @FXML
    private Button btnVolver;

    private Profesor profesorAsignado;

    @FXML
    public void initialize() {
        comboEstudiantes.setItems(EstudianteController.obtenerEstudiantes());
        comboProfesor.setItems(ProfesorController.obtenerProfesores());

        colNombre.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNombre()));
        colCodigo.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getCodigo()));

        tblEstudiantesCurso.setItems(estudiantesCurso);
    }

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
        Estudiante seleccionado = comboEstudiantes.getSelectionModel().getSelectedItem();

        if (seleccionado != null && !codigoCurso.isEmpty()) {
            boolean agregado = cursoController.agregarEstudianteACurso(codigoCurso, seleccionado.getNombre(), seleccionado.getCodigo());

            if (agregado) {
                estudiantesCurso.add(seleccionado);
                mostrarMensaje("Estudiante agregado al curso.");
            } else {
                mostrarMensaje("El estudiante ya está en el curso o el curso no existe.");
            }
        } else {
            mostrarMensaje("Seleccione un estudiante y asegúrese de que el curso esté registrado.");
        }
    }

    @FXML
    private void onAsignarProfesor() {
        String codigoCurso = txtCodigoCurso.getText();
        Profesor profesor = comboProfesor.getSelectionModel().getSelectedItem();

        if (profesor != null && !codigoCurso.isEmpty()) {
            Curso curso = cursoController.buscarCursoPorCodigo(codigoCurso);
            if (curso != null) {
                curso.setProfesor(profesor);
                mostrarMensaje("Profesor asignado correctamente.");
            } else {
                mostrarMensaje("Curso no encontrado.");
            }
        } else {
            mostrarMensaje("Debe registrar un curso y seleccionar un profesor.");
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
    private void onLimpiarReporte() {
        areaReporte.clear();
    }

    @FXML
    private void onExportarReporte() {
        String contenido = areaReporte.getText();

        if (contenido == null || contenido.trim().isEmpty()) {
            mostrarMensaje("No hay contenido para exportar.");
            return;
        }

        try {
            String nombreArchivo = "reporte_curso_" + System.currentTimeMillis() + ".txt";
            File archivo = new File(nombreArchivo);
            try (PrintWriter writer = new PrintWriter(archivo)) {
                writer.print(contenido);
            }
            mostrarMensaje("Reporte exportado exitosamente a: " + archivo.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            mostrarMensaje("Ocurrió un error al exportar el reporte.");
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