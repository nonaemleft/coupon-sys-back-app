package com.chen.couponys.login;

import com.chen.couponys.bins.Company;
import com.chen.couponys.bins.Customer;
import com.chen.couponys.bins.User;
import com.chen.couponys.exceptions.CoupounSystemException;
import com.chen.couponys.exceptions.ErrMsg;
import com.chen.couponys.repos.CompanyRepository;
import com.chen.couponys.repos.CustomerRepository;
import com.chen.couponys.repos.UserRepository;
import com.chen.couponys.security.TokenService;
import com.chen.couponys.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class LoginManager {

    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CustomerRepository customerRepository;


    public  UUID login(String email, String password, ClientsType clientsType) throws Exception {
        switch (clientsType) {
            case ADMINISTRATOR: {
                AdminService adminService = new AdminServiceImpl();
                if ((adminService).login(email, password)) {
                    User user = userRepository.findByEmail(email).get(0);
                    System.out.println(user);

                    return tokenService.addToken(user);
                }
            }

            break;
            case COMPANY: {
                List<Company> companyList = companyRepository.findByEmail(email);
                if (companyList.size() == 0) {
                    throw new CoupounSystemException(ErrMsg.EMAIL_NOT_FOUND);
                }
                Company company = companyList.get(0);
                if (company.getPassword().equals(password)) {
                    User user = userRepository.findByEmail(email).get(0);

                    return tokenService.addToken(user);
                }
            }
            break;
            case CUSTOMER: {
                List<Customer> customerList = customerRepository.findByEmail(email);
                System.out.println(customerList);
                if (customerList.size()==0){
                    throw new CoupounSystemException(ErrMsg.EMAIL_NOT_FOUND);
                }
                Customer customer = customerList.get(0);
                if (customer.getPassword().equals(password)) {
                    List<User> userList = userRepository.findByEmail(email);
                    System.out.println("1234");
                    System.out.println(userList);
                    User user = userList.get(0);
                    System.out.println(user);
                    return tokenService.addToken(user);

                }
            }
            break;


        }
        throw new CoupounSystemException(ErrMsg.EMAIL_AND_PASSWORD_DO_ONT_MACH);

    }
}

