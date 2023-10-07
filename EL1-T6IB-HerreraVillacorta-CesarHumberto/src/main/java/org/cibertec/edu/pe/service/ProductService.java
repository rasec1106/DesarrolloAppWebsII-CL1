package org.cibertec.edu.pe.service;

import java.math.BigDecimal;
import java.util.ArrayList;
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
		if(!dbProduct.equals(null)) hasSaved = 1;
		return hasSaved;
	}

	@Override
	public void delete(Long productId) {
		data.deleteById(productId);		
	}
	
	@Override
	public List<Product> createSampleProducts() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(1L, "PC Escritorio", "PC Escritorio 8RAM", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSFlmZFzq_ydqdHk7IVzXcOfVPB6XduiL2Rtw&usqp=CAU", new BigDecimal(12)));
        products.add(new Product(2L, "Camara Cannon", "Camara Cannon 16Pixeles", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS-lMeVshhjiJyQ4_GQgmkY0DCXehBW5pCG-A&usqp=CAU", new BigDecimal(99)));
        products.add(new Product(3L, "Audifonos", "Audifonos Sony", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRVN54oGHgYQzquqk17Lqo1keNGAOKHfI5wmA&usqp=CAU", new BigDecimal(100)));
        products.add(new Product(4L, "Shorts", "Short jean para mujer", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTZA3AGo_8411E2m9qA3RCEjg7gwRIXFYgEWA&usqp=CAU", new BigDecimal(25.99)));
        products.add(new Product(5L, "Casaca", "Casaca", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSGVxBRpEeTjqTV6UPk5_fc0Hxq85lwGYX3Kw&usqp=CAU", new BigDecimal(39.99)));

        return products;
    }

}
