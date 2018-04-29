package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.ItemDyeingColor;
import in.ogmatech.techstile.drycleanservice.repository.ItemDyeingColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional
public class ItemDyeingColorServiceBean implements ItemDyeingColorService {

    @Autowired
    ItemDyeingColorRepository itemDyeingColorRepository;

    @Override
    public boolean isExist(ItemDyeingColor itemDyeingColor) {
        return findById(itemDyeingColor.getIdItemDyeingColor())!=null;
    }

    @Override
    public ItemDyeingColor save(ItemDyeingColor itemDyeingColor) {
        return itemDyeingColorRepository.save(itemDyeingColor);
    }

    @Override
    public ItemDyeingColor findById(Long idItemDyeingColor) {
        return itemDyeingColorRepository.findOne(idItemDyeingColor);
    }

    @Override
    public List<ItemDyeingColor> findAll() {
        return itemDyeingColorRepository.findAll();
    }

    @Override
    public ItemDyeingColor update(Long idItemDyeingColor, ItemDyeingColor itemDyeingColor) {

        ItemDyeingColor currentItemDyeingColor = itemDyeingColorRepository.findOne(idItemDyeingColor);

       /* currentItemDyeingColor.setItemDyeingColorname(itemDyeingColor.getItemDyeingColorname());
        currentItemDyeingColor.setPassword(itemDyeingColor.getPassword());
        currentItemDyeingColor.setItemDyeingColorMobile(itemDyeingColor.getItemDyeingColorMobile());
        currentItemDyeingColor.setIsDeleted(itemDyeingColor.getIsDeleted());
        currentItemDyeingColor.setBranchId(itemDyeingColor.getBranchId());
        currentItemDyeingColor.setItemDyeingColorDeviceIdentity(itemDyeingColor.getItemDyeingColorDeviceIdentity());*/

        return itemDyeingColorRepository.save(currentItemDyeingColor);
    }

    @Override
    public void delete(Long idItemDyeingColor) {
        itemDyeingColorRepository.delete(idItemDyeingColor);
    }

    @Override
    public void deleteAll() {
        itemDyeingColorRepository.deleteAll();
    }
}
