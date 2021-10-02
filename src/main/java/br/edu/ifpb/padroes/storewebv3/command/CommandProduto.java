package br.edu.ifpb.padroes.storewebv3.command;

import br.edu.ifpb.padroes.storewebv3.domain.Order;
import br.edu.ifpb.padroes.storewebv3.domain.Product;
import br.edu.ifpb.padroes.storewebv3.domain.produtosLivros;

public class CommandProduto extends Command{

	public CommandProduto(Product produto) {
        super(produto);
    }
	
    public boolean execute() {
    	produto = new produtosLivros();
    	return true;
    }
}
