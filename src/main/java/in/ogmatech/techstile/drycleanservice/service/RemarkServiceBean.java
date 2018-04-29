package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.Remark;
import in.ogmatech.techstile.drycleanservice.repository.RemarkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional
public class RemarkServiceBean implements RemarkService {

    @Autowired
    RemarkRepository remarkRepository;

    @Override
    public boolean isExist(Remark remark) {
        return findById(remark.getIdRemark())!=null;
    }

    @Override
    public Remark save(Remark remark) {
        return remarkRepository.save(remark);
    }

    @Override
    public Remark findById(Long idRemark) {
        return remarkRepository.findOne(idRemark);
    }

    @Override
    public List<Remark> findAll() {
        return remarkRepository.findAll();
    }

    @Override
    public Remark update(Long idRemark, Remark remark) {

        Remark currentRemark = remarkRepository.findOne(idRemark);

       /* currentRemark.setRemarkname(remark.getRemarkname());
        currentRemark.setPassword(remark.getPassword());
        currentRemark.setRemarkMobile(remark.getRemarkMobile());
        currentRemark.setIsDeleted(remark.getIsDeleted());
        currentRemark.setBranchId(remark.getBranchId());
        currentRemark.setRemarkDeviceIdentity(remark.getRemarkDeviceIdentity());*/

        return remarkRepository.save(currentRemark);
    }

    @Override
    public void delete(Long idRemark) {
        remarkRepository.delete(idRemark);
    }

    @Override
    public void deleteAll() {
        remarkRepository.deleteAll();
    }
}
