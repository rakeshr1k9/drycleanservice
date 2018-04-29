package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.ItemStatus;
import in.ogmatech.techstile.drycleanservice.repository.ItemStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional
public class ItemStatusServiceBean implements ItemStatusService {

    @Autowired
    ItemStatusRepository itemStatusRepository;

    @Override
    public boolean isExist(ItemStatus itemStatus) {
        return findById(itemStatus.getIdItemStatus())!=null;
    }

    @Override
    public ItemStatus save(ItemStatus itemStatus) {
        return itemStatusRepository.save(itemStatus);
    }

    @Override
    public ItemStatus findById(Long idItemStatus) {
        return itemStatusRepository.findOne(idItemStatus);
    }

    @Override
    public List<ItemStatus> findAll() {
        return itemStatusRepository.findAll();
    }

    @Override
    public ItemStatus update(Long idItemStatus, ItemStatus itemStatus) {

        ItemStatus currentItemStatus = itemStatusRepository.findOne(idItemStatus);

       /* currentItemStatus.setItemStatusname(itemStatus.getItemStatusname());
        currentItemStatus.setPassword(itemStatus.getPassword());
        currentItemStatus.setItemStatusMobile(itemStatus.getItemStatusMobile());
        currentItemStatus.setIsDeleted(itemStatus.getIsDeleted());
        currentItemStatus.setBranchId(itemStatus.getBranchId());
        currentItemStatus.setItemStatusDeviceIdentity(itemStatus.getItemStatusDeviceIdentity());*/

        return itemStatusRepository.save(currentItemStatus);
    }

    @Override
    public void delete(Long idItemStatus) {
        itemStatusRepository.delete(idItemStatus);
    }

    @Override
    public void deleteAll() {
        itemStatusRepository.deleteAll();
    }
}
