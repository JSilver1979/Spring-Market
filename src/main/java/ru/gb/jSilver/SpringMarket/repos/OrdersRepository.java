package ru.gb.jSilver.SpringMarket.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.jSilver.SpringMarket.data.Order;

import java.util.List;

public interface OrdersRepository extends JpaRepository<Order, Long> {

}
