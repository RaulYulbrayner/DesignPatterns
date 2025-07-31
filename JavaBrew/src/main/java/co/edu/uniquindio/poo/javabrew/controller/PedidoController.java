package co.edu.uniquindio.poo.javabrew.controller;

import co.edu.uniquindio.poo.javabrew.model.*;

import java.util.List;

public class PedidoController {

    private final TiendaCafe tienda = TiendaCafe.getInstance();

    public boolean crearPedidoCafe(Cafe cafe) {
        return tienda.agregarPedido(cafe);
    }

    public boolean eliminarPedido(Cafe cafe) {
        return tienda.eliminarPedido(cafe);
    }

    public List<Cafe> obtenerPedidos() {
        return tienda.getPedidos();
    }

    public Cafe duplicarPedido(Cafe original) {
        return original.clone();
    }
}
