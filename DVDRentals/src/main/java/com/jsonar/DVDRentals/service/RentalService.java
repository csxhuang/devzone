/** ===========================================================================
 * Program : RentalService.java
 * Function: The services for the controller based on dao and entity
 * @author : Bill Huang
 * Date    : Dec 29, 2019
 ** ========================================================================= */

 package com.jsonar.DVDRentals.service;

 import java.util.List;

 import com.jsonar.DVDRentals.entity.Customer;
 import com.jsonar.DVDRentals.entity.Film;
 import com.jsonar.DVDRentals.view.CustomerKeyInfo;
 import com.jsonar.DVDRentals.view.FilmRentedByCustomer;
 import com.jsonar.DVDRentals.view.FilmRentedInfo;

public interface RentalService {

    /**
     * service 1:
     * 1. display a list of all customers (collection customers only)
     * 
     * @return
     */
     List<CustomerKeyInfo> getAllCustomersSrv();

    /**
     * service 2:
     * 2. Select a customer and:
     *    a. Show all the user’s information (i.e. address, name etc.)
     * 
     * @param phone
     * @return a list of customer
     */
    List<CustomerKeyInfo> getAllCustomersByPhoneSrv(String phone);

    /**
     * service 3:
     * 2. Select a customer and:
     *    a. Show all the user’s information (i.e. address, name etc.)
     * 
     * @param firstName
     * @param lastName
     * @return a list of customer
     */
   List<Customer> getCustomersByFirstNameAndLastNameSrv(String firstName, String lastName);

    /**
     * service 4:
     * 2. Select a customer and: (collection customers & films) 
     *    b. Display A list of all the movies the customer rented with the next 
     *       information for each: 
     *         i. When it was rented 
     *        ii. Duration 
     *       iii. Payment amount 
     *        iv. Link to the Film details (see below section 4b)
     *
     * @param firstName
     * @param lastName
     * @return
     */
     List<FilmRentedByCustomer> getFilmListRentedByFirstNameAndLastNameSrv(String firstName, String lastName);

    /**
     * Service 5:
     * 2. Select a customer and: (collection customers & films) 
     *    b. Display A list of all the movies the customer rented with the next
     *       information for each: 
     *         i. When it was rented 
     *        ii. Duration 
     *       iii. Payment amount 
     *        iv. Link to the Film details (see below section 4b)
     * 
     * @param phone
     * @return
     */
    List<FilmRentedByCustomer> getFilmListRentedByPhoneSrv(String phone);

    /**
     * Service 6:
     * 3. Display a list of all the available films, with the next information:
     *    a. Title
     *    b. Category
     *    c. Description
     *    d. Rating
     *    e. Rental Duration
     * @return
     */
     List<FilmRentedInfo> getAllFilmsSrv();

    /**
     * Service 7:
     * 4. Allow the user to select a film and get:
     *    a. List of all customers who rented it
     * @param title (film title)
     * @return
     */
     List<CustomerKeyInfo> getCustomersByAFilmSrv(String title);

    /**
     * Service 8:
     * 4. Allow the user to select a film and get:
     *    b. All the details of the film
     * @param title
     * @return
     */
     List<Film> getFilmDetailsByAFilmNameSrv(String title);

}