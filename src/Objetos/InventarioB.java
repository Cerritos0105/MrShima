package Objetos;
public class InventarioB {
    private  int ID;
    private String etiqueta;
    private int cantidad;
    private double precio;
    private double credito;
    private String t;
    private String maquinas;
    private int galga_may;
    private int galga_men;
    private int nivel;
    private String unidad;

    public InventarioB() {
    }

    public InventarioB(int ID, String etiqueta, int cantidad, double precio, double credito, String t, String maquinas, int galga_may, int galga_men, int nivel, String unidad) {
        this.ID = ID;
        this.etiqueta = etiqueta;
        this.cantidad = cantidad;
        this.precio = precio;
        this.credito = credito;
        this.t = t;
        this.maquinas = maquinas;
        this.galga_may = galga_may;
        this.galga_men = galga_men;
        this.nivel = nivel;
        this.unidad = unidad;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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

    public String getT() {
        return t;
    }

    public void setT(String t) {
        this.t = t;
    }

    public String getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(String maquinas) {
        this.maquinas = maquinas;
    }

    public int getGalga_may() {
        return galga_may;
    }

    public void setGalga_may(int galga_may) {
        this.galga_may = galga_may;
    }

    public int getGalga_men() {
        return galga_men;
    }

    public void setGalga_men(int galga_men) {
        this.galga_men = galga_men;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }
    
}
