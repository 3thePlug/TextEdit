package controlador;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.stage.*;

public class vistaPrincipalController {
    @FXML
    private TextArea textArea;
    
    @FXML
    private MenuItem nuevo;

    @FXML
    private MenuItem saveAs;

    @FXML
    private MenuItem acercaDe;

    @FXML
    private MenuItem save;

    @FXML
    private MenuItem abrir;

    private File archivoAbierto;

    @FXML
    void openWind(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/vista/vistaAcercaDe.fxml"));
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage sg = new Stage();
            sg.setResizable(false);
            sg.centerOnScreen();
            sg.setMaximized(false);
            sg.initModality(Modality.APPLICATION_MODAL);
            sg.setScene(scene);
            sg.showAndWait();
        } catch (Exception e) {
            System.out.println("Problema al cargar la ventana");
        }
    }
    @FXML
    void nuevoArchivo(ActionEvent event) {

    }

    @FXML
    void openFile(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos de texto (*.txt)", "*.txt"));
        archivoAbierto = fileChooser.showOpenDialog(null);
        cargarArchivo(archivoAbierto);  
    }

    private void cargarArchivo(File archivoAbierto) {
        textArea.setText("");
        try {
            StringBuilder text = new StringBuilder();
            String line;
            Scanner scanner = new Scanner(archivoAbierto);
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                text.append(line).append("\n");
            }
            scanner.close();
            textArea.setText(text.toString());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al cargar el archivo");
            alert.setContentText("No se pudo abrir el archivo");
            alert.showAndWait();
        }
    }
    @FXML
    void guardarComo(ActionEvent event) {
        
            
        
    }

    @FXML
    void guardar(ActionEvent event) {
        try {
            FileWriter fileWriter = new FileWriter(archivoAbierto);
            fileWriter.write(textArea.getText());
            fileWriter.close();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error al guardar el archivo");
            alert.setContentText("No se pudo guardar el archivo");
            alert.showAndWait();
        }
    }

}
