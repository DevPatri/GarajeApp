package controlador;

import garaje.Industrial;
import garaje.Moto;
import garaje.Turismo;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Pane;
import garaje.Vehiculo.TipoCombustible;
import garaje.Turismo.TipoCarroceria;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import garaje.TipoMedidas;
import garaje.Vehiculo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Patri
 */
public class FXMLGarajeController implements Initializable {

    @FXML
    private Pane pOpciones;
    @FXML
    private Pane pDatos;
    @FXML
    private RadioButton rbTurismo;
    @FXML
    private RadioButton rbMoto;
    @FXML
    private RadioButton rbIndustrial;
    @FXML
    private ComboBox<TipoCombustible> cbTipoCombustible;
    @FXML
    private ComboBox<TipoCarroceria> cbTipoCarroceria;
    @FXML
    private RadioButton rb2;
    @FXML
    private RadioButton rb3;
    @FXML
    private RadioButton rb4;
    @FXML
    private ObservableList<Vehiculo> vehiculos;
    @FXML
    private ListView<Vehiculo> lvVista;
    @FXML
    private Pane pNumRuedas;
    @FXML
    private ToggleGroup tipoVehiculo;
    @FXML
    private ToggleGroup numRuedas;
    @FXML
    private TextField tfLargo;
    @FXML
    private TextField tfAncho;
    @FXML
    private TextField tfAlto;
    @FXML
    private TextField tfMarca;
    @FXML
    private TextField tfModelo;
    @FXML
    private TextField tfKms;
    @FXML
    private TextField tfCv;
    @FXML
    private TextField tfPrecio;
    @FXML
    private TextField tfAnio;
    @FXML
    private TextField tfTamañoCaja;
    @FXML
    private Button btguardar;
    @FXML
    private Button btBorrar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        cbTipoCarroceria.setDisable(true);
        pNumRuedas.setDisable(true);
        cbTipoCombustible.getItems().addAll(TipoCombustible.values());
        cbTipoCarroceria.getItems().addAll(TipoCarroceria.values());
        vehiculos = FXCollections.observableArrayList();
        lvVista.setItems(vehiculos);
    }
//configuración para que cuando esté seleccionado turismo, se anulen las que no les corresponden.

    @FXML
    private void selectTurismo(ActionEvent event) {
        cbTipoCarroceria.setDisable(false);
        tfTamañoCaja.setDisable(true);
        pNumRuedas.setDisable(true);
    }
//configuración para que cuando esté seleccionado moto, se anulen las que no les corresponden.

    @FXML
    private void selectMoto(ActionEvent event) {
        pNumRuedas.setDisable(false);
        cbTipoCarroceria.setDisable(true);
        tfTamañoCaja.setDisable(true);
    }

//configuración para que cuando esté seleccionado industrial, se anulen las que no les corresponden.
    @FXML
    private void selectIndus(ActionEvent event) {
        pNumRuedas.setDisable(true);
        cbTipoCarroceria.setDisable(true);
        tfTamañoCaja.setDisable(false);
    }

    @FXML
    private void guardarVehiculo(ActionEvent event) {

        if (rbTurismo.isSelected()) {
            crearTurismo();
        } else if (rbMoto.isSelected()) {
            crearMoto();
        } else if (rbIndustrial.isSelected()) {
            crearIndustrial();

        }
    }

    //método para borrar vehiculos de la lista
    @FXML
    private void borrarVehiculo(ActionEvent event) {
        Vehiculo v = this.lvVista.getSelectionModel().getSelectedItem();

        this.vehiculos.remove(v);
        this.lvVista.refresh();        
    }
//método para crear un vehiculo tipo turismo.

    private void crearTurismo() {
        Turismo coche;
        TipoCarroceria tipoCa = cbTipoCarroceria.getValue();
        TipoCombustible tipoCo = cbTipoCombustible.getValue();
        //Cogemos los valores de los objetos del formulario.
        String medidaL = tfLargo.getText();
        int medida1 = Integer.parseInt(medidaL);
        String medidaAn = tfAncho.getText();
        int medida2 = Integer.parseInt(medidaAn);
        String medidaAl = tfAlto.getText();
        int medida3 = Integer.parseInt(medidaAl);
        TipoMedidas medidaCoche = new TipoMedidas(medida1, medida2, medida3);

        //Cogemos los valores de los campos textfield y lo que haga falta los convertimos.
        String marca = tfMarca.getText();
        String modelo = tfModelo.getText();
        String anioFab = tfAnio.getText();
        int anio = Integer.parseInt(anioFab);
        String kmStr = tfKms.getText();
        int kms = Integer.parseInt(kmStr);
        String cvStr = tfCv.getText();
        int cv = Integer.parseInt(cvStr);
        String precioStr = tfPrecio.getText();
        double precio = Double.parseDouble(precioStr);
        //Aquí creamos el objeto turismo con las características recogidas.
        coche = new Turismo(tipoCa, marca, modelo, anio, kms, cv, precio, tipoCo, medidaCoche);
        lvVista.getItems().add(coche);

        cbTipoCarroceria.getSelectionModel().clearSelection();
        cbTipoCombustible.getSelectionModel().clearSelection();
        tfMarca.clear();
        tfModelo.clear();
        tfAnio.clear();
        tfKms.clear();
        tfCv.clear();
        tfPrecio.clear();
        tfTamañoCaja.clear();
        tfLargo.clear();
        tfAncho.clear();
        tfAlto.clear();
    }

    private void crearMoto() {
        Moto moto;
        moto = new Moto();

        TipoCombustible tipoCom = cbTipoCombustible.getValue();
        moto.setTipo(tipoCom);
        //Cogemos los valores de los objetos del formulario.
        String medidaL = tfLargo.getText();
        int medida1 = Integer.parseInt(medidaL);
        String medidaAn = tfAncho.getText();
        int medida2 = Integer.parseInt(medidaAn);
        String medidaAl = tfAlto.getText();
        int medida3 = Integer.parseInt(medidaAl);
        TipoMedidas medidaMoto = new TipoMedidas(medida1, medida2, medida3);
        moto.setMedidas(medidaMoto);

        //Cogemos los valores de los campos textfield y lo que haga falta los convertimos.
        String marcaM = tfMarca.getText();
        moto.setMarca(marcaM);
        String modeloM = tfModelo.getText();
        moto.setModelo(modeloM);
        String anioFab = tfAnio.getText();
        int anio = Integer.parseInt(anioFab);
        moto.setAñoFab(anio);
        String kmStr = tfKms.getText();
        int kmsM = Integer.parseInt(kmStr);
        moto.setKms(kmsM);
        String cvStr = tfCv.getText();
        int cv = Integer.parseInt(cvStr);
        moto.setcV(cv);
        String precioStr = tfPrecio.getText();
        double precioM = Double.parseDouble(precioStr);
        moto.setPrecio(precioM);
        int numRueda;
        if (rb2.isSelected()) {
            numRueda = 2;
        } else if (rb3.isSelected()) {
            numRueda = 3;
        } else {
            numRueda = 4;
        }
        moto.setNumRuedas(numRueda);

        lvVista.getItems().add(moto);

        cbTipoCarroceria.getSelectionModel().clearSelection();
        cbTipoCombustible.getSelectionModel().clearSelection();
        tfMarca.clear();
        tfModelo.clear();
        tfAnio.clear();
        tfKms.clear();
        tfCv.clear();
        tfPrecio.clear();
        tfTamañoCaja.clear();
        tfLargo.clear();
        tfAncho.clear();
        tfAlto.clear();
    }

    private void crearIndustrial() {
        //creamos el objeto Industrial y cogemos el valor del enum TipoCombustible y se lo guardamos.
        Industrial furgo;
        furgo = new Industrial();
        TipoCombustible tipoInd = cbTipoCombustible.getValue();
        furgo.setTipo(tipoInd);
        //guardamos las medidas en el tipoMedidas y luego lo metemos en el objeto.
        String medidaL = tfLargo.getText();
        int medida1 = Integer.parseInt(medidaL);
        String medidaAn = tfAncho.getText();
        int medida2 = Integer.parseInt(medidaAn);
        String medidaAl = tfAlto.getText();
        int medida3 = Integer.parseInt(medidaAl);
        TipoMedidas medidaIndus = new TipoMedidas(medida1, medida2, medida3);
        furgo.setMedidas(medidaIndus);
        //guardamos en el objeto todos los parámetros.
        String marcaM = tfMarca.getText();
        furgo.setMarca(marcaM);
        String modeloM = tfModelo.getText();
        furgo.setModelo(modeloM);
        String anioFab = tfAnio.getText();
        int anio = Integer.parseInt(anioFab);
        furgo.setAñoFab(anio);
        String kmStr = tfKms.getText();
        int kmsM = Integer.parseInt(kmStr);
        furgo.setKms(kmsM);
        String cvStr = tfCv.getText();
        int cv = Integer.parseInt(cvStr);
        furgo.setcV(cv);
        String precioStr = tfPrecio.getText();
        double precio = Double.parseDouble(precioStr);
        furgo.setPrecio(precio);

        String tamCaj = tfTamañoCaja.getText();
        float tamC = Float.parseFloat(tamCaj);
        furgo.setTamCaja(tamC);

        //añadimos la furgo recogidaa la lista.            
        lvVista.getItems().add(furgo);

        //vaciamos todos los campos.
        cbTipoCarroceria.getSelectionModel().clearSelection();
        cbTipoCombustible.getSelectionModel().clearSelection();
        tfMarca.clear();
        tfModelo.clear();
        tfAnio.clear();
        tfKms.clear();
        tfCv.clear();
        tfPrecio.clear();
        tfTamañoCaja.clear();
        tfLargo.clear();
        tfAncho.clear();
        tfAlto.clear();
    }
}
