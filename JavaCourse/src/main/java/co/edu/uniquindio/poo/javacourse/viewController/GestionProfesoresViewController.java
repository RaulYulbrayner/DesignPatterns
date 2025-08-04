package co.edu.uniquindio.poo.javacourse.viewController;

import co.edu.uniquindio.poo.javacourse.App;
import co.edu.uniquindio.poo.javacourse.controller.ProfesorController;
import co.edu.uniquindio.poo.javacourse.model.Profesor;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class GestionProfesoresViewController {

    private App app;

    @FXML
    private TextField txtNombreProfesor;

    @FXML
    private TextField txtCodigoProfesor;

    @FXML
    private TableView<Profesor> tblProfesores;

    @FXML
    private TableColumn<Profesor, String> colNombre;

    @FXML
    private TableColumn<Profesor, String> colCodigo;

    @FXML
    private Button btnVolver;

    @FXML
    public void initialize() {
        colNombre.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNombre()));
        colCodigo.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getCodigo()));
        tblProfesores.setItems(ProfesorController.obtenerProfesores());
    }

    @FXML
    private void onRegistrarProfesor() {
        String nombre = txtNombreProfesor.getText();
        String codigo = txtCodigoProfesor.getText();

        if (!nombre.isEmpty() && !codigo.isEmpty()) {
            boolean registrado = ProfesorController.registrarProfesor(nombre, codigo);
            if (registrado) {
                limpiarCampos();
            } else {
                mostrarMensaje("Ya existe un profesor con ese código.");
            }
        } else {
            mostrarMensaje("Ingrese todos los datos del profesor.");
        }
    }

    private void limpiarCampos() {
        txtNombreProfesor.clear();
        txtCodigoProfesor.clear();
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