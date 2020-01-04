/** ===========================================================================
 * Program : Payment.java
 * Function: The entity of the payments to hold the payments information
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
public class Payment implements Serializable{
    private static final long serialVersionUID = -1L;

    @Field("Amount")
    private double amount;
    @Field("Payment Date")
    // private Date paymentDate;
    private Timestamp paymentDate;
    @Field("Payment Id")
    private int paymentId;

}