package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.Order;

import java.util.List;

public interface OrderService {

    boolean isExist(Order order);

    Order save(Order order);

    Order findById(Long idOrder);

    List<Order> findAll();

    Order update(Long idOrder, Order order);

    void delete(Long idOrder);

    void deleteAll();
}
