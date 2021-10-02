package br.edu.ifpb.padroes.storewebv3.mediator;

import com.stripe.model.PaymentIntent;
import com.stripe.model.Sku;

import br.edu.ifpb.padroes.storewebv3.domain.Order;
import br.edu.ifpb.padroes.storewebv3.domain.Product;

public interface Mediator {
	PaymentIntent createOrder(Order order);
	Sku createSKU(Order order, Product product);
}
