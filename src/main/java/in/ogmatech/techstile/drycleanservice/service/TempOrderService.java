package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.TempOrder;

import java.util.List;

public interface TempOrderService {

    boolean isExist(TempOrder tempOrder);

    TempOrder save(TempOrder tempOrder);

    TempOrder findById(Long idTempOrder);

    List<TempOrder> findAll();

    TempOrder update(Long idTempOrder, TempOrder tempOrder);

    void delete(Long idTempOrder);

    void deleteAll();
}
