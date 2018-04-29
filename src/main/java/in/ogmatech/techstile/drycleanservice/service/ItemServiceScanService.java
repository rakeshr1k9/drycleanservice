package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.ItemServiceScan;

import java.util.List;

public interface ItemServiceScanService {

    boolean isExist(ItemServiceScan itemServiceScan);

    ItemServiceScan save(ItemServiceScan itemServiceScan);

    ItemServiceScan findById(Long idItemServiceScan);

    List<ItemServiceScan> findAll();

    ItemServiceScan update(Long idItemServiceScan, ItemServiceScan itemServiceScan);

    void delete(Long idItemServiceScan);

    void deleteAll();
}
