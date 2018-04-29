package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.Remark;

import java.util.List;

public interface RemarkService {

    boolean isExist(Remark remark);

    Remark save(Remark remark);

    Remark findById(Long idRemark);

    List<Remark> findAll();

    Remark update(Long idRemark, Remark remark);

    void delete(Long idRemark);

    void deleteAll();
}
