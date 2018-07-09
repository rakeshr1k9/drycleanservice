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
    public Order findById(Integer idOrder) {
        return orderRepository.findById(idOrder).orElse(null);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order update(Integer idOrder, Order order) {

        Order currentOrder = orderRepository.findById(idOrder).orElse(null);

       /* currentOrder.setOrdername(order.getOrdername());
        currentOrder.setPassword(order.getPassword());
        currentOrder.setOrderMobile(order.getOrderMobile());
        currentOrder.setIsDeleted(order.getIsDeleted());
        currentOrder.setBranchId(order.getBranchId());
        currentOrder.setOrderDeviceIdentity(order.getOrderDeviceIdentity());*/

        return orderRepository.save(currentOrder);
    }

    @Override
    public void delete(Integer idOrder) {
        orderRepository.deleteById(idOrder);
    }

    @Override
    public void deleteAll() {
        orderRepository.deleteAll();
    }

    @Override
    public List<Order> listAllOrders(Byte isDeleted, Integer branchId, List<Integer> orderStatusId) {
        return orderRepository.findByIsDeletedAndBranchIdAndOrderStatusIdInOrderByOrderShouldDeliverAtAsc(isDeleted, branchId, orderStatusId);
    }

    @Override
    public List<Order> listQuickOrders(Byte isQuickDelivery, Byte isDeleted, Integer branchId, List<Integer> orderStatusId) {
        return orderRepository.findByIsQuickDeliveryAndIsDeletedAndBranchIdAndOrderStatusIdInOrderByOrderShouldDeliverAtAsc(isQuickDelivery, isDeleted, branchId, orderStatusId);
    }

    @Override
    public List<Order> listOrdersByPhone(Byte isDeleted, Integer branchId, Long customerMobile) {
        return orderRepository.findByIsDeletedAndBranchIdAndCustomerMobileOrderByOrderShouldDeliverAtAsc(isDeleted, branchId, customerMobile);
    }

    @Override
    public List<Order> listOrdersByOrderNo(Byte isDeleted, Integer branchId, Integer orderNumber) {
        return orderRepository.findByIsDeletedAndBranchIdAndOrderNumberLikeOrderByOrderShouldDeliverAtAsc(isDeleted, branchId, orderNumber);
    }

}
