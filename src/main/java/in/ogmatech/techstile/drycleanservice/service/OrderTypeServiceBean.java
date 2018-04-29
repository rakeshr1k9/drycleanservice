package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.OrderType;
import in.ogmatech.techstile.drycleanservice.repository.OrderTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional
public class OrderTypeServiceBean implements OrderTypeService {

    @Autowired
    OrderTypeRepository orderTypeRepository;

    @Override
    public boolean isExist(OrderType orderType) {
        return findById(orderType.getIdOrderType())!=null;
    }

    @Override
    public OrderType save(OrderType orderType) {
        return orderTypeRepository.save(orderType);
    }

    @Override
    public OrderType findById(Long idOrderType) {
        return orderTypeRepository.findOne(idOrderType);
    }

    @Override
    public List<OrderType> findAll() {
        return orderTypeRepository.findAll();
    }

    @Override
    public OrderType update(Long idOrderType, OrderType orderType) {

        OrderType currentOrderType = orderTypeRepository.findOne(idOrderType);

       /* currentOrderType.setOrderTypename(orderType.getOrderTypename());
        currentOrderType.setPassword(orderType.getPassword());
        currentOrderType.setOrderTypeMobile(orderType.getOrderTypeMobile());
        currentOrderType.setIsDeleted(orderType.getIsDeleted());
        currentOrderType.setBranchId(orderType.getBranchId());
        currentOrderType.setOrderTypeDeviceIdentity(orderType.getOrderTypeDeviceIdentity());*/

        return orderTypeRepository.save(currentOrderType);
    }

    @Override
    public void delete(Long idOrderType) {
        orderTypeRepository.delete(idOrderType);
    }

    @Override
    public void deleteAll() {
        orderTypeRepository.deleteAll();
    }
}
