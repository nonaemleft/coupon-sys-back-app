package com.chen.couponys.controllers;

import com.chen.couponys.bins.Company;
import com.chen.couponys.bins.Customer;
import com.chen.couponys.exceptions.CoupounSystemException;
import com.chen.couponys.exceptions.ErrMsg;
import com.chen.couponys.login.ClientsType;
import com.chen.couponys.security.TokenService;
import com.chen.couponys.services.AdminService;
import com.chen.couponys.services.CompanyService;
import com.chen.couponys.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/admin")
public class AdminController {
    @Autowired
    private CompanyService companyService;
    @Autowired
    private AdminService adminService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    TokenService tokenService;

    @GetMapping("/companies")
    public List<Company> getAllCompanies(@RequestHeader UUID token) throws CoupounSystemException {
        if (!tokenService.isUserAllowed(token, ClientsType.ADMINISTRATOR)){
            throw new CoupounSystemException(ErrMsg.INVALID_ACTION);
        }
        return adminService.getAllCompanies();
    }

    @PostMapping("/companies/add")
    public void addCompany( @RequestHeader UUID token, @RequestBody Company company) throws Exception {
        if (!tokenService.isUserAllowed(token, ClientsType.ADMINISTRATOR)){
            throw new CoupounSystemException(ErrMsg.INVALID_ACTION);
        }
        adminService.addCompany(company);

    }

    @DeleteMapping("/companies/del/{id}")
    public void deleteCompany( @RequestHeader UUID token, @PathVariable int id) throws Exception {
        if (!tokenService.isUserAllowed(token, ClientsType.ADMINISTRATOR)){
            throw new CoupounSystemException(ErrMsg.INVALID_ACTION);
        }
        adminService.deleteCompany(id);

    }

    @GetMapping("/companies/{id}")
    public Company getSingleCompany( @RequestHeader UUID token, @PathVariable int id) throws Exception {
        if (!tokenService.isUserAllowed(token, ClientsType.ADMINISTRATOR)){
            throw new CoupounSystemException(ErrMsg.INVALID_ACTION);
        }
        return adminService.getSingleCompany(id);
    }

    @PostMapping("/companies/update/{id}")
    public void updateCompany(@RequestHeader UUID token, @PathVariable int id, @RequestBody Company company) throws Exception {
        if (!tokenService.isUserAllowed(token, ClientsType.ADMINISTRATOR)){
            throw new CoupounSystemException(ErrMsg.INVALID_ACTION);
        }
        adminService.updateCompany(id,company);

    }

    @GetMapping("/customer")
    public List<Customer> getAllCustomers(@RequestHeader UUID token) throws CoupounSystemException {
        if (!tokenService.isUserAllowed(token, ClientsType.ADMINISTRATOR)){
            throw new CoupounSystemException(ErrMsg.INVALID_ACTION);
        }
        return adminService.getAllCustomers();
    }

    @PostMapping("/customer/add")
    public void addCustomer(@RequestHeader UUID token, @RequestBody Customer customer) throws Exception {
        if (!tokenService.isUserAllowed(token, ClientsType.ADMINISTRATOR)){
            throw new CoupounSystemException(ErrMsg.INVALID_ACTION);
        }
        adminService.addCustomer(customer);

    }

    @DeleteMapping("/customer/del/{id}")
    public void deleteCustomer(@RequestHeader UUID token, @PathVariable int id) throws Exception {
        if (!tokenService.isUserAllowed(token, ClientsType.ADMINISTRATOR)){
            throw new CoupounSystemException(ErrMsg.INVALID_ACTION);
        }
        adminService.deleteCustomer(id);

    }

    @GetMapping("/customer/{id}")
    public Customer getSingleCustomer(@RequestHeader UUID token, @PathVariable int id) throws Exception {
        if (!tokenService.isUserAllowed(token, ClientsType.ADMINISTRATOR)){
            throw new CoupounSystemException(ErrMsg.INVALID_ACTION);
        }
        return adminService.getSingleCustomer(id);
    }

    @PostMapping("/customer/update/{id}")
    public void updateCustomer(@RequestHeader UUID token, @PathVariable int id, @RequestBody Customer customer) throws Exception {
        if (!tokenService.isUserAllowed(token, ClientsType.ADMINISTRATOR)){
            throw new CoupounSystemException(ErrMsg.INVALID_ACTION);
        }
        adminService.updateCustomer(id, customer);

    }


}
