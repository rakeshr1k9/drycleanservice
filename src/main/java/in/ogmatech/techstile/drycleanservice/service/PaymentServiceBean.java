package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.Payment;
import in.ogmatech.techstile.drycleanservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional
public class PaymentServiceBean implements PaymentService {

    @Autowired
    PaymentRepository paymentRepository;

    @Override
    public boolean isExist(Payment payment) {
        return findById(payment.getIdPayment())!=null;
    }

    @Override
    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    @Override
    public Payment findById(Long idPayment) {
        return paymentRepository.findOne(idPayment);
    }

    @Override
    public List<Payment> findAll() {
        return paymentRepository.findAll();
    }

    @Override
    public Payment update(Long idPayment, Payment payment) {

        Payment currentPayment = paymentRepository.findOne(idPayment);

       /* currentPayment.setPaymentname(payment.getPaymentname());
        currentPayment.setPassword(payment.getPassword());
        currentPayment.setPaymentMobile(payment.getPaymentMobile());
        currentPayment.setIsDeleted(payment.getIsDeleted());
        currentPayment.setBranchId(payment.getBranchId());
        currentPayment.setPaymentDeviceIdentity(payment.getPaymentDeviceIdentity());*/

        return paymentRepository.save(currentPayment);
    }

    @Override
    public void delete(Long idPayment) {
        paymentRepository.delete(idPayment);
    }

    @Override
    public void deleteAll() {
        paymentRepository.deleteAll();
    }
}
