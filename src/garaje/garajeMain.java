package garaje;

import garaje.Turismo.TipoCarroceria;
import garaje.Vehiculo.TipoCombustible;
import javafx.application.Application;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Patricio Egea Vera
 */
public class garajeMain extends Application{

    public static void main(String[] args) {
      
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception {
    
    Parent root = FXMLLoader.load(getClass().getResource("/vista/FXML garaje.fxml"));
    Scene scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
    }
}