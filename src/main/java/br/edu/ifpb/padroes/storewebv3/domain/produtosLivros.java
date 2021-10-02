package br.edu.ifpb.padroes.storewebv3.domain;

import br.edu.ifpb.padroes.storewebv3.visitor.Visitor;

public class produtosLivros extends Product{
	public String call(Visitor visitor) {
        return visitor.visitBook(this);
    }
}
