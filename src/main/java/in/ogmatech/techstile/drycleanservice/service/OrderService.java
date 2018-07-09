package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.Order;

import java.util.List;

public interface OrderService {

    boolean isExist(Order order);

    Order save(Order order);

    Order findById(Integer idOrder);

    List<Order> findAll();

    Order update(Integer idOrder, Order order);

    void delete(Integer idOrder);

    void deleteAll();

    List<Order> listAllOrders(Byte isDeleted, Integer branchId, List<Integer> orderStatusId);

    List<Order> listQuickOrders(Byte isQuickDelivery, Byte isDeleted, Integer branchId, List<Integer> orderStatusId);

    List<Order> listOrdersByPhone(Byte isDeleted, Integer branchId, Long customerMobile);

    List<Order> listOrdersByOrderNo(Byte isDeleted, Integer branchId, Integer orderNumber);

}
