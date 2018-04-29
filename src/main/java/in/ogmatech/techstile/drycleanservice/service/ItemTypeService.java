package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.ItemType;

import java.util.List;

public interface ItemTypeService {

    boolean isExist(ItemType itemType);

    ItemType save(ItemType itemType);

    ItemType findById(Long idItemType);

    List<ItemType> findAll();

    ItemType update(Long idItemType, ItemType itemType);

    void delete(Long idItemType);

    void deleteAll();
}
