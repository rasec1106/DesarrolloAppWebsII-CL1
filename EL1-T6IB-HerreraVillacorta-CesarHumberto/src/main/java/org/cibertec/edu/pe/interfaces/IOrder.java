package org.cibertec.edu.pe.interfaces;

import org.cibertec.edu.pe.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrder extends JpaRepository<Order, Long> {

}
