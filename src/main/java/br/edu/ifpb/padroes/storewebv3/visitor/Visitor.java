package br.edu.ifpb.padroes.storewebv3.visitor;

import br.edu.ifpb.padroes.storewebv3.domain.produtosEletronicos;
import br.edu.ifpb.padroes.storewebv3.domain.produtosLivros;

public interface Visitor {
	String visitEletronic(produtosEletronicos eletronic);
	String visitBook(produtosLivros book);
}
