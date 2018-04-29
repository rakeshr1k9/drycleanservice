package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.WorkerService;
import in.ogmatech.techstile.drycleanservice.repository.WorkerServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional
public class WorkerServiceServiceBean implements WorkerServiceService {

    @Autowired
    WorkerServiceRepository workerServiceRepository;

    @Override
    public boolean isExist(WorkerService workerService) {
        return findById(workerService.getIdWorkerService())!=null;
    }

    @Override
    public WorkerService save(WorkerService workerService) {
        return workerServiceRepository.save(workerService);
    }

    @Override
    public WorkerService findById(Long idWorkerService) {
        return workerServiceRepository.findOne(idWorkerService);
    }

    @Override
    public List<WorkerService> findAll() {
        return workerServiceRepository.findAll();
    }

    @Override
    public WorkerService update(Long idWorkerService, WorkerService workerService) {

        WorkerService currentWorkerService = workerServiceRepository.findOne(idWorkerService);

      /*  currentWorkerService.setWorkerServicename(workerService.getWorkerServicename());
        currentWorkerService.setPassword(workerService.getPassword());
        currentWorkerService.setWorkerServiceMobile(workerService.getWorkerServiceMobile());
        currentWorkerService.setIsDeleted(workerService.getIsDeleted());
        currentWorkerService.setBranchId(workerService.getBranchId());
        currentWorkerService.setWorkerServiceDeviceIdentity(workerService.getWorkerServiceDeviceIdentity());*/

        return workerServiceRepository.save(currentWorkerService);
    }

    @Override
    public void delete(Long idWorkerService) {
        workerServiceRepository.delete(idWorkerService);
    }

    @Override
    public void deleteAll() {
        workerServiceRepository.deleteAll();
    }
}
