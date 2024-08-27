package com.unrn.bd.crud.entity;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {

    private int id;
    private String name;
    private String lastname;
    private int dni;
    private String email;

    public Client(String name, String lastname, int dni, String email) {
        if (name == null || name == "") {
            throw new IllegalAccessException("Error: Debe ingresar un nombre. ");
        } else {
            this.name = name;
        }
        if (lastname == null || lastname == "") {
            throw new IllegalAccessException("Error: Debe ingresar un apellido. ");
        } else {
            this.lastname = lastname;
        }
        if (dni == 0) {
            throw new IllegalAccessException("Error: Debe ingresar un DNI valido. ");
        } else {
            this.dni = dni;
        }
        if (!validate_email(email)) {
            throw new IllegalAccessException("Error: Debe ingresar un email valido. ");
        } else {
            this.email = email;
        }
    }

    public Client(int id, String name, String lastname, int dni, String email) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.email = email;
    }

    
    private int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    private String getLastname() {
        return lastname;
    }

    private void setLastname(String lastname) {
        this.lastname = lastname;
    }

    private int getDni() {
        return dni;
    }

    private void setDni(int dni) {
        this.dni = dni;
    }

    private String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    private static boolean validate_email(String email){
        String email_pattern = "^[\\w._%+-]+@[\\w.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(email_pattern);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches(); 
    }
}
