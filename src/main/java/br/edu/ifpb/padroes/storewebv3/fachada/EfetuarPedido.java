package br.edu.ifpb.padroes.storewebv3.fachada;

import br.edu.ifpb.padroes.storewebv3.config.StoreConfigurationProperties;
import br.edu.ifpb.padroes.storewebv3.domain.Order;
import br.edu.ifpb.padroes.storewebv3.domain.Product;
import br.edu.ifpb.padroes.storewebv3.mediator.Mediator;
import br.edu.ifpb.padroes.storewebv3.payment.StripeApi;
import br.edu.ifpb.padroes.storewebv3.service.OrderService;
import br.edu.ifpb.padroes.storewebv3.service.ProductService;

public class EfetuarPedido {
	
	private OrderService orderService;
	private ProductService productService;
	Mediator strp = new StripeApi(new StoreConfigurationProperties());
	
	public void criarPedido(Order myOrder, Product myProduct) {
		orderService.inserirPedido(myOrder);
		
		strp.createOrder(myOrder);
		strp.createSKU(myOrder, myProduct);
	}
	
	public void listarProdutosDisponiveis() {
		productService.getProducto();
	}
}
