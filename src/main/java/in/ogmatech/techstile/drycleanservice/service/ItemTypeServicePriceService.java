package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.ItemTypeServicePrice;

import java.util.List;

public interface ItemTypeServicePriceService {

    boolean isExist(ItemTypeServicePrice itemTypeServicePrice);

    ItemTypeServicePrice save(ItemTypeServicePrice itemTypeServicePrice);

    ItemTypeServicePrice findById(Long idItemTypeServicePrice);

    List<ItemTypeServicePrice> findAll();

    ItemTypeServicePrice update(Long idItemTypeServicePrice, ItemTypeServicePrice itemTypeServicePrice);

    void delete(Long idItemTypeServicePrice);

    void deleteAll();
}
