/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clases;

/**
 *
 * @author carlo
 */
public class Cliente {

  int idCliente;
    String rut;
    String nombre;
    String apellido;
    String correo;
    String direccion;
    String telefono;
    String estado;  // Ahora estado es un String

    public Cliente() {
    }

    public Cliente(int idCliente, String rut, String nombre, String apellido, String correo, String direccion, String telefono, String estado) {
        this.idCliente = idCliente;
        this.rut = rut;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;  // Ahora acepta un String
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {  // cambiamos el tipo de retorno a String
        return estado;
    }

    public void setEstado(String estado) {  // cambiamos el tipo de parámetro a String
        this.estado = estado;
    }

}
