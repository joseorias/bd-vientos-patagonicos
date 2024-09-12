package tp.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {

    private int id;
    private String name;
    private String lastname;
    private String dni;
    private String email;

    public Client(String name, String lastname, String dni, String email) throws IllegalAccessException {
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
        if (dni == null || dni =="") {
            throw new IllegalAccessException("Error: Debe ingresar un DNI valido. ");
        } else {
            // Validar unicidad del dni
            this.dni = dni;
        }
        if (!validate_email(email)) {
            throw new IllegalAccessException("Error: Debe ingresar un email valido. ");
        } else {
            this.email = email;
        }
    }

    public Client(int id, String name, String lastname, String dni, String email) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.dni = dni;
        this.email = email;
    }

    @SuppressWarnings("unused")
    private int getId() {
        return id;
    }

    @SuppressWarnings("unused")
    private void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    @SuppressWarnings("unused")
    private void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    @SuppressWarnings("unused")
    private void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDni() {
        return dni;
    }

    @SuppressWarnings("unused")
    private void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    @SuppressWarnings("unused")
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
