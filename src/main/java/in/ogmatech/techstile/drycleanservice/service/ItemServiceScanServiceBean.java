package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.ItemServiceScan;
import in.ogmatech.techstile.drycleanservice.repository.ItemServiceScanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional
public class ItemServiceScanServiceBean implements ItemServiceScanService {

    @Autowired
    ItemServiceScanRepository itemServiceScanRepository;

    @Override
    public boolean isExist(ItemServiceScan itemServiceScan) {
        return findById(itemServiceScan.getIdItemServiceScan())!=null;
    }

    @Override
    public ItemServiceScan save(ItemServiceScan itemServiceScan) {
        return itemServiceScanRepository.save(itemServiceScan);
    }

    @Override
    public ItemServiceScan findById(Long idItemServiceScan) {
        return itemServiceScanRepository.findOne(idItemServiceScan);
    }

    @Override
    public List<ItemServiceScan> findAll() {
        return itemServiceScanRepository.findAll();
    }

    @Override
    public ItemServiceScan update(Long idItemServiceScan, ItemServiceScan itemServiceScan) {

        ItemServiceScan currentItemServiceScan = itemServiceScanRepository.findOne(idItemServiceScan);

       /* currentItemServiceScan.setItemServiceScanname(itemServiceScan.getItemServiceScanname());
        currentItemServiceScan.setPassword(itemServiceScan.getPassword());
        currentItemServiceScan.setItemServiceScanMobile(itemServiceScan.getItemServiceScanMobile());
        currentItemServiceScan.setIsDeleted(itemServiceScan.getIsDeleted());
        currentItemServiceScan.setBranchId(itemServiceScan.getBranchId());
        currentItemServiceScan.setItemServiceScanDeviceIdentity(itemServiceScan.getItemServiceScanDeviceIdentity());*/

        return itemServiceScanRepository.save(currentItemServiceScan);
    }

    @Override
    public void delete(Long idItemServiceScan) {
        itemServiceScanRepository.delete(idItemServiceScan);
    }

    @Override
    public void deleteAll() {
        itemServiceScanRepository.deleteAll();
    }
}
