package br.edu.ifpb.padroes.storewebv3.command;

import java.util.Stack;

import br.edu.ifpb.padroes.storewebv3.domain.Order;

public class CommandPedido extends Command{
	
	public CommandPedido(Order pedido) {
        super(pedido);
    }
	
    public boolean execute() {
    	pedido = new Order();
    	pedido.setProcessed(true);
    	return true;
    }
}
