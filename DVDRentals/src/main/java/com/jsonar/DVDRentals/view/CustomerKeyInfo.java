/** ===========================================================================
 * Program : CustomerKeyInfo.java
 * Function: The customer information used by the controller
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
public class CustomerKeyInfo {
    private String id;
    private String address;
    private String city;
    private String country;
    private String district;
    private String firstName;
    private String lastName;
    private String phone;
}