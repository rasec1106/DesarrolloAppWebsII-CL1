package org.cibertec.edu.pe.service;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.interfaceService.IProductService;
import org.cibertec.edu.pe.interfaces.IProduct;
import org.cibertec.edu.pe.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	private IProduct data;

	@Override
	public List<Product> list() {
		return (List<Product>)data.findAll();
	}

	@Override
	public Optional<Product> search(Long productId) {
		return data.findById(productId);
	}

	@Override
	public int save(Product p) {
		int hasSaved = 0;
		Product dbProduct = data.save(p);
		if(!dbProduct.equals(null)) hasSaved = -1;
		return hasSaved;
	}

	@Override
	public void delete(Long productId) {
		data.deleteById(productId);		
	}

}
