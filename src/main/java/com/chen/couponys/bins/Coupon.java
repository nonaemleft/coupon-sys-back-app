package com.chen.couponys.bins;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;

@Entity
@Table(name = "coupons")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Coupon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonIgnore
    @ToString.Exclude
    @ManyToOne
    private Company company;

    @Enumerated(EnumType.STRING)
    private Category category;

    private String title;

    private String description;

    private Date startDate;

    private Date endDate;

    private int amount;

    private double price;

    private String image;


}
