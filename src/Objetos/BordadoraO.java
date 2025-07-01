/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objetos;

/**
 *
 * @author Think
 */

public class BordadoraO {
    private int id;
    private double precio;
    private double credito;
    private String accesorios;
    private int anio;
    private String area;
    private int colores;
    private int cabezas;
    private String marca;
    private String numeroSerie;
    private boolean estado;
    private double saldo;
    private String propietario;

    // Constructor
    public BordadoraO(int id, double precio, double credito, String accesorios, int anio, String area,
                      int colores, int cabezas, String marca, String numeroSerie, boolean estado,
                      double saldo, String propietario) {
        this.id = id;
        this.precio = precio;
        this.credito = credito;
        this.accesorios = accesorios;
        this.anio = anio;
        this.area = area;
        this.colores = colores;
        this.cabezas = cabezas;
        this.marca = marca;
        this.numeroSerie = numeroSerie;
        this.estado = estado;
        this.saldo = saldo;
        this.propietario = propietario;
    }

    // Getters
    public int getId() {
        return id;
    }

    public double getPrecio() {
        return precio;
    }

    public double getCredito() {
        return credito;
    }

    public String getAccesorios() {
        return accesorios;
    }

    public int getAnio() {
        return anio;
    }

    public String getArea() {
        return area;
    }

    public int getColores() {
        return colores;
    }

    public int getCabezas() {
        return cabezas;
    }

    public String getMarca() {
        return marca;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public boolean isEstado() {
        return estado;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getPropietario() {
        return propietario;
    }

    // Setters (opcionales si necesitas modificar campos)
    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public void setAccesorios(String accesorios) {
        this.accesorios = accesorios;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public void setColores(int colores) {
        this.colores = colores;
    }

    public void setCabezas(int cabezas) {
        this.cabezas = cabezas;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }
}

