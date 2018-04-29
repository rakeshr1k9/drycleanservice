package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.ItemRemark;
import in.ogmatech.techstile.drycleanservice.repository.ItemRemarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional
public class ItemRemarkServiceBean implements ItemRemarkService{

    @Autowired
    ItemRemarkRepository itemRemarkRepository;

    @Override
    public boolean isExist(ItemRemark itemRemark) {
        return findById(itemRemark.getIdItemRemark())!=null;
    }

    @Override
    public ItemRemark save(ItemRemark itemRemark) {
        return itemRemarkRepository.save(itemRemark);
    }

    @Override
    public ItemRemark findById(Long idItemRemark) {
        return itemRemarkRepository.findOne(idItemRemark);
    }

    @Override
    public List<ItemRemark> findAll() {
        return itemRemarkRepository.findAll();
    }

    @Override
    public ItemRemark update(Long idItemRemark, ItemRemark itemRemark) {

        ItemRemark currentItemRemark = itemRemarkRepository.findOne(idItemRemark);

       /* currentItemRemark.setItemRemarkname(itemRemark.getItemRemarkname());
        currentItemRemark.setPassword(itemRemark.getPassword());
        currentItemRemark.setItemRemarkMobile(itemRemark.getItemRemarkMobile());
        currentItemRemark.setIsDeleted(itemRemark.getIsDeleted());
        currentItemRemark.setBranchId(itemRemark.getBranchId());
        currentItemRemark.setItemRemarkDeviceIdentity(itemRemark.getItemRemarkDeviceIdentity());*/

        return itemRemarkRepository.save(currentItemRemark);
    }

    @Override
    public void delete(Long idItemRemark) {
        itemRemarkRepository.delete(idItemRemark);
    }

    @Override
    public void deleteAll() {
        itemRemarkRepository.deleteAll();
    }
}
