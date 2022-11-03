package com.example.nutricontrol;

public class Usuario {

    private String nombres;
    private String apellidos;
    private String sexo;
    private String fechaNacimiento;
    private short altura;
    private double peso;

    public Usuario(String nombres, String apellidos, String sexo, String fechaNacimiento, short altura, double peso){
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.altura = altura;
        this.peso = peso;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }
    public String getNombres() {
        return nombres;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    public String getApellidos() {
        return apellidos;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getSexo() {
        return sexo;
    }
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }
    public void setAltura(short altura) {
        this.altura = altura;
    }
    public short getAltura() {
        return altura;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public double getPeso() {
        return peso;
    }
}