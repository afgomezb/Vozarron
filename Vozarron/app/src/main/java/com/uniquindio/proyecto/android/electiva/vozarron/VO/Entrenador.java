package com.uniquindio.proyecto.android.electiva.vozarron.VO;

/**
 * Clase para represetar a un entrenador del Vozarron
 *
 * @author Valentina Correa
 * @author Andres Felipe Gomez
 * @version 1.0
 */
public class Entrenador {

    /**
     * Codigo identificador del entrenador
     */
    private String id;

    /**
     * Nombre del entrenador
     */
    private String nombre;

    /**
     * Genero del entrenador
     */
    private String genero;

    /**
     * Historial del entrenador
     */
    private String historial;

    /**
     * Foto del entrenador
     */
    private int foto;

    /**
     * Metodo constructor de Participante vacio
     */
    public Entrenador() {
    }

    /**
     * Metodo constructor de la clase entrenador
     *
     * @param id codigo del entrenador
     * @param nombre nombre del entrenador
     * @param genero genero del entrenador
     * @param historial historial del entrenador
     * @param foto foto del entrenador
     */
    public Entrenador(String id, String nombre, String genero, String historial, int foto) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.historial = historial;
        this.foto = foto;
    }

    /**
     * Metodo que retorna el id del entrenador
     * @return valor de la variable
     */
    public String getId() {
        return id;
    }

    /**
     * Metodo que modifica el valor de la variable ID
     * @param id nuevo valor de la variable
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Metodo que retorna el nombre del entrenador
     * @return valor de la variable
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo que modifica el valor de la variable nombre
     * @param nombre nuevo valor de la variable
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo que retorna el genero del entrenador
     * @return valor de la variable
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Metodo que modifica el valor de la variable genero
     * @param genero nuevo valor de la variable
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Metodo que retorna el historial del entrenador
     * @return valor de la variable
     */
    public String getHistorial() {
        return historial;
    }

    /**
     * Metodo que modifica el valor de la variable historial
     * @param historial nuevo valor de la variable
     */
    public void setHistorial(String historial) {
        this.historial = historial;
    }

    /**
     * Metodo que retorna el foto del entrenador
     * @return valor de la variable
     */
    public int getFoto() {
        return foto;
    }

    /**
     * Metodo que modifica el valor de la variable foto
     * @param foto nuevo valor de la variable
     */
    public void setFoto(int foto) {
        this.foto = foto;
    }
}

