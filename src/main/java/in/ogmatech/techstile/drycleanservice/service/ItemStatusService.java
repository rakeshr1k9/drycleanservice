package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.ItemStatus;

import java.util.List;

public interface ItemStatusService {

    boolean isExist(ItemStatus itemStatus);

    ItemStatus save(ItemStatus itemStatus);

    ItemStatus findById(Long idItemStatus);

    List<ItemStatus> findAll();

    ItemStatus update(Long idItemStatus,ItemStatus itemStatus);

    void delete(Long idItemStatus);

    void deleteAll();
}
