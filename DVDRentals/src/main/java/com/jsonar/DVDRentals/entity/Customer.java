/** ===========================================================================
 * Program : Customer.java
 * Function: The entity of the customer to hold the customer information
 * @author : Bill Huang
 * Date    : Dec 28, 2019
 ** ========================================================================= */

package com.jsonar.DVDRentals.entity;

import java.io.Serializable;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customers")
public class Customer implements Serializable {
    private static final long serialVersionUID = -1L;

    @Field("_id")
    @Id private String id;
    @Field("Address")
    private String address;
    @Field("City")
    private String city;
    @Field("Country")
    private String country;
    @Field("District")
    private String district;
    @Field("First Name")
    private String firstName;
    @Field("Last Name")
    private String lastName;
    @Field("Phone")
    private String phone;
    @Field("Rentals")
    private Rental[] rental;

}