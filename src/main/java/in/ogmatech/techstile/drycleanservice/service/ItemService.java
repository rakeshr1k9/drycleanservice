package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.Item;
import in.ogmatech.techstile.drycleanservice.modelWrapper.ItemWrapper;

import java.util.List;

public interface ItemService {

    boolean isExist(Item item);

    Item save(Item item);

    Item findById(Long idItem);

    List<Item> findByOrderId(Long orderId);

    void saveMany(List<Item> items);

    List<Item> findAll();

    Item update(Long idItem, Item item);

    void delete(Long idItem);

    void deleteAll();
}
