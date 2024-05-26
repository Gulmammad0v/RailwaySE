package az.railway.dao.interf;

import az.railway.model.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> getCustomerList() throws Exception;

    void addCustomer(Customer customer) throws Exception;

    Customer getCustomerById(Long customerId) throws Exception;

    void updateCustomer(Customer customer) throws Exception;

    void deleteCustomer(Long customerId) throws Exception;

    List<Customer> searchCustomer(String keyword) throws Exception;
}
