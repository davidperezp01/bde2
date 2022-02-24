package com.example.bde2.config;

public class Sesion {
    private int idUsuario;
    private static Sesion instance;

    private Sesion(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public static void crearSesion(int idUsuario) {
        if (instance == null) {
            instance = new Sesion(idUsuario);
        }
    }

    public static Sesion getSesion() {
        return instance;
    }

    public int getIdUsuario() {
        return idUsuario;
    }
}