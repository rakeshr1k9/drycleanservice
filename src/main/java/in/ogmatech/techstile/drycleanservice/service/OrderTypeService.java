package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.OrderType;

import java.util.List;

public interface OrderTypeService {

    boolean isExist(OrderType orderType);

    OrderType save(OrderType orderType);

    OrderType findById(Long idOrderType);

    List<OrderType> findAll();

    OrderType update(Long idOrderType, OrderType orderType);

    void delete(Long idOrderType);

    void deleteAll();
}
