package co.edu.uniquindio.poo.javacourse.viewController;

import co.edu.uniquindio.poo.javacourse.App;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class GestionEstudiantesViewController {

    private App app;

    @FXML
    private TextField txtNombreEstudiante;

    @FXML
    private TextField txtCodigoEstudiante;

    @FXML
    private Button btnVolver;

    @FXML
    private void onRegistrarEstudiante() {
        String nombre = txtNombreEstudiante.getText();
        String codigo = txtCodigoEstudiante.getText();

        if (!nombre.isEmpty() && !codigo.isEmpty()) {
            mostrarMensaje("Estudiante registrado: " + nombre + " (" + codigo + ")");
        } else {
            mostrarMensaje("Ingrese todos los datos del estudiante.");
        }
    }

    @FXML
    private void onVolverMenu() {
        app.mostrarMenuPrincipal();
    }

    private void mostrarMensaje(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    public void setApp(App app) {
        this.app = app;
    }
}
