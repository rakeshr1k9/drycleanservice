package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.OrderStatus;
import in.ogmatech.techstile.drycleanservice.repository.OrderStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional
public class OrderStatusServiceBean implements OrderStatusService {

    @Autowired
    OrderStatusRepository orderStatusRepository;

    @Override
    public boolean isExist(OrderStatus orderStatus) {
        return findById(orderStatus.getIdOrderStatus())!=null;
    }

    @Override
    public OrderStatus save(OrderStatus orderStatus) {
        return orderStatusRepository.save(orderStatus);
    }

    @Override
    public OrderStatus findById(Long idOrderStatus) {
        return orderStatusRepository.findOne(idOrderStatus);
    }

    @Override
    public List<OrderStatus> findAll() {
        return orderStatusRepository.findAll();
    }

    @Override
    public OrderStatus update(Long idOrderStatus, OrderStatus orderStatus) {

        OrderStatus currentOrderStatus = orderStatusRepository.findOne(idOrderStatus);

       /* currentOrderStatus.setOrderStatusname(orderStatus.getOrderStatusname());
        currentOrderStatus.setPassword(orderStatus.getPassword());
        currentOrderStatus.setOrderStatusMobile(orderStatus.getOrderStatusMobile());
        currentOrderStatus.setIsDeleted(orderStatus.getIsDeleted());
        currentOrderStatus.setBranchId(orderStatus.getBranchId());
        currentOrderStatus.setOrderStatusDeviceIdentity(orderStatus.getOrderStatusDeviceIdentity());*/

        return orderStatusRepository.save(currentOrderStatus);
    }

    @Override
    public void delete(Long idOrderStatus) {
        orderStatusRepository.delete(idOrderStatus);
    }

    @Override
    public void deleteAll() {
        orderStatusRepository.deleteAll();
    }
}
