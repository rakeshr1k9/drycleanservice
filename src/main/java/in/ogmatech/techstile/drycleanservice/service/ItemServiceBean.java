package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.Item;
import in.ogmatech.techstile.drycleanservice.modelWrapper.ItemWrapper;
import in.ogmatech.techstile.drycleanservice.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional
public class ItemServiceBean implements ItemService{

    @Autowired
    ItemRepository itemRepository;

    @Override
    public void saveMany(List<Item> items) {
        itemRepository.save(items);
    }

    @Override
    public boolean isExist(Item item) {
        return findById(item.getIdItem())!=null;
    }

    @Override
    public Item save(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item findById(Long idItem) {
        return itemRepository.findOne(idItem);
    }

    @Override
    public List<Item> findByOrderId(Long orderId) {
        List<Item> items = itemRepository.findByOrderId(orderId);
        return items;
    }

    @Override
    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    @Override
    public Item update(Long idItem, Item item) {

        Item currentItem = itemRepository.findOne(idItem);

       /* currentItem.setItemname(item.getItemname());
        currentItem.setPassword(item.getPassword());
        currentItem.setItemMobile(item.getItemMobile());
        currentItem.setIsDeleted(item.getIsDeleted());
        currentItem.setBranchId(item.getBranchId());
        currentItem.setItemDeviceIdentity(item.getItemDeviceIdentity());*/

        return itemRepository.save(currentItem);
    }

    @Override
    public void delete(Long idItem) {
        itemRepository.delete(idItem);
    }

    @Override
    public void deleteAll() {
        itemRepository.deleteAll();
    }
}
