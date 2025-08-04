package co.edu.uniquindio.poo.javacourse.viewController;

import co.edu.uniquindio.poo.javacourse.App;
import co.edu.uniquindio.poo.javacourse.controller.EstudianteController;
import co.edu.uniquindio.poo.javacourse.model.Estudiante;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class GestionEstudiantesViewController {

    private App app;

    @FXML
    private TextField txtNombreEstudiante;

    @FXML
    private TextField txtCodigoEstudiante;

    @FXML
    private TableView<Estudiante> tblEstudiantes;

    @FXML
    private TableColumn<Estudiante, String> colNombre;

    @FXML
    private TableColumn<Estudiante, String> colCodigo;

    @FXML
    private Button btnVolver;

    @FXML
    public void initialize() {
        colNombre.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNombre()));
        colCodigo.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getCodigo()));
        tblEstudiantes.setItems(EstudianteController.obtenerEstudiantes());
    }

    @FXML
    private void onRegistrarEstudiante() {
        String nombre = txtNombreEstudiante.getText();
        String codigo = txtCodigoEstudiante.getText();

        if (!nombre.isEmpty() && !codigo.isEmpty()) {
            boolean registrado = EstudianteController.registrarEstudiante(nombre, codigo);
            if (registrado) {
                limpiarCampos();
            } else {
                mostrarMensaje("Ya existe un estudiante con ese código.");
            }
        } else {
            mostrarMensaje("Ingrese todos los datos del estudiante.");
        }
    }

    private void limpiarCampos() {
        txtNombreEstudiante.clear();
        txtCodigoEstudiante.clear();
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    private void onVolverMenu() {
        app.mostrarMenuPrincipal();
    }

    public void setApp(App app) {
        this.app = app;
    }
}