/** ===========================================================================
 * Program : Film.java
 * Function: The entity of the film to hold the films information
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
@Document(collection = "films")
public class Film implements Serializable{
    private static final long serialVersionUID = -1L;
    
    @Field("_id")
    @Id private String id;
    @Field("Actors")
    private Actor[] actor;
    @Field("Category")
    private String category;
    @Field("Description")
    private String description;
    @Field("Length")
    private String length;
    @Field("Rating")
    private String rating;
    @Field("Rental Duration")
    private String rentalDuration;
    @Field("Replacement Cost")
    private String replacementCost;
    @Field("Special Features")
    private String specialFeatures;
    @Field("Title")
    private String title;

}