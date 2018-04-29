package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.DyeingColor;
import in.ogmatech.techstile.drycleanservice.repository.DyeingColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional
public class DyeingColorServiceBean implements DyeingColorService{

    @Autowired
    DyeingColorRepository dyeingColorRepository;

    @Override
    public boolean isExist(DyeingColor dyeingColor) {
        return findById(dyeingColor.getIdDyeingColor())!=null;
    }

    @Override
    public DyeingColor save(DyeingColor dyeingColor) {
        return dyeingColorRepository.save(dyeingColor);
    }

    @Override
    public DyeingColor findById(Long idDyeingColor) {
        return dyeingColorRepository.findOne(idDyeingColor);
    }

    @Override
    public List<DyeingColor> findAll() {
        return dyeingColorRepository.findAll();
    }

    @Override
    public DyeingColor update(Long idDyeingColor, DyeingColor dyeingColor) {

        DyeingColor currentDyeingColor = dyeingColorRepository.findOne(idDyeingColor);

       /* currentDyeingColor.setDyeingColorname(dyeingColor.getDyeingColorname());
        currentDyeingColor.setPassword(dyeingColor.getPassword());
        currentDyeingColor.setDyeingColorMobile(dyeingColor.getDyeingColorMobile());
        currentDyeingColor.setIsDeleted(dyeingColor.getIsDeleted());
        currentDyeingColor.setBranchId(dyeingColor.getBranchId());
        currentDyeingColor.setDyeingColorDeviceIdentity(dyeingColor.getDyeingColorDeviceIdentity());*/

        return dyeingColorRepository.save(currentDyeingColor);
    }

    @Override
    public void delete(Long idDyeingColor) {
        dyeingColorRepository.delete(idDyeingColor);
    }

    @Override
    public void deleteAll() {
        dyeingColorRepository.deleteAll();
    }
}
