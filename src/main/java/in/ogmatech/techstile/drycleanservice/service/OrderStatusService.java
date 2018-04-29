package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.OrderStatus;

import java.util.List;

public interface OrderStatusService {

    boolean isExist(OrderStatus orderStatus);

    OrderStatus save(OrderStatus orderStatus);

    OrderStatus findById(Long idOrderStatus);

    List<OrderStatus> findAll();

    OrderStatus update(Long idOrderStatus, OrderStatus orderStatus);

    void delete(Long idOrderStatus);

    void deleteAll();
}
