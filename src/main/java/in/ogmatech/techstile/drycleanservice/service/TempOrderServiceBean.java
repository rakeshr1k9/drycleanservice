package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.TempOrder;
import in.ogmatech.techstile.drycleanservice.repository.TempOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional
public class TempOrderServiceBean implements TempOrderService {

    @Autowired
    TempOrderRepository tempOrderRepository;

    @Override
    public boolean isExist(TempOrder tempOrder) {
        return findById(tempOrder.getIdTempOrder())!=null;
    }

    @Override
    public TempOrder save(TempOrder tempOrder) {
        return tempOrderRepository.save(tempOrder);
    }

    @Override
    public TempOrder findById(Long idTempOrder) {
        return tempOrderRepository.findOne(idTempOrder);
    }

    @Override
    public List<TempOrder> findAll() {
        return tempOrderRepository.findAll();
    }

    @Override
    public TempOrder update(Long idTempOrder, TempOrder tempOrder) {

        TempOrder currentTempOrder = tempOrderRepository.findOne(idTempOrder);

       /* currentTempOrder.setTempOrdername(tempOrder.getTempOrdername());
        currentTempOrder.setPassword(tempOrder.getPassword());
        currentTempOrder.setTempOrderMobile(tempOrder.getTempOrderMobile());
        currentTempOrder.setIsDeleted(tempOrder.getIsDeleted());
        currentTempOrder.setBranchId(tempOrder.getBranchId());
        currentTempOrder.setTempOrderDeviceIdentity(tempOrder.getTempOrderDeviceIdentity());*/

        return tempOrderRepository.save(currentTempOrder);
    }

    @Override
    public void delete(Long idTempOrder) {
        tempOrderRepository.delete(idTempOrder);
    }

    @Override
    public void deleteAll() {
        tempOrderRepository.deleteAll();
    }
}
