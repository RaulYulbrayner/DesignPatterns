package co.edu.uniquindio.poo.javabrew.viewController;

import co.edu.uniquindio.poo.javabrew.App;
import co.edu.uniquindio.poo.javabrew.controller.PedidoController;
import co.edu.uniquindio.poo.javabrew.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;
import co.edu.uniquindio.poo.javabrew.model.VeganoIngredientFactory;
import co.edu.uniquindio.poo.javabrew.model.ClasicoIngredientFactory;

public class PedidoViewController implements Initializable {

    private final PedidoController pedidoController = new PedidoController();
    private ObservableList<Cafe> listaCafes = FXCollections.observableArrayList();
    private Cafe cafeSeleccionado;

    @FXML private ComboBox<String> cmbTipo;
    @FXML private ComboBox<String> cmbTamaño;
    @FXML private ComboBox<String> cmbLeche;

    @FXML private TableView<Cafe> tblPedidos;
    @FXML private TableColumn<Cafe, String> colTipo;
    @FXML private TableColumn<Cafe, String> colTamaño;
    @FXML private TableColumn<Cafe, String> colLeche;

    @FXML private Button btnFactory;
    @FXML private Button btnBuilder;
    @FXML private Button btnClonar;
    @FXML private Button btnEliminar;
    @FXML private Button btnVegano;
    @FXML private Button btnClasico;

    private App app;

    public void setApp(App app) {
        this.app = app;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cmbTipo.getItems().addAll("Espresso", "Latte", "Capuccino", "Americano", "Mocha");
        cmbTamaño.getItems().addAll("Pequeño", "Mediano", "Grande");
        cmbLeche.getItems().addAll("Leche entera", "Deslactosada", "Almendras", "Sin leche");

        colTipo.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getTipo()));
        colTamaño.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getTamaño()));
        colLeche.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getLeche()));
        tblPedidos.setItems(listaCafes);

        tblPedidos.getSelectionModel().selectedItemProperty().addListener((obs, oldVal, newVal) -> {
            cafeSeleccionado = newVal;
            if (newVal != null) {
                cmbTipo.setValue(newVal.getTipo());
                cmbTamaño.setValue(newVal.getTamaño());
                cmbLeche.setValue(newVal.getLeche());
            }
        });
    }

    @FXML
    private void onCrearFactory() {
        String tipo = cmbTipo.getValue();
        if (tipo != null && !tipo.isEmpty()) {
            Cafe cafe = CafeFactory.crearCafe(tipo);
            if (pedidoController.crearPedidoCafe(cafe)) {
                listaCafes.add(cafe);
                limpiarCampos();
            }
        } else {
            mostrarError("Selecciona un tipo de café válido.");
        }
    }

    @FXML
    private void onCrearBuilder() {
        String tipo = cmbTipo.getValue();
        String tamano = cmbTamaño.getValue();
        String leche = cmbLeche.getValue();

        if (tipo != null && tamano != null && leche != null) {
            Cafe cafe = new CafeBuilder()
                    .setTipo(tipo)
                    .setTamaño(tamano)
                    .setLeche(leche)
                    .build();

            if (pedidoController.crearPedidoCafe(cafe)) {
                listaCafes.add(cafe);
                limpiarCampos();
            }
        } else {
            mostrarError("Completa todos los campos para usar Builder.");
        }
    }

    @FXML
    private void onClonar() {
        if (cafeSeleccionado != null) {
            Cafe clon = pedidoController.duplicarPedido(cafeSeleccionado);
            if (clon != null && pedidoController.crearPedidoCafe(clon)) {
                listaCafes.add(clon);
            }
        } else {
            mostrarError("Selecciona un pedido de café para clonar.");
        }
    }

    @FXML
    private void onEliminar() {
        if (cafeSeleccionado != null) {
            if (pedidoController.eliminarPedido(cafeSeleccionado)) {
                listaCafes.remove(cafeSeleccionado);
                limpiarCampos();
            }
        } else {
            mostrarError("Selecciona un café para eliminar.");
        }
    }

    @FXML
    private void onCrearClasico() {
        String tipo = cmbTipo.getValue();
        if (tipo != null && !tipo.isEmpty()) {
            IngredientFactory factory = new ClasicoIngredientFactory();
            Cafe cafe = new Cafe(tipo, factory.obtenerTamaño(), factory.obtenerLeche());
            if (pedidoController.crearPedidoCafe(cafe)) {
                listaCafes.add(cafe);
                limpiarCampos();
            }
        } else {
            mostrarError("Selecciona un tipo de café para usar la fábrica clásica.");
        }
    }

    @FXML
    private void onCrearVegano() {
        String tipo = cmbTipo.getValue();
        if (tipo != null && !tipo.isEmpty()) {
            IngredientFactory factory = new VeganoIngredientFactory();
            Cafe cafe = new Cafe(tipo, factory.obtenerTamaño(), factory.obtenerLeche());
            if (pedidoController.crearPedidoCafe(cafe)) {
                listaCafes.add(cafe);
                limpiarCampos();
            }
        } else {
            mostrarError("Selecciona un tipo de café para usar la fábrica vegana.");
        }
    }

    private void limpiarCampos() {
        cmbTipo.getSelectionModel().clearSelection();
        cmbTamaño.getSelectionModel().clearSelection();
        cmbLeche.getSelectionModel().clearSelection();
        cafeSeleccionado = null;
        tblPedidos.getSelectionModel().clearSelection();
    }

    private void mostrarError(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Atención");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
