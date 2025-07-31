package co.edu.uniquindio.poo.javabrew.viewController;

import co.edu.uniquindio.poo.javabrew.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PrimaryController {

    private App app;

    @FXML
    private Button btnGestionar;

    public void setApp(App app) {
        this.app = app;
    }

    @FXML
    public void onGestionarPedidos() {
        app.mostrarGestionPedidos();
    }
}
