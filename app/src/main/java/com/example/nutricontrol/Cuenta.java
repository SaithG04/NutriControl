package com.example.nutricontrol;

public class Cuenta {
    private int id;
    private String user;
    private String password;
    private Usuario cliente;

    public Cuenta(int id, String user, String password, Usuario cliente) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }
}