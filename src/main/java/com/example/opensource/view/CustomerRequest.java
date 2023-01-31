package com.example.opensource.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerRequest {
    private Integer id;
    private String firstname;
    private String lastname;
    private Boolean gender;
    private Date birthday;

    private Integer customerId;
    private String city;
    private String zipcode;
    private String street;
}
