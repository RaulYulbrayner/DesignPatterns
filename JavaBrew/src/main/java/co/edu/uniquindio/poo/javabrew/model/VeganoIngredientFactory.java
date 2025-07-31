package co.edu.uniquindio.poo.javabrew.model;

public class VeganoIngredientFactory implements IngredientFactory {
    @Override
    public String obtenerLeche() {
        return "Leche de almendras";
    }

    @Override
    public String obtenerTamaño() {
        return "Grande";
    }
}
