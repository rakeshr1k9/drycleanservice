package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.DyeingColor;

import java.util.List;

public interface DyeingColorService {

    boolean isExist(DyeingColor dyeingColor);

    DyeingColor save(DyeingColor dyeingColor);

    DyeingColor findById(Long idDyeingColor);

    List<DyeingColor> findAll();

    DyeingColor update(Long idDyeingColor, DyeingColor dyeingColor);

    void delete(Long idDyeingColor);

    void deleteAll();
}
