package com.uniquindio.proyecto.android.electiva.vozarron.VO;

/**
 * Clase para represetar a un participante del Vozarron
 *
 * @author Valentina Correa
 * @author Andres Felipe Gomez
 * @version 1.0
 */
public class Participante {

    /**
     * Nombre del participante
     */
    private String nombre;

    /**
     * Edad del participante
     */
    private int Edad;

    /**
     * Entrenador del participante
     */
    private Entrenador entrenador;

    /**
     * Rol del participante dentro de la universidad
     */
    private String rol;

    /**
     * Foto del participante
     */
    private String foto;

    /**
     * Url del video en YOU TUBE con que participara en el concurso el Vozarron
     */
    private String urlVideo;

    /**
     * Metodo constructor de Participante
     *
     * @param nombre     Nombre del participante
     * @param edad       Edad del participante
     * @param entrenador Entrenador del participante
     * @param rol        Rol del participante dentro de la universidad
     * @param foto       Foto del participante
     * @param urlVideo   Url del video en YOU TUBE con que participara en el concurso el Vozarron
     */
    public Participante(String nombre, int edad, Entrenador entrenador, String rol, String foto, String urlVideo) {
        this.nombre = nombre;
        Edad = edad;
        this.entrenador = entrenador;
        this.rol = rol;
        this.foto = foto;
        this.urlVideo = urlVideo;
    }

    /**
     * Metodo para acceder al valor de la variable nombre
     * @return valor de la variable nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo modificador del contenido de la variable nombre
     * @param nombre nuevo contenido de la variable
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Metodo para acceder al valor de la variable edad
     * @return valor de la variable edad
     */
    public int getEdad() {
        return Edad;
    }

    /**
     * Metodo modificador del contenido de la variable edad
     * @param edad nuevo contenido de la variable
     */
    public void setEdad(int edad) {
        Edad = edad;
    }

    /**
     * Metodo para acceder al valor de la variable entrenador
     * @return valor de la variable entrenador
     */
    public Entrenador getEntrenador() {
        return entrenador;
    }

    /**
     * Metodo modificador del contenido de la variable entrenador
     * @param entrenador nuevo contenido de la variable
     */
    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    /**
     * Metodo para acceder al valor de la variable rol
     * @return valor de la variable rol
     */
    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    /**
     * Metodo para acceder al valor de la variable foto
     * @return valor de la variable foto
     */
    public String getFoto() {
        return foto;
    }

    /**
     * Metodo modificador del contenido de la variable foto
     * @param foto nuevo contenido de la variable
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * Metodo para acceder al valor de la variable urlVideo
     * @return valor de la variable urlVideo
     */
    public String getUrlVideo() {
        return urlVideo;
    }

    /**
     * Metodo modificador del contenido de la variable urlVideo
     * @param urlVideo nuevo contenido de la variable
     */
    public void setUrlVideo(String urlVideo) {
        this.urlVideo = urlVideo;
    }
}
