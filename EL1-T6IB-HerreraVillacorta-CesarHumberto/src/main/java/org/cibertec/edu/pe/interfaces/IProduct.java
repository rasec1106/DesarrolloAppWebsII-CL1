package org.cibertec.edu.pe.interfaces;

import org.cibertec.edu.pe.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProduct extends JpaRepository<Product, String>{

}
