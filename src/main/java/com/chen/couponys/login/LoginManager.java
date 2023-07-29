package com.chen.couponys.login;

import com.chen.couponys.bins.Company;
import com.chen.couponys.bins.Customer;
import com.chen.couponys.bins.User;
import com.chen.couponys.exceptions.CoupounSystemException;
import com.chen.couponys.exceptions.ErrMsg;
import com.chen.couponys.repos.CompanyRepository;
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
    static CompanyRepository companyRepository;
    @Autowired
    static TokenService tokenService;
    @Autowired
    static UserRepository userRepository;


    public static UUID login(String email, String password, ClientsType clientsType) throws Exception {
        switch (clientsType) {
            case ADMINISTRATOR: {
                AdminService adminService = new AdminServiceImpl();
                if (( adminService).login(email, password)) {
                    User user = userRepository.findByEmail(email).get(0);
                    System.out.println(user);

                    return tokenService.addToken(user);
                }
            }

            break;
            case COMPANY: {
                CompanyServiceImpl companyService = new CompanyServiceImpl();
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
                AdminService adminService = new AdminServiceImpl();
               Customer customer= adminService.getCustomerByEmail(email);
                if (customer.getId() == 0) {
                    throw new CoupounSystemException(ErrMsg.EMAIL_NOT_FOUND);
                }

                if (customer.getPassword().equals(password)) {
                    User user = userRepository.findByEmail(email).get(0);

                    return tokenService.addToken(user);

                }
            }
            break;


        }
        throw new CoupounSystemException(ErrMsg.EMAIL_AND_PASSWORD_DO_ONT_MACH);

    }
}

