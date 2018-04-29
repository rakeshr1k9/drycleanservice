package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.Payment;

import java.util.List;

public interface PaymentService {

    boolean isExist(Payment payment);

    Payment save(Payment payment);

    Payment findById(Long idPayment);

    List<Payment> findAll();

    Payment update(Long idPayment, Payment payment);

    void delete(Long idPayment);

    void deleteAll();
}
