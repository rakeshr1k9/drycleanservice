package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.ItemCategory;
import in.ogmatech.techstile.drycleanservice.repository.ItemCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional
public class ItemCategoryServiceBean implements ItemCategoryService {

    @Autowired
    ItemCategoryRepository itemCategoryRepository;

    @Override
    public boolean isExist(ItemCategory itemCategory) {
        return findById(itemCategory.getIdItemCategory())!=null;
    }

    @Override
    public ItemCategory save(ItemCategory itemCategory) {
        return itemCategoryRepository.save(itemCategory);
    }

    @Override
    public ItemCategory findById(Long idItemCategory) {
        return itemCategoryRepository.findOne(idItemCategory);
    }

    @Override
    public List<ItemCategory> findAll() {
        return itemCategoryRepository.findAll();
    }

    @Override
    public ItemCategory update(Long idItemCategory, ItemCategory itemCategory) {

        ItemCategory currentItemCategory = itemCategoryRepository.findOne(idItemCategory);

       /* currentItemCategory.setItemCategoryname(itemCategory.getItemCategoryname());
        currentItemCategory.setPassword(itemCategory.getPassword());
        currentItemCategory.setItemCategoryMobile(itemCategory.getItemCategoryMobile());
        currentItemCategory.setIsDeleted(itemCategory.getIsDeleted());
        currentItemCategory.setBranchId(itemCategory.getBranchId());
        currentItemCategory.setItemCategoryDeviceIdentity(itemCategory.getItemCategoryDeviceIdentity());*/

        return itemCategoryRepository.save(currentItemCategory);
    }

    @Override
    public void delete(Long idItemCategory) {
        itemCategoryRepository.delete(idItemCategory);
    }

    @Override
    public void deleteAll() {
        itemCategoryRepository.deleteAll();
    }
}
