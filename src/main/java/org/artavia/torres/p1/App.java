package org.artavia.torres.p1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * Aplicacion de javafx que simula el comportamiento de una minicomputadora.
 */
public class App extends Application {

    // ============= Parametros ================================================
    /**
     * Escena principal de la aplicacion.
     */
    private static Scene escenaPrincipal;

    // ============= Constructores =============================================
    /**
     * Metodo que ejecuta la aplicacion javafx.
     *
     * @param ventanaPrincipal Stage inicial de la aplicacion.
     */
    @Override
    public void start(Stage ventanaPrincipal) throws IOException {

        /**
         * Se crea la escena con el archivo de configuracion inicial
         */
        escenaPrincipal = new Scene(cargarFXML("ConfiguracionInicial"),
                610, 410);

        /**
         * Se establece un titulo para la aplicacion
         */
        ventanaPrincipal.
                setTitle("Proyecto 01 SO - Jose Artavia - Dylan Torres");

        ventanaPrincipal.setScene(escenaPrincipal);
        ventanaPrincipal.show();
        ventanaPrincipal.centerOnScreen();

    }

    // ============= Metodos ===================================================
    /**
     * Metodo que se encarga de cargar un archivo fxml.
     *
     * @param fxml Nombre de archivo fxml sin la extension.
     * @return Raiz para una nueva escena
     */
    private static Parent cargarFXML(String fxml) throws IOException {
        FXMLLoader cargadorFxml = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return cargadorFxml.load();
    }

    /**
     * Main de la clase, se ejecuta la aplicacion
     */
    public static void main(String[] args) {
        launch();
    }
}
