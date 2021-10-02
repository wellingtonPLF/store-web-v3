package br.edu.ifpb.padroes.storewebv3.visitor;

import br.edu.ifpb.padroes.storewebv3.domain.Product;

import br.edu.ifpb.padroes.storewebv3.domain.produtosEletronicos;
import br.edu.ifpb.padroes.storewebv3.domain.produtosLivros;

public class DescontoVisitor implements Visitor {
	
	public String apply(Product produto) {
		return produto.call(this);
    }
	
	public String visitEletronic(produtosEletronicos eletronic) {
		double desconto = (eletronic.getPrice() * 0.1);
		Long value = Math.round(eletronic.getPrice() - desconto);
		eletronic.setPrice(value);
		return String.format("Novo preço do Eletronico: %d",value);
	}
	
	public String visitBook(produtosLivros book) {
		double desconto = (book.getPrice() * 0.3);
		Long value = Math.round(book.getPrice() - desconto);
		book.setPrice(value);
		return String.format("Novo preço do Livro: %d",value);
	}
}
