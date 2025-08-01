package co.edu.uniquindio.poo.javacourse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import co.edu.uniquindio.poo.javacourse.viewController.*;

public class App extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Gestión de Cursos Universitarios");
        mostrarMenuPrincipal();
    }

    public void mostrarMenuPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/menuPrincipal.fxml"));
            AnchorPane root = loader.load();
            MenuPrincipalViewController controller = loader.getController();
            controller.setApp(this);
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarGestionCursos() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gestionCursos.fxml"));
            AnchorPane root = loader.load();
            GestionCursosViewController controller = loader.getController();
            controller.setApp(this);
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarGestionEstudiantes() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gestionEstudiantes.fxml"));
            AnchorPane root = loader.load();
            GestionEstudiantesViewController controller = loader.getController();
            controller.setApp(this);
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void mostrarGestionProfesores() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/gestionProfesores.fxml"));
            AnchorPane root = loader.load();
            GestionProfesoresViewController controller = loader.getController();
            controller.setApp(this);
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
