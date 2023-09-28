package org.cibertec.edu.pe.interfaceService;

import java.util.List;
import java.util.Optional;

import org.cibertec.edu.pe.model.Product;

public interface IProductService {
	public List<Product> list();
	public Optional<Product> search(String id);
	public int save(Product p);
	public void delete(String id);
}