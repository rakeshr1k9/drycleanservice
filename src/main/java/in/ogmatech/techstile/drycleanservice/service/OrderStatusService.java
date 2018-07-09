package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.OrderStatus;

import java.util.List;

public interface OrderStatusService {

    boolean isExist(OrderStatus orderStatus);

    OrderStatus save(OrderStatus orderStatus);

    OrderStatus findById(Integer idOrderStatus);

    List<OrderStatus> findAll();

    OrderStatus update(Integer idOrderStatus, OrderStatus orderStatus);

    void delete(Integer idOrderStatus);

    void deleteAll();
}
