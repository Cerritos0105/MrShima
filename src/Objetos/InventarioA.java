package Objetos;
public class InventarioA {
    private int ID;
    private String nomabre;
    private double precio;
    private double credito;
    private String maquias;
    private int galta_men;
    private int gaslga_may;
    private int nivel;
    private int cantidad;
    private String tamano;

    public InventarioA(int ID, String nomabre, double precio, double credito, String maquias, int galta_men, int gaslga_may, int nivel, int cantidad, String tamano) {
        this.ID = ID;
        this.nomabre = nomabre;
        this.precio = precio;
        this.credito = credito;
        this.maquias = maquias;
        this.galta_men = galta_men;
        this.gaslga_may = gaslga_may;
        this.nivel = nivel;
        this.cantidad = cantidad;
        this.tamano = tamano;
    }

    public InventarioA() {
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNomabre() {
        return nomabre;
    }

    public void setNomabre(String nomabre) {
        this.nomabre = nomabre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public String getMaquias() {
        return maquias;
    }

    public void setMaquias(String maquias) {
        this.maquias = maquias;
    }

    public int getGalta_men() {
        return galta_men;
    }

    public void setGalta_men(int galta_men) {
        this.galta_men = galta_men;
    }

    public int getGaslga_may() {
        return gaslga_may;
    }

    public void setGaslga_may(int gaslga_may) {
        this.gaslga_may = gaslga_may;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }
    
            
}
