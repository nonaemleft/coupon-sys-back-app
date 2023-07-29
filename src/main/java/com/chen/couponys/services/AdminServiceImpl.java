package com.chen.couponys.services;

import com.chen.couponys.bins.Company;
import com.chen.couponys.bins.Coupon;
import com.chen.couponys.bins.Customer;
import com.chen.couponys.exceptions.CoupounSystemException;
import com.chen.couponys.exceptions.ErrMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Service
public class AdminServiceImpl extends ClientService implements AdminService {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private CustomerService customerService;


    @Override
    public boolean login(String email, String password) {
        return (email.equals("admin@admin.com") && password.equals("admin"));
    }

    @Override
    public void addCompany(Company company) throws Exception {
        int id = company.getId();
        if (companyRepository.existsById(id)){
            throw new CoupounSystemException(ErrMsg.ID_ALREADY_EXIST);
        }
        companyRepository.save(company);
    }

    @Override
    public void updateCompany(int id, Company company) throws Exception {
        if (companyRepository.existsById(id)){
            throw new CoupounSystemException(ErrMsg.ID_NOT_FOUND);
        }
        company.setId(id);
        companyRepository.saveAndFlush(company);
    }

    @Override
    public void deleteCompany(int id) throws Exception {
        if (!companyRepository.existsById(id)){
            throw new CoupounSystemException(ErrMsg.ID_NOT_FOUND);
        }
        companyRepository.deleteById(id);
    }

    @Override
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    @Override
    public Company getSingleCompany(int id) throws Exception {
        return companyRepository.findById(id)
                .orElseThrow(()->new  CoupounSystemException(ErrMsg.ID_NOT_FOUND));
    }

    @Override
    public void addCustomer(Customer customer) throws Exception {
        int id = customer.getId();
        if (customerRepository.existsById(id)){
            throw new CoupounSystemException(ErrMsg.ID_NOT_FOUND);
        }
        customerRepository.save(customer);

    }

    @Override
    public void updateCustomer(int id, Customer customer) throws Exception {
        if (customerRepository.existsById(id)){
            throw new CoupounSystemException(ErrMsg.ID_NOT_FOUND);
        }
        customer.setId(id);
        customerRepository.saveAndFlush(customer);
    }

    @Override
    public void deleteCustomer(int id) throws Exception {
        if (!customerRepository.existsById(id)){
            throw new CoupounSystemException(ErrMsg.ID_NOT_FOUND);
        }
        customerRepository.deleteById(id);

    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getSingleCustomer(int id) throws Exception {
        return customerRepository.findById(id).orElseThrow(()->new CoupounSystemException(ErrMsg.ID_NOT_FOUND));
    }
    public Customer getCustomerByEmail(String email){
       return customerRepository.findByEmail(email).get(0);
    }

    @Override
    public void delExpiredCoupon() {
        List<Coupon> couponList = couponRepository.findByEndDateAfter(Date.valueOf(LocalDate.now()));
        couponList.forEach(coupon -> couponRepository.delete(coupon));
    }


}

