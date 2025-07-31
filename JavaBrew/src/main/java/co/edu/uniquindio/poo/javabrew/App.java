package co.edu.uniquindio.poo.javabrew;

import co.edu.uniquindio.poo.javabrew.viewController.PrimaryController;
import co.edu.uniquindio.poo.javabrew.viewController.PedidoViewController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class App extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("JavaBrew - Sistema de Pedidos");
        mostrarMenuPrincipal();
    }

    private void mostrarMenuPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("menuPrincipal.fxml"));
            VBox root = loader.load();
            PrimaryController controller = loader.getController();
            controller.setApp(this);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarGestionPedidos() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(App.class.getResource("gestionPedidos.fxml"));
            AnchorPane root = loader.load();
            PedidoViewController controller = loader.getController();
            controller.setApp(this);
            Scene scene = new Scene(root);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}