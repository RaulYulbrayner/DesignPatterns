package co.edu.uniquindio.poo.javabrew.model;

//Builder

public class CafeBuilder {
    private String tipo = "Personalizado";
    private String tamaño = "Mediano";
    private String leche = "Leche entera";

    public CafeBuilder setTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public CafeBuilder setTamaño(String tamaño) {
        this.tamaño = tamaño;
        return this;
    }

    public CafeBuilder setLeche(String leche) {
        this.leche = leche;
        return this;
    }

    public Cafe build() {
        return new Cafe(tipo, tamaño, leche);
    }
}
