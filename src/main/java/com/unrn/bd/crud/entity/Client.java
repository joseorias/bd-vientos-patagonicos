package com.unrn.bd.crud.entity;

public class Client {

    private int id;
    private String name;
    private String lastname;
    private int dni;
    private String email;

    public Client(String name, String lastname, int dni, String email) {
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.email = email;
    }

    public Client(int id, String name, String lastname, int dni, String email) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.email = email;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
