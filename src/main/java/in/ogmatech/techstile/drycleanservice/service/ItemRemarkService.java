package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.ItemRemark;

import java.util.List;

public interface ItemRemarkService {

    boolean isExist(ItemRemark itemRemark);

    ItemRemark save(ItemRemark itemRemark);

    ItemRemark findById(Long idItemRemark);

    List<ItemRemark> findAll();

    ItemRemark update(Long idItemRemark, ItemRemark itemRemark);

    void delete(Long idItemRemark);

    void deleteAll();
}
