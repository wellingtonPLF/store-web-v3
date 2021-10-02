package br.edu.ifpb.padroes.storewebv3.rest;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.padroes.storewebv3.domain.Order;
import br.edu.ifpb.padroes.storewebv3.domain.Product;
import br.edu.ifpb.padroes.storewebv3.repository.PedidoRepository;
import br.edu.ifpb.padroes.storewebv3.repository.ProductRepository;

@RestController
@RequestMapping("/api/order")
public class OrderResource {
	private final PedidoRepository pedidoRepository;

    public OrderResource(PedidoRepository pedidoRepository) {
        this.pedidoRepository = pedidoRepository;
    }

    @GetMapping("/")
    public List<Order> listProducts() {
        return pedidoRepository.getPedidoList();
    }

    @PostMapping("/")
    public ResponseEntity<Void> createProduct(@RequestBody Order pedido) {
        if (pedidoRepository.add(pedido)) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/")
    public ResponseEntity<Void> deleteProduct(@RequestBody Order pedido) {
    	pedidoRepository.remove(pedido);
        return ResponseEntity.ok().build();
    }

}
