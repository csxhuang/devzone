/** ===========================================================================
 * Program : Actor.java
 * Function: The entity of the actors to hold the actors information
 * @author : Bill Huang
 * Date    : Dec 28, 2019
 ** ========================================================================= */

package com.jsonar.DVDRentals.entity;

import java.io.Serializable;

import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor implements Serializable{
    private static final long serialVersionUID = -1L;

    @Field("First name")
    private String firstName;
    @Field("Last name")
    private String lastName;
    private int actorId;

}