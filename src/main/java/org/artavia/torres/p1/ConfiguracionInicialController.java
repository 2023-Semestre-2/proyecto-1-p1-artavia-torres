package org.artavia.torres.p1;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Clase controlador que se encarga de la configuracion inicial del tamano de la
 * memoria inicial y el almacenamiento inicial.
 */
public class ConfiguracionInicialController implements Initializable {

    // ============= Parametros ================================================
    /**
     * Objeto de la clase MemoriaModel, que representa el contenido de la
     * memoria.
     */
    private MemoriaModel memoriaInicial;

    /**
     * Objeto de la clase AlmacenamientoModel, que representa el contenido del
     * almacenamiento.
     */
    private AlmacenamientoModel almacenamientoInicial;

    /**
     * Campo de texto para recibir la entrada de memoria del usuario
     */
    @FXML
    private TextField campoTextoMemoria;

    /**
     * Campo de texto para recibir la entrada de almacenamiento del usuario
     */
    @FXML
    private TextField campoTextoAlmacenamiento;

    // ============= Constructores =============================================
    /**
     * Inicializador del controlador, establece los atributos con valores por
     * defecto.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.memoriaInicial = new MemoriaModel();
        this.almacenamientoInicial = new AlmacenamientoModel();
        campoTextoMemoria.setText("256");
        campoTextoAlmacenamiento.setText("512");
    }

    // ============= Metodos get y set =========================================
    /**
     * Obtiene la memoria inicial.
     *
     * @return El modelo de memoria inicial.
     */
    public MemoriaModel obtenerMemoriaInicial() {
        return memoriaInicial;
    }

    /**
     * Establece la memoria inicial.
     *
     * @param memoriaInicial Memoria inicial a establecer.
     */
    public void establecerMemoriaInicial(MemoriaModel memoriaInicial) {
        this.memoriaInicial = memoriaInicial;
    }

    /**
     * Obtiene el almacenamiento inicial.
     *
     * @return El almacenamiento inicial.
     */
    public AlmacenamientoModel obtenerAlmacenamientoInicial() {
        return almacenamientoInicial;
    }

    /**
     * Establece el almacenamiento inicial.
     *
     * @param almacenamientoInicial Almacenamiento inicial a establecer.
     */
    public void establecerAlmacenamientoInicial(AlmacenamientoModel almacenamientoInicial) {
        this.almacenamientoInicial = almacenamientoInicial;
    }

    /**
     * Obtiene el campo de texto de memoria.
     *
     * @return El campo de texto de memoria.
     */
    public TextField obtenerCampoTextoMemoria() {
        return campoTextoMemoria;
    }

    /**
     * Establece el campo de texto de memoria.
     *
     * @param campoTextoMemoria El campo de texto de memoria a establecer.
     */
    public void establecerCampoTextoMemoria(TextField campoTextoMemoria) {
        this.campoTextoMemoria = campoTextoMemoria;
    }

    /**
     * Obtiene el campo de texto de almacenamiento.
     *
     * @return El campo de texto de almacenamiento.
     */
    public TextField obtenerCampoTextoAlmacenamiento() {
        return campoTextoAlmacenamiento;
    }

    /**
     * Establece el campo de texto de almacenamiento.
     *
     * @param campoTextoAlmacenamiento El campo de texto de almacenamiento a
     * establecer.
     */
    public void establecerCampoTextoAlmacenamiento(TextField campoTextoAlmacenamiento) {
        this.campoTextoAlmacenamiento = campoTextoAlmacenamiento;
    }

    // ============= Metodos ===================================================
    /**
     * Metodo que se ejecuta cuando se presiona el boton ingresar de la memoria,
     * verifica que la entrada sea valida, mostrando mensajes para cuando se
     * agrega o no.
     *
     * @param event Presionar el boton ingresar de memoria.
     * @return Retorna mensajes de error o de confirmacion.
     */
    @FXML
    private void ingresarMemoria(ActionEvent event) {

        String entradaUsuario = campoTextoMemoria.getText();
        try {
            int memoriaIngresada = Integer.parseInt(entradaUsuario);
            if (memoriaIngresada >= 256 && memoriaIngresada <= 1024) {
                this.memoriaInicial = new MemoriaModel(memoriaIngresada);
                mostrarMensajeGui("Tamaño de memoria " + memoriaIngresada
                        + " ingresado correctamente");
            } else {
                mostrarMensajeGui("Error: "
                        + "El tamaño de memoria debe estar entre 256 y 1024.");
            }
        } catch (NumberFormatException e) {
            mostrarMensajeGui("Error: "
                    + "Solo se aceptan numeros, ingrese uno entre 256 y 1024.");
        }
    }

    /**
     * Metodo que se ejecuta cuando se presiona el boton ingresar del
     * almacenamiento, verifica que la entrada sea valida, mostrando mensajes
     * para cuando se agrega o no.
     *
     * @param event Presionar el boton ingresar de almacenamiento.
     * @return Retorna mensajes de error o de confirmacion.
     */
    @FXML
    private void ingresarAlmacenamiento(ActionEvent event) {

        String entradaUsuario = campoTextoAlmacenamiento.getText();
        try {
            int almacenamientoIngresado = Integer.parseInt(entradaUsuario);
            if (almacenamientoIngresado >= 512 && almacenamientoIngresado <= 1024) {
                this.almacenamientoInicial = new AlmacenamientoModel(almacenamientoIngresado);
                mostrarMensajeGui("Tamaño de almacenamiento " + almacenamientoIngresado
                        + " ingresado correctamente");
            } else {
                mostrarMensajeGui("Error: "
                        + "El tamaño de almacenamiento debe estar entre 512 y 1024.");
            }
        } catch (NumberFormatException e) {
            mostrarMensajeGui("Error: "
                    + "Solo se aceptan numeros, ingrese uno entre 512 y 1024.");
        }
    }

    /**
     * Metodo que se ejecuta cuando se presiona el boton siguiente, obtiene los
     * valores de memoria y almacenamiento para crear una ventanaPrincipal con
     * esos datos y cambia la vista a esa escena.
     *
     * @param event Presionar el boton siguiente.
     * @throws java.io.IOException
     */
    @FXML
    public void siguiente(ActionEvent event) throws IOException {
        FXMLLoader vistaVentanaPrincipal
                = new FXMLLoader(getClass().getResource("VentanaPrincipal.fxml"));
        Parent raizNueva = vistaVentanaPrincipal.load();
        VentanaPrincipalController ventanaPrincipal = vistaVentanaPrincipal.getController();

        //Pasa las instancias de memoria y almacenamiento a ventanaPrincipal.
        ventanaPrincipal.establecerMemoria(this.memoriaInicial);
        ventanaPrincipal.establecerTablaMemoria();

        ventanaPrincipal.establecerAlmacenamiento(this.almacenamientoInicial);
        ventanaPrincipal.establecerTablaAlmacenamiento();

        //Actualiza la ventana y la escena de javafx
        Node nodoNuevo = (Node) event.getSource();
        Stage ventanaNueva = (Stage) nodoNuevo.getScene().getWindow();
        Scene escenaNueva = new Scene(raizNueva, 1050, 700);
        ventanaNueva.setScene(escenaNueva);
        ventanaNueva.show();
        ventanaNueva.centerOnScreen();
    }

    /**
     * Metodo que muestra en pantalla mensajes usando javafx.
     *
     * @param event Presionar el boton salir.
     */
    private void mostrarMensajeGui(String mensaje) {
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle("Mensaje");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    /**
     * Metodo que se ejecuta cuando se presiona el boton salir, termina el
     * programa.
     *
     * @param event Presionar el boton salir.
     */
    @FXML
    private void salir(ActionEvent event) {
        System.exit(0);
    }

}
