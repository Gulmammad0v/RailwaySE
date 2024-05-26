package az.railway.service.interf;

import az.railway.model.Payment;

import java.util.List;

public interface PaymentService {
    List<Payment> getPaymentList() throws Exception;

    void addPayment(Payment payment) throws Exception;
}
