package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.ItemCategory;

import java.util.List;

public interface ItemCategoryService {

    boolean isExist(ItemCategory itemCategory);

    ItemCategory save(ItemCategory itemCategory);

    ItemCategory findById(Long idItemCategory);

    List<ItemCategory> findAll();

    ItemCategory update(Long idItemCategory, ItemCategory itemCategory);

    void delete(Long idItemCategory);

    void deleteAll();
}
