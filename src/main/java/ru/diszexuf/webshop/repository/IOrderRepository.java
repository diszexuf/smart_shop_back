package ru.diszexuf.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.diszexuf.webshop.model.ClientOrder;

public interface IOrderRepository extends JpaRepository<ClientOrder, Long> {

}
