package org.artavia.torres.p1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Clase que representa la memoria principal del programa.
 */
public class MemoriaModel {

    // ============= Parametros ================================================
    /**
     * HashMap que representa la memoria principal del programa, se utiliza este
     * tipo de dato para tomar la key como direccion y el direccion para su
     * direccion.
     */
    private Map<Integer, String> memoriaPrincipal;

    /**
     * Numero que representa la cantidad de espacios reservados en memoria para
     * el sistema fuera del acceso del usuario, se usara un 40% de la memoria.
     */
    private int reservadoParaSistema;

    // ============= Constructores =============================================
    /**
     * Constructor por defecto que inicializa la memoria con 256 espacios con su
     * direccion vacio
     */
    public MemoriaModel() {
        this.memoriaPrincipal = new HashMap<>();
        for (int i = 0; i < 256; i++) {
            this.memoriaPrincipal.put(i, " ");
        }
        this.reservadoParaSistema = 100;
    }

    /**
     * Constructor que inicializa la memoria con la cantidad de espacios que
     * reciba por medio de un parametro dentro del rango 256-1024
     */
    public MemoriaModel(int tamanoMemoria) {
        if (validarTamanoMemoria(tamanoMemoria)) {
            this.memoriaPrincipal = new HashMap<>();
            for (int i = 0; i < tamanoMemoria; i++) {
                this.memoriaPrincipal.put(i, " ");
            }
            this.reservadoParaSistema = (int) (tamanoMemoria * 0.4);
        }
    }

    // ============= Metodos get y set =========================================
    /**
     * Se obtiene la memoria.
     *
     * @return Memoria principal.
     */
    public Map<Integer, String> obtenerMemoria() {
        return memoriaPrincipal;
    }

    /**
     * Se establece la memoria.
     *
     * @param memoriaPrincipal Memoria principal del sistema.
     */
    public void establecerMemoria(Map<Integer, String> memoriaPrincipal) {
        this.memoriaPrincipal = memoriaPrincipal;
    }

    /**
     * Se obtiene la cantidad de espacios reservados en memoria para el sistema.
     *
     * @return Numero de espacios reservados.
     */
    public int obtenerReservadoParaSistema() {
        return reservadoParaSistema;
    }

    /**
     * Se establecen los espacios reservados de memoria para el sistema.
     *
     * @param reservadoParaSistema Espacios reservados para el sistema.
     */
    public void establecerReservadoParaSistema(int reservadoParaSistema) {
        this.reservadoParaSistema = reservadoParaSistema;
    }

    // ============= Metodos ===================================================
    /**
     * Metodo que valida que el numero del tamaño de la memoria ingresado este
     * dentro del rango 256-1024 .
     *
     * @param tamanoMemoria Tamaño deseado de la memoria.
     * @return Retorna true en caso de ser el rango aceptado, false en otro
     * caso.
     */
    private boolean validarTamanoMemoria(int tamanoMemoria) {

        if (tamanoMemoria >= 256 && tamanoMemoria <= 1024) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Agrega una lista de instrucciones a la memoria.
     *
     * @param instrucciones Lista de instrucciones de un archivo .asm.
     */
    public void agregarContenidoAsm(List<String> instrucciones) {

        //Primero se determina si existe espacio en memoria para las instrucciones
        int direccionesVacias = 0;

        for (Integer direccion : memoriaPrincipal.keySet()) {
            if (memoriaPrincipal.get(direccion).equals(" ")
                    && direccion >= this.reservadoParaSistema) {
                direccionesVacias++;
            }
        }

        //Si no existe suficiente espacio, se imprimer error
        if (direccionesVacias < instrucciones.size()) {
            System.out.println("Espacio en memoria insuficiente para el archivo");

            //En caso contrario, se agregan las instrucciones
        } else {
            for (String instruccion : instrucciones) {
                agregarContenidoAsmAux(instruccion, this.memoriaPrincipal,
                        instrucciones.size());
            }
        }
    }

    /**
     * Agrega una instruccion a la memoria.
     *
     * @param instruccion.
     * @param memoria.
     * @param cantidadInstrucciones.
     */
    private void agregarContenidoAsmAux(
            String instruccion, Map<Integer, String> memoria,
            int cantidadInstrucciones) {

        // Booleano para verificar si la memoria esta vacia
        boolean memoriaVacia = true;

        for (String contenido : memoria.values()) {
            if (!contenido.equals(" ")) {
                memoriaVacia = false;
                break;
            }
        }

        String contenidoUltimaDireccion = " ";

        //Si la memoria no esta vacia, asigna el direccion a la memoria despues de
        //otro direccion existente
        if (!memoriaVacia) {
            for (Integer direccion : memoria.keySet()) {
                if (memoria.get(direccion).equals(" ")
                        && direccion > this.reservadoParaSistema
                        && !contenidoUltimaDireccion.equals(" ")) {
                    memoria.put(direccion, instruccion);
                    break;
                }
                contenidoUltimaDireccion = memoria.get(direccion);
            }
            //Si la memoria esta vacia, se asigna la primera direccion aleatoria de
            //memoria
        } else {
            asignarPrimeraDireccion(instruccion, memoria, cantidadInstrucciones);
        }
    }

    /**
     * Asigna la primera instruccion a una direccion aleatoria valida en
     * memoria.
     *
     * @param instruccion.
     * @param memoria.
     * @param cantidadInstrucciones.
     */
    private void asignarPrimeraDireccion(String instruccion,
            Map<Integer, String> memoria, int cantidadInstrucciones) {

        Random aleatorio = new Random();
        int direccionMin = this.reservadoParaSistema;
        int direccionMax = this.memoriaPrincipal.size() - cantidadInstrucciones;

        int direccionAleatoria = aleatorio.nextInt(direccionMax - direccionMin + 1)
                + direccionMin;
        memoria.put(direccionAleatoria, instruccion);

    }

    /**
     * Cambia el contenido de una direccion de memoria a " ".
     *
     * @param direccionContenido Direccion en memoria para borrar su contenido.
     */
    public void eliminarContenido(Integer direccionContenido) {
        for (Integer direccion : memoriaPrincipal.keySet()) {
            if (direccion == direccionContenido) {
                memoriaPrincipal.put(direccion, " ");
            }
        }
    }

    /**
     * Imprime el contenido de la memoria en terminal.
     */
    private void imprimirMemoriaTerminal() {
        for (Integer direccion : memoriaPrincipal.keySet()) {
            System.out.println(direccion + " | "
                    + memoriaPrincipal.get(direccion));
        }
    }
}
