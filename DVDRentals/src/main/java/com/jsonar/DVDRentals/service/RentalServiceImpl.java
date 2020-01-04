/** ===========================================================================
 * Program : RentalServiceImpl.java
 * Function: The implematation of the rental services
 * @author : Bill Huang
 * Date    : Dec 29, 2019
 ** ========================================================================= */

 package com.jsonar.DVDRentals.service;

 import java.util.ArrayList;
 import java.util.List;

 import com.jsonar.DVDRentals.dao.CustomerRepository;
 import com.jsonar.DVDRentals.dao.FilmRepository;
 import com.jsonar.DVDRentals.entity.Customer;
 import com.jsonar.DVDRentals.entity.Film;
 import com.jsonar.DVDRentals.entity.Payment;
 import com.jsonar.DVDRentals.entity.Rental;
 import com.jsonar.DVDRentals.view.CustomerKeyInfo;

 import com.jsonar.DVDRentals.view.FilmRentedByCustomer;
 import com.jsonar.DVDRentals.view.FilmRentedInfo;

 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.data.mongodb.core.MongoTemplate;
 import org.springframework.data.mongodb.core.query.Criteria;
 import org.springframework.data.mongodb.core.query.Query;
 import org.springframework.stereotype.Service;

@Service
 public class RentalServiceImpl implements RentalService {

     @Autowired
     private MongoTemplate mongoTemplate;

     @Autowired
     CustomerRepository customerRepository;

     @Autowired
     FilmRepository filmRepository;

     /**
      * service 1:
      * @return
      */
     @Override
     public List<CustomerKeyInfo> getAllCustomersSrv() {
         Query query = new Query();
         query.fields()
                 .include("id")
                 .include("address")
                 .include("city")
                 .include("country")
                 .include("district")
                 .include("firstName")
                 .include("lastName")
                 .include("phone");
         List<Customer> customers = mongoTemplate.find(query, Customer.class);
         return CustomerOfRentedFilm(customers);
     }

    List<CustomerKeyInfo> CustomerOfRentedFilm(List<Customer> customers) {
        List<CustomerKeyInfo> customerKeyInfos = new ArrayList<>();
        if (customers.size() > 0) {
            for (Customer customer : customers) {
                CustomerKeyInfo customerKeyInfo = new CustomerKeyInfo();
                customerKeyInfo.setId(customer.getId());
                customerKeyInfo.setAddress(customer.getAddress());
                customerKeyInfo.setCity(customer.getCity());
                customerKeyInfo.setCountry(customer.getCountry());
                customerKeyInfo.setDistrict(customer.getDistrict());
                customerKeyInfo.setFirstName(customer.getFirstName());
                customerKeyInfo.setLastName(customer.getLastName());
                customerKeyInfo.setPhone((customer.getPhone()));
                customerKeyInfos.add(customerKeyInfo);
            }
        }
        return customerKeyInfos;
    }

    /**
      * Service 2:
      * @param phone
      * @return
      */
     @Override
     public List<CustomerKeyInfo> getAllCustomersByPhoneSrv(String phone) {
         Query query = new Query();
         query.addCriteria(Criteria.where("phone").is(phone));
         query.fields()
                 .include("id")
                 .include("address")
                 .include("city")
                 .include("country")
                 .include("district")
                 .include("firstName")
                 .include("lastName")
                 .include("phone");
         List<Customer> customers = mongoTemplate.find(query, Customer.class);
         return CustomerOfRentedFilm(customers);
     }

     /**
      * Service 3:
      * @param firstName
      * @param lastName
      * @return
      */
     @Override
     public List<Customer> getCustomersByFirstNameAndLastNameSrv(String firstName, String lastName){
         Query query = new Query();
         query.addCriteria(Criteria.where("firstName").is(firstName)
                 .and("lastName").is(lastName));
         List<Customer> customers = mongoTemplate.find(query, Customer.class);
         return customers;
     }

     /**
      * Service 4:
      * @param firstName
      * @param lastName
      * @return
      */
     @Override
     public List<FilmRentedByCustomer> getFilmListRentedByFirstNameAndLastNameSrv(String firstName, String lastName){
         // travel the collection of Customer by First name and Last name
         Query queryCustomer = new Query();
         queryCustomer.addCriteria(Criteria.where("firstName").is(firstName)
                 .and("lastName").is(lastName));
         List<Customer> customers = mongoTemplate.find(queryCustomer, Customer.class);

         return FilmListRentedByCustomer(customers);
     }

     List<FilmRentedByCustomer> FilmListRentedByCustomer(List<Customer> customers) {
         List<FilmRentedByCustomer> filmRentedByCustomerList = new ArrayList<>();
         if (customers.size() > 0) {
             for (Customer customer : customers) {

                 // get the rental information
                 Rental[] rentals = customer.getRental();
                 for (Rental rental : rentals) {

                     FilmRentedByCustomer filmRentedByCustomer = new FilmRentedByCustomer();

                     // When it was rented
                     filmRentedByCustomer.setRentalDate(rental.getRentalDate());

                     // Duration (in minutes)
                     long milliseconds = rental.getReturnDate().getTime()
                             - rental.getRentalDate().getTime();
                     int seconds = (int) milliseconds / 1000;
                     //  int minutes = seconds / 60;
                     int hours = seconds / 3600;
                     filmRentedByCustomer.setDuration(hours);

                     // Payment amount
                     double totalPayment = 0.0;
                     Payment[] payments = rental.getPayment();
                     for (Payment payment : payments) {
                         totalPayment += payment.getAmount();
                     }
                     filmRentedByCustomer.setPaymentAmount((float) totalPayment);

                     // Link to the Film details (see below section 4b)
                     filmRentedByCustomer.setFilmID(rental.getFilmId());

                     // add rented move information into the file rental customer list
                     filmRentedByCustomerList.add(filmRentedByCustomer);
                 }
             }
         }
         return filmRentedByCustomerList;
     }

     /**
      * Service 5:
      * @param phone
      * @return
      */
     @Override
     public List<FilmRentedByCustomer> getFilmListRentedByPhoneSrv(String phone){
         // travel the collection of Customer by phone
         Query queryCustomer = new Query();
         queryCustomer.addCriteria(Criteria.where("phone").is(phone));
         List<Customer> customers = mongoTemplate.find(queryCustomer, Customer.class);

         return FilmListRentedByCustomer(customers);
     }

     /**
      * Service 6:
      * @return
      */
     public List<FilmRentedInfo> getAllFilmsSrv(){
         Query query = new Query();
         query.fields()
                 .include("title")
                 .include("category")
                 .include("discription")
                 .include("rating")
                 .include("rentalDuration");
         List<Film> films = mongoTemplate.find(query, Film.class);
         return filmFiledsReformatted(films);
     }

     List<FilmRentedInfo> filmFiledsReformatted(List<Film> films) {
         List<FilmRentedInfo> filmRentedInfos = new ArrayList<>();
         if (films.size() > 0) {
             for (Film film : films) {
                 FilmRentedInfo filmRentedInfo = new FilmRentedInfo();
                 filmRentedInfo.setTitle(film.getTitle());
                 filmRentedInfo.setCategory(film.getCategory());
                 filmRentedInfo.setDiscription(film.getDescription());
                 filmRentedInfo.setRating(film.getRating());
                 filmRentedInfo.setRentalDuration(film.getRentalDuration());
                 filmRentedInfos.add(filmRentedInfo);
             }
         }
         return filmRentedInfos;
     }

     /**
      * Service 7
      * @param title (film title)
      * @return
      */
     public List<CustomerKeyInfo> getCustomersByAFilmSrv(String title){
         Query queryCustomer = new Query();
         queryCustomer.addCriteria(Criteria.where("rental.filmTitle").is(title));
         List<Customer> customers = mongoTemplate.find(queryCustomer, Customer.class);
         return CustomerOfRentedFilm(customers);
     }

    /**
     * Service 8
     * @param title
     * @return
     */
    public List<Film> getFilmDetailsByAFilmNameSrv(String title){
        Query queryFilm = new Query();
        queryFilm.addCriteria(Criteria.where("title").is(title));
        List<Film> films = mongoTemplate.find(queryFilm, Film.class);
        return films;
    }

}