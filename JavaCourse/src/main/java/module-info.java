module co.edu.uniquindio.poo.javacourse {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.poo.javacourse to javafx.fxml;
    opens co.edu.uniquindio.poo.javacourse.viewController to javafx.fxml;
    opens co.edu.uniquindio.poo.javacourse.controller to javafx.fxml;
    opens co.edu.uniquindio.poo.javacourse.model to javafx.fxml;
    exports co.edu.uniquindio.poo.javacourse;
}