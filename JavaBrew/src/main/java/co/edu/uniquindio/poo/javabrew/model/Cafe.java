package co.edu.uniquindio.poo.javabrew.model;

//Prototype

public class Cafe implements Cloneable {
    private String tipo;
    private String tamaño;
    private String leche;

    public Cafe(String tipo, String tamaño, String leche) {
        this.tipo = tipo;
        this.tamaño = tamaño;
        this.leche = leche;
    }

    public String getTipo() { return tipo; }
    public String getTamaño() { return tamaño; }
    public String getLeche() { return leche; }

    public void setTipo(String tipo) { this.tipo = tipo; }
    public void setTamaño(String tamaño) { this.tamaño = tamaño; }
    public void setLeche(String leche) { this.leche = leche; }

    @Override
    public String toString() {
        return tipo + " (" + tamaño + ", " + leche + ")";
    }

    @Override
    public Cafe clone() {
        try {
            return (Cafe) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
