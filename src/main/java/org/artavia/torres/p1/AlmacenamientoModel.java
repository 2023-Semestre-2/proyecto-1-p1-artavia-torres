package org.artavia.torres.p1;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que representa el almacenamiento principal del programa.
 */
public class AlmacenamientoModel {

    // ============= Parametros ================================================
    /**
     * HashMap que representa el almacenamiento del sistema, se utiliza este
     * tipo de dato para tomar la key como direccion y el value para su
     * contenido.
     */
    private Map<Integer, String> almacenamientoPrincipal;

    /**
     * Numero que representa la cantidad de espacios reservados en disco para el
     * sistema fuera del acceso del usuario, se usara un 40% de la memoria.
     */
    private int reservadoParaSistema;

    // ============= Constructores =============================================
    /**
     * Constructor por defecto que inicializa el disco con 512 espacios con su
     * contenido vacio
     */
    public AlmacenamientoModel() {
        this.almacenamientoPrincipal = new HashMap<>();
        for (int i = 0; i < 512; i++) {
            this.almacenamientoPrincipal.put(i, " ");
        }
        this.reservadoParaSistema = 204;
    }

    /**
     * Constructor que inicializa el disco con la cantidad de espacios que
     * reciba por medio de un parametro dentro del rango 512-1024
     */
    public AlmacenamientoModel(int tamanoAlmacenamiento) {
        if (validarTamanoAlmacenamiento(tamanoAlmacenamiento)) {
            this.almacenamientoPrincipal = new HashMap<>();
            for (int i = 0; i < tamanoAlmacenamiento; i++) {
                this.almacenamientoPrincipal.put(i, " ");
            }
            this.reservadoParaSistema = (int) (tamanoAlmacenamiento * 0.4);
        }
    }

    // ============= Metodos get y set =========================================
    /**
     * Se obtiene el almacenamiento.
     *
     * @return Almacenamiento principal.
     */
    public Map<Integer, String> obtenerAlmacenamientoPrincipal() {
        return almacenamientoPrincipal;
    }

    /**
     * Se establece el almacenamiento.
     *
     * @param almacenamientoPrincipal Almacenamiento principal del sistema.
     */
    public void establecerAlmacenamientoPrincipal(Map<Integer, String> almacenamientoPrincipal) {
        this.almacenamientoPrincipal = almacenamientoPrincipal;
    }

    /**
     * Se obtiene la cantidad de espacios reservados de almacenamiento para el
     * sistema.
     *
     * @return Numero de espacios reservados.
     */
    public int obtenertReservadoParaSistema() {
        return reservadoParaSistema;
    }

    /**
     * Se establecen los espacios reservados de almacenamiento para el sistema.
     *
     * @param reservadoParaSistema Espacios reservados para el sistema.
     */
    public void establecerReservadoParaSistema(int reservadoParaSistema) {
        this.reservadoParaSistema = reservadoParaSistema;
    }

    // ============= Metodos ===================================================
    /**
     * Metodo que valida que el numero del tamaño del disco ingresado este
     * dentro del rango 512-1024 .
     *
     * @param tamanoAlmacenamiento Tamaño deseado del disco.
     * @return Retorna true en caso de ser el rango aceptado, false en otro
     * caso.
     */
    private boolean validarTamanoAlmacenamiento(int tamanoAlmacenamiento) {

        if (tamanoAlmacenamiento >= 512 && tamanoAlmacenamiento <= 1024) {
            return true;
        } else {
            return false;
        }
    }

}
