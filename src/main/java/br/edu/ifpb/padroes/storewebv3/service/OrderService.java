package br.edu.ifpb.padroes.storewebv3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import br.edu.ifpb.padroes.storewebv3.domain.Order;
import br.edu.ifpb.padroes.storewebv3.repository.PedidoRepository;

@Service
public class OrderService {
   @Autowired
   private PedidoRepository pedidoRepository;

   public List<Order> getPedido() {
       return this.pedidoRepository.getPedidoList();
   }

   public void inserirPedido(Order pedido) {
	   this.pedidoRepository.add(pedido);
   }
}
