package com.example.hr1.address.domain;

import jakarta.persistence.*;
import lombok.*;


@Table(name = "address")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Address {
    @Id
    @SequenceGenerator(name="address_sequence",sequenceName = "address_sequence",initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
    private long id;

    private String city;

    private String state;
    private String zip;
    private String streetName;
    private String country;

}
