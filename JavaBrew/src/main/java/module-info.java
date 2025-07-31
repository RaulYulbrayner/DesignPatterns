module co.edu.uniquindio.poo.javabrew {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.javabrew to javafx.fxml;
    exports co.edu.uniquindio.poo.javabrew;
    exports co.edu.uniquindio.poo.javabrew.viewController;
    opens co.edu.uniquindio.poo.javabrew.viewController to javafx.fxml;

}