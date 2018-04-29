package in.ogmatech.techstile.drycleanservice.service;

import in.ogmatech.techstile.drycleanservice.model.PaymentType;
import in.ogmatech.techstile.drycleanservice.repository.PaymentTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Service
@Validated
@Transactional
public class PaymentTypeServiceBean implements PaymentTypeService {

    @Autowired
    PaymentTypeRepository paymentTypeRepository;

    @Override
    public boolean isExist(PaymentType paymentType) {
        return findById(paymentType.getIdPaymentType())!=null;
    }

    @Override
    public PaymentType save(PaymentType paymentType) {
        return paymentTypeRepository.save(paymentType);
    }

    @Override
    public PaymentType findById(Long idPaymentType) {
        return paymentTypeRepository.findOne(idPaymentType);
    }

    @Override
    public List<PaymentType> findAll() {
        return paymentTypeRepository.findAll();
    }

    @Override
    public PaymentType update(Long idPaymentType, PaymentType paymentType) {

        PaymentType currentPaymentType = paymentTypeRepository.findOne(idPaymentType);

       /* currentPaymentType.setPaymentTypename(paymentType.getPaymentTypename());
        currentPaymentType.setPassword(paymentType.getPassword());
        currentPaymentType.setPaymentTypeMobile(paymentType.getPaymentTypeMobile());
        currentPaymentType.setIsDeleted(paymentType.getIsDeleted());
        currentPaymentType.setBranchId(paymentType.getBranchId());
        currentPaymentType.setPaymentTypeDeviceIdentity(paymentType.getPaymentTypeDeviceIdentity());*/

        return paymentTypeRepository.save(currentPaymentType);
    }

    @Override
    public void delete(Long idPaymentType) {
        paymentTypeRepository.delete(idPaymentType);
    }

    @Override
    public void deleteAll() {
        paymentTypeRepository.deleteAll();
    }
}
