package co.edu.uniquindio.poo.javabrew.model;

public class ClasicoIngredientFactory implements IngredientFactory {
    @Override
    public String obtenerLeche() {
        return "Leche entera";
    }

    @Override
    public String obtenerTamaño() {
        return "Mediano";
    }
}