package com.example.opensource.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    @Id
    @Column(name = "customer_id")
    private Integer customerId;
    @Column
    private String city;
    @Column
    private String zipcode;
    @Column
    private String street;

    @OneToOne
    @MapsId
    @JoinColumn(name = "customer_id")
    @JsonIgnore
    private Customer customer;
}
