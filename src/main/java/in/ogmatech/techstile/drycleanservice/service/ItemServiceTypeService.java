package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.ItemServiceType;

import java.util.List;

public interface ItemServiceTypeService {

    boolean isExist(ItemServiceType itemServiceType);

    ItemServiceType save(ItemServiceType itemServiceType);

    ItemServiceType findById(Long idItemServiceType);

    List<ItemServiceType> findAll();

    ItemServiceType update(Long idItemServiceType, ItemServiceType itemServiceType);

    void delete(Long idItemServiceType);

    void deleteAll();
}
