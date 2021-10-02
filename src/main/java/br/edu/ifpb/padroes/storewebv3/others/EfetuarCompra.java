package br.edu.ifpb.padroes.storewebv3.others;

import br.edu.ifpb.padroes.storewebv3.command.Command;
import br.edu.ifpb.padroes.storewebv3.command.CommandList;
import br.edu.ifpb.padroes.storewebv3.command.CommandPedido;
import br.edu.ifpb.padroes.storewebv3.command.CommandProduto;
import br.edu.ifpb.padroes.storewebv3.config.StoreConfigurationProperties;
import br.edu.ifpb.padroes.storewebv3.domain.Order;
import br.edu.ifpb.padroes.storewebv3.domain.Product;
import br.edu.ifpb.padroes.storewebv3.fachada.EfetuarPedido;
import br.edu.ifpb.padroes.storewebv3.mediator.Mediator;
import br.edu.ifpb.padroes.storewebv3.payment.StripeApi;
import br.edu.ifpb.padroes.storewebv3.service.OrderService;
import br.edu.ifpb.padroes.storewebv3.service.ProductService;
import br.edu.ifpb.padroes.storewebv3.visitor.DescontoVisitor;

import com.stripe.model.PaymentIntent;
import com.stripe.model.Sku;

public class EfetuarCompra {	
	
	private CommandList listaC= new CommandList();
	private Order myOrder;
	private Product myProduct;
		
	EfetuarPedido fachada = new EfetuarPedido();
	
	public void init() {
		executeCommand(new CommandPedido(myOrder));
		executeCommand(new CommandProduto(myProduct));
		
		fachada.criarPedido(myOrder, myProduct);
		fachada.listarProdutosDisponiveis();
		
		DescontoVisitor desconto = new DescontoVisitor();
		desconto.apply(myProduct);
	}
	
	private void executeCommand(Command command) {
        if (command.execute()) {
            listaC.push(command);
        }
    }
}
