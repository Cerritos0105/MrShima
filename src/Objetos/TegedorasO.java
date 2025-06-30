
package Objetos;
public class TegedorasO {
    private int id;
    private String modelo;
    private String galga;
    private double precio;
    private String serie;
    private String sucursal;
    private boolean estado;
    private double credito;
    private String propietario;
    private int cabezas;
    private int anio;
    
    public TegedorasO(int id, String modelo, String galga , double precio, String serie, String sucursal, double credito, String propietario, int cabezas, int anio){
        this.id = id;
        this.modelo = modelo;
        this.galga = galga;
        this.precio = precio;
        this.serie = serie;
        this.sucursal = sucursal;
        this.credito = credito; 
        this.propietario = propietario;
        this.cabezas = cabezas;
        this.anio = anio;
    }

    public TegedorasO() {
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getGalga() {
        return galga;
    }

    public void setGalga(String galga) {
        this.galga = galga;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getSucursal() {
        return sucursal;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public int getCabezas() {
        return cabezas;
    }

    public void setCabezas(int cabezas) {
        this.cabezas = cabezas;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
}
