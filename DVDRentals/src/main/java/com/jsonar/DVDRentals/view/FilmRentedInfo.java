/** ===========================================================================
 * Program : FilmRentedInfo.java
 * Function: The information of a film rented by customer 
 * @author : Bill Huang
 * Date    : Dec 29, 2019
 ** ========================================================================= */

package com.jsonar.DVDRentals.view;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmRentedInfo {
    private String title;
    private String category;
    private String discription;
    private String rating;
    private String rentalDuration;
}