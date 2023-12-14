
package com.mycompany.main_examen_nikens_pierre_louis;


// Clase modelo

public class Mecanico {
    private int idMecanico;
    private String nombre;
    private int edad;
    private String domicilio;
    private String titulo;
    private String especialidad;
    private double sueldoBase;
    private double gratificacionTitulo;
    private double sueldoTotal;

    public Mecanico(int idMecanico, String nombre, int edad, String domicilio, String titulo, String especialidad, double sueldoBase, double gratificacionTitulo) {
        this.idMecanico = idMecanico;
        this.nombre = nombre;
        this.edad = edad;
        this.domicilio = domicilio;
        this.titulo = titulo;
        this.especialidad = especialidad;
        this.sueldoBase = sueldoBase;
        this.gratificacionTitulo = gratificacionTitulo;
        this.sueldoTotal = sueldoBase + gratificacionTitulo;
    }

    
    
    // Getters y setters para cada atributo...

    public int getIdMecanico() {
        return idMecanico;
    }

    public void setIdMecanico(int idMecanico) {
        this.idMecanico = idMecanico;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public double getSueldoBase() {
        return sueldoBase;
    }

    public void setSueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
    }

    public double getGratificacionTitulo() {
        return gratificacionTitulo;
    }

    public void setGratificacionTitulo(double gratificacionTitulo) {
        this.gratificacionTitulo = gratificacionTitulo;
    }

    public double getSueldoTotal() {
        return sueldoTotal;
    }

    public void setSueldoTotal(double sueldoTotal) {
        this.sueldoTotal = sueldoTotal;
    }
    
    
    // Método para calcular sueldo total...
    
    
    public double getsueldoBase() {
        return sueldoBase;
    }

    public void setsueldoBase(double sueldoBase) {
        this.sueldoBase = sueldoBase;
        calcularSueldoTotal(); // Recalcular el sueldo total cuando el sueldo base cambia
    }

    public double getgratificacionTitulo() {
        return gratificacionTitulo;
    }

    public void setgratificacionTitulo(double gratificacionTitulo) {
        this.gratificacionTitulo = gratificacionTitulo;
        calcularSueldoTotal(); // Recalcular el sueldo total cuando la gratificación cambia
    }

    public double getsueldoTotal() {
        return sueldoTotal;
    }

    // Método para calcular el sueldo total
    void calcularSueldoTotal() {
        sueldoTotal = sueldoBase + gratificacionTitulo;
    }

    
}
