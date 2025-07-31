package co.edu.uniquindio.poo.javabrew.model;

//Factory Method

public class CafeFactory {

    public static Cafe crearCafe(String tipo) {
        switch (tipo.toLowerCase()) {
            case "espresso":
                return new Cafe("Espresso", "Pequeño", "Sin leche");
            case "latte":
                return new Cafe("Latte", "Grande", "Leche entera");
            case "capuccino":
                return new Cafe("Capuccino", "Mediano", "Deslactosada");
            default:
                throw new IllegalArgumentException("Tipo de café desconocido");
        }
    }
}
