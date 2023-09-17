package org.artavia.torres.p1;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import java.util.Map;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

/**
 * Clase para el controlador de la ventana principal
 */
public class VentanaPrincipalController implements Initializable {

    // ============= Parametros ================================================
    /**
     * Objeto de la clase MemoriaModel, que representa el contenido de la
     * memoria.
     */
    private MemoriaModel memoriaSistema;

    /**
     * Objeto de la clase AlmacenamientoModel, que representa el contenido del
     * almacenamiento.
     */
    private AlmacenamientoModel almacenamientoSistema;

    /**
     * Tabla que contiene la memoria.
     */
    @FXML
    private TableView<Map.Entry<Integer, String>> tablaMemoria;

    /**
     * Columna que contiene las posiciones de la memoria.
     */
    @FXML
    private TableColumn<Map.Entry<Integer, String>, Integer> columnaPosMemoria;

    /**
     * Columna que contiene el contenido de la memoria.
     */
    @FXML
    private TableColumn<Map.Entry<Integer, String>, String> columnaValorMemoria;

    /**
     * Tabla que contiene las posiciones del almacenamiento.
     */
    @FXML
    private TableView<Map.Entry<Integer, String>> tablaAlmacenamiento;

    /**
     * Columna que contiene las posiciones del almacenamiento.
     */
    @FXML
    private TableColumn<Map.Entry<Integer, String>, Integer> columnaPosAlmacenamiento;

    /**
     * Columna que contiene los el contenido del almacenamiento.
     */
    @FXML
    private TableColumn<Map.Entry<Integer, String>, String> columnaValorAlmacenamiento;

    @FXML
    private Button automatico;

    @FXML
    private Button pasoApaso;

    // ============= Constructores =============================================
    /**
     * Inicializador del controlador, establece los atributos con valores por
     * defecto.
     */
    @Override

    public void initialize(URL url, ResourceBundle rb) {
        //TODO
    }

    // ============= Metodos get y set =========================================
    /**
     * Obtiene la memoria principal.
     *
     * @return Memoria principal.
     */
    public MemoriaModel obtenerMemoriaPrincipal() {
        return memoriaSistema;
    }

    /**
     * Establece la memoria principal.
     *
     * @param memoriaPrincipal Memoria principal a establecer.
     */
    public void establecerMemoria(MemoriaModel memoriaPrincipal) {
        this.memoriaSistema = memoriaPrincipal;
    }

    /**
     * Obtiene el almacenamiento principal.
     *
     * @return El almacenamiento principal.
     */
    public AlmacenamientoModel obtenerAlmacenamientoPrincipal() {
        return almacenamientoSistema;
    }

    /**
     * Establece el almacenamiento principal.
     *
     * @param almacenamientoPrincipal Almacenamiento principal a establecer.
     */
    public void establecerAlmacenamiento(AlmacenamientoModel almacenamientoPrincipal) {
        this.almacenamientoSistema = almacenamientoPrincipal;
    }

    // ============= Metodos ===================================================
    /**
     * Establece la tabla de memoria en la interfaz grafica.
     */
    public void establecerTablaMemoria() {

        //Configura las direcciones de la memoria para las columnas.
        columnaPosMemoria.setCellValueFactory(memoria -> {
            int direccion = memoria.getValue().getKey();
            //Esta clase observable de javafx permite el seguimiento de cambios
            //en la columna
            SimpleIntegerProperty entero = new SimpleIntegerProperty(direccion);
            return entero.asObject();
        });

        //Configura el contenido de la memoria para las columnas.
        columnaValorMemoria.setCellValueFactory(memoria -> {
            String contenido = memoria.getValue().getValue();
            //Esta clase observable de javafx permite el seguimiento de cambios
            //en la columna
            SimpleStringProperty texto = new SimpleStringProperty(contenido);
            return texto;
        });

        //Asigna los contenido a la tabla
        tablaMemoria.getItems().setAll(
                memoriaSistema.obtenerMemoriaPrincipal().entrySet());
    }

    /**
     * Establece la tabla de almacenamiento en la interfaz grafica.
     */
    public void establecerTablaAlmacenamiento() {

        //Configura las direcciones del almacenamiento para las columnas.
        columnaPosAlmacenamiento.setCellValueFactory(memoria -> {
            int direccion = memoria.getValue().getKey();
            //Esta clase observable de javafx permite el seguimiento de cambios
            //en la columna
            SimpleIntegerProperty entero = new SimpleIntegerProperty(direccion);
            return entero.asObject();
        });

        columnaValorAlmacenamiento.setCellValueFactory(contenido
                -> new SimpleStringProperty(contenido.getValue().getValue()));

        //Asigna los contenido a la tabla
        tablaAlmacenamiento.getItems().setAll(almacenamientoSistema.obtenerAlmacenamientoPrincipal().entrySet());
    }

    @FXML
    public void automatico(ActionEvent event) {
        //TODO
    }

    @FXML
    public void pasoApaso(ActionEvent event) {
        //TODO
    }

}
