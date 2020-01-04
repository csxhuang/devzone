/** ===========================================================================
 * Program : DVDRentalController.java
 * Function: The DVD Rental controller to provide information service
 * @author : Bill Huang
 * Date    : Jan 1, 2020
 ** ========================================================================= */

package com.jsonar.DVDRentals.controller;

import com.jsonar.DVDRentals.entity.Customer;
import com.jsonar.DVDRentals.entity.Film;
import com.jsonar.DVDRentals.service.RentalService;
import com.jsonar.DVDRentals.view.CustomerKeyInfo;
import com.jsonar.DVDRentals.view.FilmRentedByCustomer;
import com.jsonar.DVDRentals.view.FilmRentedInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/api")
public class DVDRentalController {

    @Autowired
    private RentalService rentalService;

    /**
     * Controller 1: call the service 1
     * @return
     */
    @GetMapping(value="/allcustomers",produces= {"application/json;charset=UTF-8"})
    public Map<String,Object> getAllCustomersList(){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<CustomerKeyInfo> returnCustomersList = rentalService.getAllCustomersSrv();
        if(returnCustomersList.size() > 0) {
            modelMap.put("success",true);
            modelMap.put("data", returnCustomersList);
        }else {
            modelMap.put("success",false);
            modelMap.put("msg", "There is not customers.");
        }
        return modelMap;
    }

    /**
     * Controller 2: call the service 2
     * @param phone
     * @return
     */
    @GetMapping("customerphone/{phone}")
    public Map<String,Object> getCustomersListByPhone(@PathVariable String phone){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<CustomerKeyInfo> returnCustomerList = rentalService.getAllCustomersByPhoneSrv(phone);
        if(returnCustomerList.size() > 0) {
            modelMap.put("success", true);
            modelMap.put("data", returnCustomerList);
        }else {
            modelMap.put("success", false);
            modelMap.put("msg", "No found customer with this phone.");
        }
        return modelMap;
    }

    /**
     * Controller 3: call the service 3
     * @param firstName
     * @param lastName
     * @return
     */
    @GetMapping("customername/{firstName}/{lastName}")
    public Map<String,Object> getCustomersListByFirstNameAndLastName(
            @PathVariable String firstName,
            @PathVariable String lastName){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<Customer> returnCustomerList = rentalService.getCustomersByFirstNameAndLastNameSrv(firstName, lastName);
        if(returnCustomerList.size() > 0) {
            modelMap.put("success", true);
            modelMap.put("data", returnCustomerList);
        }else {
            modelMap.put("success", false);
            modelMap.put("msg", "No found customer with this name.");
        }
        return modelMap;
    }

    /**
     * Controller 4: call the service 4
     * @param firstName
     * @param lastName
     * @return
     */
    @GetMapping("rentalbyname/{firstName}/{lastName}")
    public Map<String,Object> getFilmListRentedByFirstNameAndLastName(
            @PathVariable String firstName,
            @PathVariable String lastName){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<FilmRentedByCustomer> returnCustomerList = rentalService.getFilmListRentedByFirstNameAndLastNameSrv(firstName, lastName);
        if(returnCustomerList.size() > 0) {
            modelMap.put("success", true);
            modelMap.put("data", returnCustomerList);
        }else {
            modelMap.put("success", false);
            modelMap.put("msg", "No found customer with this name.");
        }
        return modelMap;
    }

    /**
     * Controller 5: call the service 5
     * @param phone
     * @return
     */
    @GetMapping("rentalbyphone/{phone}")
    public Map<String,Object> getFilmListRentedByPhone(
            @PathVariable String phone){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<FilmRentedByCustomer> returnCustomerList = rentalService.getFilmListRentedByPhoneSrv(phone);
        if(returnCustomerList.size() > 0) {
            modelMap.put("success", true);
            modelMap.put("data", returnCustomerList);
        }else {
            modelMap.put("success", false);
            modelMap.put("msg", "No found customer with this phone.");
        }
        return modelMap;
    }

    /**
     * Controller 6: call the service 6
     * @return
     */
    @GetMapping(value="/allfilms",produces= {"application/json;charset=UTF-8"})
    public Map<String,Object> getAllFilmsList(){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<FilmRentedInfo> returnFilmsList = rentalService.getAllFilmsSrv();
        if(returnFilmsList.size() > 0) {
            modelMap.put("success",true);
            modelMap.put("data", returnFilmsList);
        }else {
            modelMap.put("success",false);
            modelMap.put("msg", "There is not films.");
        }
        return modelMap;
    }

    /**
     * Controller 7: call the service 7
     * @param film
     * @return
     */
    @GetMapping("customersbyfilm/{film}")
    public Map<String,Object> getCustomersListByFilm(@PathVariable String film){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<CustomerKeyInfo> returnCustomerList = rentalService.getCustomersByAFilmSrv(film);
        if(returnCustomerList.size() > 0) {
            modelMap.put("success", true);
            modelMap.put("data", returnCustomerList);
        }else {
            modelMap.put("success", false);
            modelMap.put("msg", "No found customer with this film.");
        }
        return modelMap;
    }

    /**
     * Controller 8: call the service 8
     * @param film
     * @return
     */
    @GetMapping("filmdetailbyname/{film}")
    public Map<String,Object> getFilmInfoByFilmName(@PathVariable String film){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<Film> returnFilmDetail = rentalService.getFilmDetailsByAFilmNameSrv(film);
        if(returnFilmDetail.size() > 0) {
            modelMap.put("success", true);
            modelMap.put("data", returnFilmDetail);
        }else {
            modelMap.put("success", false);
            modelMap.put("msg", "No found customer with this film.");
        }
        return modelMap;
    }

}