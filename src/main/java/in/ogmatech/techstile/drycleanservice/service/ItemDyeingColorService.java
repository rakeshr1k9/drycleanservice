package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.ItemDyeingColor;

import java.util.List;

public interface ItemDyeingColorService {

    boolean isExist(ItemDyeingColor itemDyeingColor);

    ItemDyeingColor save(ItemDyeingColor itemDyeingColor);

    ItemDyeingColor findById(Long idItemDyeingColor);

    List<ItemDyeingColor> findAll();

    ItemDyeingColor update(Long idItemDyeingColor, ItemDyeingColor itemDyeingColor);

    void delete(Long idItemDyeingColor);

    void deleteAll();
}
