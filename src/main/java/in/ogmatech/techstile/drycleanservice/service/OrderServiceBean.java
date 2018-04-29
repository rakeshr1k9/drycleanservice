package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.Order;
import in.ogmatech.techstile.drycleanservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional
public class OrderServiceBean implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Override
    public boolean isExist(Order order) {
        return findById(order.getIdOrder())!=null;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order findById(Long idOrder) {
        return orderRepository.findOne(idOrder);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order update(Long idOrder, Order order) {

        Order currentOrder = orderRepository.findOne(idOrder);

       /* currentOrder.setOrdername(order.getOrdername());
        currentOrder.setPassword(order.getPassword());
        currentOrder.setOrderMobile(order.getOrderMobile());
        currentOrder.setIsDeleted(order.getIsDeleted());
        currentOrder.setBranchId(order.getBranchId());
        currentOrder.setOrderDeviceIdentity(order.getOrderDeviceIdentity());*/

        return orderRepository.save(currentOrder);
    }

    @Override
    public void delete(Long idOrder) {
        orderRepository.delete(idOrder);
    }

    @Override
    public void deleteAll() {
        orderRepository.deleteAll();
    }
    
}
