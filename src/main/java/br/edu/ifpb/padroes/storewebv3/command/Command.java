package br.edu.ifpb.padroes.storewebv3.command;

import br.edu.ifpb.padroes.storewebv3.domain.Order;
import br.edu.ifpb.padroes.storewebv3.domain.Product;

public abstract class Command {
	public Order pedido;
	public Product produto;
	
	Command(Order pedido){
		this.pedido = pedido;
	}
	
	Command(Product produto){
		this.produto = produto;
	}
	
	
    public abstract boolean execute();
}
