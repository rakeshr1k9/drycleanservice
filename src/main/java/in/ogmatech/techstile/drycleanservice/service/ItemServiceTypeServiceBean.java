package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.ItemServiceType;
import in.ogmatech.techstile.drycleanservice.repository.ItemServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional
public class ItemServiceTypeServiceBean implements ItemServiceTypeService {

    @Autowired
    ItemServiceTypeRepository itemServiceTypeRepository;

    @Override
    public boolean isExist(ItemServiceType itemServiceType) {
        return findById(itemServiceType.getIdItemServiceType())!=null;
    }

    @Override
    public ItemServiceType save(ItemServiceType itemServiceType) {
        return itemServiceTypeRepository.save(itemServiceType);
    }

    @Override
    public ItemServiceType findById(Long idItemServiceType) {
        return itemServiceTypeRepository.findOne(idItemServiceType);
    }

    @Override
    public List<ItemServiceType> findAll() {
        return itemServiceTypeRepository.findAll();
    }

    @Override
    public ItemServiceType update(Long idItemServiceType, ItemServiceType itemServiceType) {

        ItemServiceType currentItemServiceType = itemServiceTypeRepository.findOne(idItemServiceType);

       /* currentItemServiceType.setItemServiceTypename(itemServiceType.getItemServiceTypename());
        currentItemServiceType.setPassword(itemServiceType.getPassword());
        currentItemServiceType.setItemServiceTypeMobile(itemServiceType.getItemServiceTypeMobile());
        currentItemServiceType.setIsDeleted(itemServiceType.getIsDeleted());
        currentItemServiceType.setBranchId(itemServiceType.getBranchId());
        currentItemServiceType.setItemServiceTypeDeviceIdentity(itemServiceType.getItemServiceTypeDeviceIdentity());*/

        return itemServiceTypeRepository.save(currentItemServiceType);
    }

    @Override
    public void delete(Long idItemServiceType) {
        itemServiceTypeRepository.delete(idItemServiceType);
    }

    @Override
    public void deleteAll() {
        itemServiceTypeRepository.deleteAll();
    }
}
