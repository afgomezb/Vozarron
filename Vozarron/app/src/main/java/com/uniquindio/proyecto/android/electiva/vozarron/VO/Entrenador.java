package com.uniquindio.proyecto.android.electiva.vozarron.VO;

/**
 * Clase para represetar a un entrenador del Vozarron
 *
 * @author Valentina Correa
 * @author Andres Felipe Gomez
 * @version 1.0
 */
public class Entrenador {

    private String id;
    private String nombre;
    private String genero;
    private String historial;

    public Entrenador() {
    }

    public Entrenador(String id, String nombre, String genero, String historial) {
        this.id = id;
        this.nombre = nombre;
        this.genero = genero;
        this.historial = historial;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getHistorial() {
        return historial;
    }

    public void setHistorial(String historial) {
        this.historial = historial;
    }
}

