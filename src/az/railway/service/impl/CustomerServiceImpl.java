package az.railway.service.impl;

import az.railway.dao.interf.CustomerDao;
import az.railway.model.Customer;
import az.railway.service.interf.CustomerService;

import java.util.List;

public class CustomerServiceImpl implements CustomerService {
    CustomerDao customerDao;

    public CustomerServiceImpl(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public List<Customer> getCustomerList() throws Exception {
        return customerDao.getCustomerList();
    }

    @Override
    public void addCustomer(Customer customer) throws Exception {
        customerDao.addCustomer(customer);
    }

    @Override
    public Customer getCustomerById(Long customerId) throws Exception {
        return customerDao.getCustomerById(customerId);
    }

    @Override
    public void updateCustomer(Customer customer) throws Exception {
        customerDao.updateCustomer(customer);
    }

    @Override
    public void deleteCustomer(Long customerId) throws Exception {
        customerDao.deleteCustomer(customerId);
    }

    @Override
    public List<Customer> searchCustomer(String keyword) throws Exception {
        return customerDao.searchCustomer(keyword);
    }
}
