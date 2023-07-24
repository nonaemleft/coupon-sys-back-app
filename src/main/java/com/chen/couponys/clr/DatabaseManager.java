package com.chen.couponys.clr;

import com.chen.couponys.bins.*;
import com.chen.couponys.login.ClientsType;
import com.chen.couponys.repos.CompanyRepository;
import com.chen.couponys.repos.CouponRepository;
import com.chen.couponys.repos.CustomerRepository;
import com.chen.couponys.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Component
public class DatabaseManager implements CommandLineRunner {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CouponRepository couponRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {


        Company company1 = Company.builder()
                .name("ivory")
                .email("info@ivory.com")
                .password("1234")
                .build();
        Company company2 = Company.builder()
                .name("nafis")
                .email("info@nafis.co.il")
                .password("1234")
                .build();
        Company company3 = Company.builder()
                .name("Isrotel")
                .email("info@Isrotel.co.il")
                .password("1234")
                .build();
        Company company4 = Company.builder()
                .name("shlomo-sixes")
                .email("info@shlomo-sixes.co.il")
                .password("1234")
                .build();
        Company company5 = Company.builder()
                .name("Super-Pharm Ltd.")
                .email("info@super-pharm.co.il")
                .password("1234")
                .build();
        Company company6 = Company.builder()
                .name("ksp")
                .email("info@ksp.com")
                .password("1234")
                .build();
        Company company7 = Company.builder()
                .name("fox")
                .email("info@fox.co.il")
                .password("1234")
                .build();
        Company company8 = Company.builder()
                .name("castro")
                .email("info@castro.com")
                .password("1234")
                .build();
        Company company9 = Company.builder()
                .name("mega")
                .email("info@mega.co.il")
                .password("1234")
                .build();
        Company company10 = Company.builder()
                .name("burger-ranch")
                .email("info@burger-ranch.co.il")
                .password("1234")
                .build();
        companyRepository.saveAll(List.of(company1, company2, company3, company4, company5, company6, company7,
                company8, company9, company10));


        Coupon coupon1 = Coupon.builder().company(company10).category(Category.RESTAURANT).title("1+1 meals")
                .description("1+1 on all meals in the restaurant").startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(1))).amount(100).price(39.9)
                .image("https://media.giphy.com/media/JteZf56ZXsJl6/giphy.gif").build();

        Coupon coupon2 = Coupon.builder().company(company5).category(Category.HEALTH).title("30% off shampoo")
                .description("30% off all kef shampoos").startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(5))).amount(250).price(9.9)
                .image("https://media.giphy.com/media/l0IyjDGdSzYr9tBf2/giphy.gif").build();

        Coupon coupon3 = Coupon.builder().company(company6).category(Category.ELECTRONICS).title("free keyboard and mose")
                .description("free gaming keyboard and mose wit computer perches").startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(3))).amount(50).price(49.9)
                .image("https://media.giphy.com/media/UevalSWg5twQeqpc8Q/giphy.gif").build();

        Coupon coupon4 = Coupon.builder().company(company1).category(Category.ELECTRONICS).title("15% off samsung phones")
                .description("15% off on all samsung cel-phones").startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(3))).amount(75).price(99.9)
                .image("https://media.giphy.com/media/Z37amIryHcLTy/giphy.gif").build();

        Coupon coupon5 = Coupon.builder().company(company2).category(Category.RESTAURANT).title("free Jachnun!!!!!")
                .description("free Jachnun on ani mill over 150 nis").startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(12))).amount(300).price(9.9)
                .image("https://media.giphy.com/media/3osxY7eI6enqNBo2mQ/giphy.gif").build();

        Coupon coupon6 = Coupon.builder().company(company3).category(Category.VACATION).title("10% of ani room")
                .description("10% of ani room in week days").startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(13))).amount(50).price(100)
                .image("https://media.giphy.com/media/120CndHE9HcOPK/giphy.gif").build();

        Coupon coupon7 = Coupon.builder().company(company7).category(Category.FASHION).title("20% on Button-up shirts")
                .description("20% of on our Button-up shirts. limited to 3 shirts per coupon").startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusWeeks(14))).amount(80).price(39.9)
                .image("https://media.giphy.com/media/LvHBV2O3aFqBG/giphy.gif").build();

        Coupon coupon8 = Coupon.builder().company(company8).category(Category.FASHION).title("free T-shirt")
                .description("free T-shirt on perches over 100 nis").startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(4))).amount(250).price(14.9)
                .image("https://media.giphy.com/media/UevalSWg5twQeqpc8Q/giphy.gif").build();

        Coupon coupon9 = Coupon.builder().company(company9).category(Category.FOOD).title("200 nis for store perches")
                .description("200 nis for store perches. not Does not include electronics. perch's over 500 nis only").startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusDays(7))).amount(100).price(69.9)
                .image("https://media.giphy.com/media/UevalSWg5twQeqpc8Q/giphy.gif").build();

        Coupon coupon10 = Coupon.builder().company(company4).category(Category.CARS).title("10% off monthly payment")
                .description("10% off monthly payment for a 36 moth lis").startDate(Date.valueOf(LocalDate.now()))
                .endDate(Date.valueOf(LocalDate.now().plusMonths(3))).amount(30).price(1500)
                .image("https://media.giphy.com/media/UevalSWg5twQeqpc8Q/giphy.gif").build();


        couponRepository.saveAll(List.of(coupon1, coupon2, coupon3, coupon4, coupon5, coupon6,
                coupon7, coupon8, coupon9, coupon10));

        Customer customer1 = Customer.builder()
                .firstName("John").couponList(List.of(coupon1, coupon5))
                .lastName("Doe")
                .email("john.doe@example.com")
                .password("1234")
                .build();

        Customer customer2 = Customer.builder()
                .firstName("Jane")
                .lastName("Smith")
                .email("jane.smith@example.com")
                .password("1234")
                .build();

        Customer customer3 = Customer.builder()
                .firstName("Bob")
                .lastName("Johnson")
                .email("bob.johnson@example.com")
                .password("1234")
                .build();

        Customer customer4 = Customer.builder()
                .firstName("Sarah")
                .lastName("Williams")
                .email("sarah.williams@example.com")
                .password("1234")
                .build();

        Customer customer5 = Customer.builder()
                .firstName("Tom")
                .lastName("Brown")
                .email("tom.brown@example.com")
                .password("1234")
                .build();

        Customer customer6 = Customer.builder()
                .firstName("Emily")
                .lastName("Davis")
                .email("emily.davis@example.com")
                .password("1234")
                .build();

        Customer customer7 = Customer.builder()
                .firstName("Mike")
                .lastName("Taylor")
                .email("mike.taylor@example.com")
                .password("1234")
                .build();

        Customer customer8 = Customer.builder()
                .firstName("Samantha")
                .lastName("Jones")
                .email("samantha.jones@example.com")
                .password("1234")
                .build();

        Customer customer9 = Customer.builder()
                .firstName("David")
                .lastName("Lee")
                .email("david.lee@example.com")
                .password("1234")
                .build();

        Customer customer10 = Customer.builder()
                .firstName("Amanda")
                .lastName("Clark")
                .email("amanda.clark@example.com")
                .password("1234")
                .build();

        customerRepository.saveAll(List.of(customer1, customer2, customer3, customer4, customer5, customer6, customer7,
                customer8, customer9, customer10));


        User user1 = User.builder()
                .email("admin@admin.com")
                .password("admin")
                .type(ClientsType.ADMINISTRATOR)
                .build();
        User user2= User.builder()
                .email("john.doe@example.com")
                .password("1234")
                .type(ClientsType.CUSTOMER)
                .build();
        User user3 = User.builder()
                .email("jane.smith@example.com")
                .password("1234")
                .type(ClientsType.CUSTOMER)
                .build();
        User user4 = User.builder()
                .email("bob.johnson@example.com")
                .password("1234")
                .type(ClientsType.CUSTOMER)
                .build();
        User user5 = User.builder()
                .email("sarah.williams@example.com")
                .password("1234")
                .type(ClientsType.CUSTOMER)
                .build();
        User user6 = User.builder()
                .email("tom.brown@example.com")
                .password("1234")
                .type(ClientsType.CUSTOMER)
                .build();
        User user7 = User.builder()
                .email("emily.davis@example.com")
                .password("1234")
                .type(ClientsType.CUSTOMER)
                .build();
        User user8 = User.builder()
                .email("mike.taylor@example.com")
                .password("1234")
                .type(ClientsType.CUSTOMER)
                .build();
        User user9 = User.builder()
                .email("samantha.jones@example.com")
                .password("1234")
                .type(ClientsType.CUSTOMER)
                .build();

        User user10 = User.builder()
                .email("david.lee@example.com")
                .password("1234")
                .type(ClientsType.CUSTOMER)
                .build();

        User user11 = User.builder()
                .email("amanda.clark@example.com")
                .password("1234")
                .type(ClientsType.CUSTOMER)
                .build();
        User user12 = User.builder()
                .email("info@ivory.com")
                .password("1234")
                .type(ClientsType.COMPANY)
                .build();


        userRepository.saveAll(List.of(user1,user2,user3,user4,user5,user6,user7,user8,user9,user10,user11,user12));


    }


}


