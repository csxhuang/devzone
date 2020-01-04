/** ===========================================================================
 * Program : Rental.java
 * Function: The entity of rental to hold rental information 
 * @author : Bill Huang
 * Date    : Dec 28, 2019
 ** ========================================================================= */

package com.jsonar.DVDRentals.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Rental implements Serializable{
    private static final long serialVersionUID = -1L;

    @Field("Film Title")
    private String filmTitle;
    @Field("Payments")
    private Payment[] payment;
    @Field("Rental Date")
    // private Date rentalDate;
    private Timestamp rentalDate;
    @Field("Return Date")
    // private Date returnDate;
    private Timestamp returnDate;
    private int filmId;
    private int rentalId;
    private int staffId;

}