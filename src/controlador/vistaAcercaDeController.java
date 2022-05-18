package controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class vistaAcercaDeController {
    @FXML
    private Button cerrar;
    
    @FXML
    void closeWind(ActionEvent event) {
        Stage stage = (Stage) cerrar.getScene().getWindow();
        // do what you have to do
        stage.close();
    }

}
