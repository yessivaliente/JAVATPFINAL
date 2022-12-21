package com.example.javatpfinal;

public class empleadosjava {
    private int id_persona;
    private String Nombre;
    private String Apellido;
    private int Edad;

    public empleadosjava(int idPersona, String nombre, String apellido, int edad) {
    }

    public empleadosjava() {

    }

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setApellido(String apellido) {
        Apellido = apellido;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public int getEdad() {
        return Edad;
    }
}