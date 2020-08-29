package pl.mbo.ordermanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mbo.ordermanager.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long> {
}
