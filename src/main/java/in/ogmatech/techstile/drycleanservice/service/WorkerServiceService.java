package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.WorkerService;

import java.util.List;

public interface WorkerServiceService {

    boolean isExist(WorkerService workerService);

    WorkerService save(WorkerService workerService);

    WorkerService findById(Long idWorkerService);

    List<WorkerService> findAll();

    WorkerService update(Long idWorkerService, WorkerService workerService);

    void delete(Long idWorkerService);

    void deleteAll();
}
