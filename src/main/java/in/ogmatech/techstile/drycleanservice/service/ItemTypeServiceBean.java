package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.ItemType;
import in.ogmatech.techstile.drycleanservice.repository.ItemTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional
public class ItemTypeServiceBean implements ItemTypeService {

    @Autowired
    ItemTypeRepository itemTypeRepository;

    @Override
    public boolean isExist(ItemType itemType) {
        return findById(itemType.getIdItemType())!=null;
    }

    @Override
    public ItemType save(ItemType itemType) {
        return itemTypeRepository.save(itemType);
    }

    @Override
    public ItemType findById(Long idItemType) {
        return itemTypeRepository.findOne(idItemType);
    }

    @Override
    public List<ItemType> findAll() {
        return itemTypeRepository.findAll();
    }

    @Override
    public ItemType update(Long idItemType, ItemType itemType) {

        ItemType currentItemType = itemTypeRepository.findOne(idItemType);

       /* currentItemType.setItemTypename(itemType.getItemTypename());
        currentItemType.setPassword(itemType.getPassword());
        currentItemType.setItemTypeMobile(itemType.getItemTypeMobile());
        currentItemType.setIsDeleted(itemType.getIsDeleted());
        currentItemType.setBranchId(itemType.getBranchId());
        currentItemType.setItemTypeDeviceIdentity(itemType.getItemTypeDeviceIdentity());*/

        return itemTypeRepository.save(currentItemType);
    }

    @Override
    public void delete(Long idItemType) {
        itemTypeRepository.delete(idItemType);
    }

    @Override
    public void deleteAll() {
        itemTypeRepository.deleteAll();
    }
    
}
