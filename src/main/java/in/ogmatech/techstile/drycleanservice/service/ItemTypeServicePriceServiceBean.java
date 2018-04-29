package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.ItemTypeServicePrice;
import in.ogmatech.techstile.drycleanservice.repository.ItemTypeServicePriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional
public class ItemTypeServicePriceServiceBean implements ItemTypeServicePriceService {

    @Autowired
    ItemTypeServicePriceRepository itemTypeServicePriceRepository;

    @Override
    public boolean isExist(ItemTypeServicePrice itemTypeServicePrice) {
        return findById(itemTypeServicePrice.getIdItemTypeServicePrice())!=null;
    }

    @Override
    public ItemTypeServicePrice save(ItemTypeServicePrice itemTypeServicePrice) {
        return itemTypeServicePriceRepository.save(itemTypeServicePrice);
    }

    @Override
    public ItemTypeServicePrice findById(Long idItemTypeServicePrice) {
        return itemTypeServicePriceRepository.findOne(idItemTypeServicePrice);
    }

    @Override
    public List<ItemTypeServicePrice> findAll() {
        return itemTypeServicePriceRepository.findAll();
    }

    @Override
    public ItemTypeServicePrice update(Long idItemTypeServicePrice, ItemTypeServicePrice itemTypeServicePrice) {

        ItemTypeServicePrice currentItemTypeServicePrice = itemTypeServicePriceRepository.findOne(idItemTypeServicePrice);

       /* currentItemTypeServicePrice.setItemTypeServicePricename(itemTypeServicePrice.getItemTypeServicePricename());
        currentItemTypeServicePrice.setPassword(itemTypeServicePrice.getPassword());
        currentItemTypeServicePrice.setItemTypeServicePriceMobile(itemTypeServicePrice.getItemTypeServicePriceMobile());
        currentItemTypeServicePrice.setIsDeleted(itemTypeServicePrice.getIsDeleted());
        currentItemTypeServicePrice.setBranchId(itemTypeServicePrice.getBranchId());
        currentItemTypeServicePrice.setItemTypeServicePriceDeviceIdentity(itemTypeServicePrice.getItemTypeServicePriceDeviceIdentity());*/

        return itemTypeServicePriceRepository.save(currentItemTypeServicePrice);
    }

    @Override
    public void delete(Long idItemTypeServicePrice) {
        itemTypeServicePriceRepository.delete(idItemTypeServicePrice);
    }

    @Override
    public void deleteAll() {
        itemTypeServicePriceRepository.deleteAll();
    }
}
