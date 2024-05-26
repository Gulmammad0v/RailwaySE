package az.railway.dao.interf;

import az.railway.model.Payment;

import java.util.List;

public interface PaymentDao {
    List<Payment> getPaymentList() throws Exception;

    void addPayment(Payment payment) throws Exception;
}
