package co.edu.uniquindio.poo.javabrew.model;

//Singleton

import java.util.LinkedList;
import java.util.List;

public class TiendaCafe {
    private static TiendaCafe instancia;
    private final List<Cafe> pedidos;

    private TiendaCafe() {
        pedidos = new LinkedList<>();
    }

    public static TiendaCafe getInstance() {
        if (instancia == null) {
            instancia = new TiendaCafe();
        }
        return instancia;
    }

    public boolean agregarPedido(Cafe cafe) {
        return pedidos.add(cafe);
    }

    public boolean eliminarPedido(Cafe cafe) {
        return pedidos.remove(cafe);
    }

    public List<Cafe> getPedidos() {
        return pedidos;
    }
}