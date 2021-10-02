package br.edu.ifpb.padroes.storewebv3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.edu.ifpb.padroes.storewebv3.domain.Product;
import br.edu.ifpb.padroes.storewebv3.repository.PedidoRepository;
import br.edu.ifpb.padroes.storewebv3.repository.ProductRepository;

public class ProductService {
	@Autowired
	   private ProductRepository productRepository;

	   public List<Product> getProducto() {
	       return this.productRepository.getProductList();
	   }

	   public void inserirProduto(Product produto) {
		   this.productRepository.add(produto);
	   }
}
