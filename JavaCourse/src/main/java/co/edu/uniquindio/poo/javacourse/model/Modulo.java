package co.edu.uniquindio.poo.javacourse.model;

import java.util.ArrayList;
import java.util.List;

public class Modulo implements CursoComponent {

    private final String titulo;
    private final List<CursoComponent> subcomponentes;

    public Modulo(String titulo) {
        this.titulo = titulo;
        this.subcomponentes = new ArrayList<>();
    }

    public void agregarComponente(CursoComponent componente) {
        subcomponentes.add(componente);
    }

    public boolean eliminarComponente(CursoComponent componente) {
        return subcomponentes.remove(componente);
    }

    public List<CursoComponent> getSubcomponentes() {
        return subcomponentes;
    }

    public String getTitulo() {
        return titulo;
    }

    @Override
    public String mostrarContenido() {
        StringBuilder sb = new StringBuilder("Módulo: ").append(titulo).append("\n");
        for (CursoComponent c : subcomponentes) {
            sb.append("  - ").append(c.mostrarContenido()).append("\n");
        }
        return sb.toString();
    }

    @Override
    public int contarSubComponentes() {
        int total = 0;
        for (CursoComponent c : subcomponentes) {
            total += c.contarSubComponentes();
        }
        return total;
    }
}
