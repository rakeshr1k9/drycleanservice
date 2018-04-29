package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.PaymentType;

import java.util.List;

public interface PaymentTypeService {

    boolean isExist(PaymentType paymentType);

    PaymentType save(PaymentType paymentType);

    PaymentType findById(Long idPaymentType);

    List<PaymentType> findAll();

    PaymentType update(Long idPaymentType, PaymentType paymentType);

    void delete(Long idPaymentType);

    void deleteAll();
}
