package co.edu.uniquindio.poo.javacourse.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import co.edu.uniquindio.poo.javacourse.App;

public class MenuPrincipalViewController {

    private App app;

    @FXML
    private Button btnCursos;

    @FXML
    private Button btnEstudiantes;

    @FXML
    private Button btnProfesores;

    @FXML
    public void initialize() {
    }

    @FXML
    private void onGestionCursos() {
        app.mostrarGestionCursos();
    }

    @FXML
    private void onGestionEstudiantes() {
        app.mostrarGestionEstudiantes();
    }

    @FXML
    private void onGestionProfesores() {
        app.mostrarGestionProfesores();
    }

    public void setApp(App app) {
        this.app = app;
    }
}
