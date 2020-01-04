/** ===========================================================================
 * Program : FilmRentedByCustomer.java
 * Function: Rental information for a customer 
 * @author : Bill Huang
 * Date    : Dec 29, 2019
 ** ========================================================================= */

package com.jsonar.DVDRentals.view;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmRentedByCustomer {
    private Date rentalDate;
    private int duration;
    private float paymentAmount;
    private int filmID;         //linkToFilm;
}