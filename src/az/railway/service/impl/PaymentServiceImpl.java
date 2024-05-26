package az.railway.service.impl;

import az.railway.dao.interf.PaymentDao;
import az.railway.model.Payment;
import az.railway.service.interf.PaymentService;

import java.util.List;

public class PaymentServiceImpl implements PaymentService {
    PaymentDao paymentDao;

    public PaymentServiceImpl(PaymentDao paymentDao) {
        this.paymentDao = paymentDao;
    }

    @Override
    public List<Payment> getPaymentList() throws Exception {
        return paymentDao.getPaymentList();
    }

    @Override
    public void addPayment(Payment payment) throws Exception {
        paymentDao.addPayment(payment);
    }
}
