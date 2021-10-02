package br.edu.ifpb.padroes.storewebv3.repository;

import java.util.ArrayList;
import java.util.List;

import br.edu.ifpb.padroes.storewebv3.domain.Order;

public class PedidoRepository {
	private List<Order> pedidoList = new ArrayList<>();

    public List<Order> getPedidoList() {
        return pedidoList;
    }

    public boolean add(Order element) {
        return pedidoList.add(element);
    }

    public boolean remove(Order pedido) {
        return pedidoList.remove(pedido);
    }
}
