package com.jsonar.DVDRentals;

import java.util.List;

import com.jsonar.DVDRentals.dao.CustomerRepository;
import com.jsonar.DVDRentals.entity.Customer;
import com.jsonar.DVDRentals.entity.Film;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static sun.misc.MessageUtils.where;

@SpringBootTest
public class MongoTemplateTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void testCustomerProjectionsUsingMongoTemplate3() {
        Query query = new Query();
        query.addCriteria(Criteria.where("phone").is("918119601885"));
        List<Customer> customers = mongoTemplate.find(query, Customer.class);
        System.out.println(customers.toString());
    }

    @Test
    public void testCustomerProjectionsUsingMongoTemplate2() {
        Query query = new Query();
        query.fields()
                .include("id")
                .include("phone")
                .include("rental");
        List<Customer> customers = mongoTemplate.find(query, Customer.class);
        System.out.println(customers.toString());
    }

    @Test
    public void testCustomerProjectionsUsingMongoTemplate1() {
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
        //  .exclude("rental");
        // List<CustomerKeyInfo> customers = mongoTemplate.find(query, Customer.class);
        List<Customer> customers = mongoTemplate.find(query, Customer.class);
        System.out.println(customers.toString());
    }

    @Test
    public void testCustomer2() {

        Pageable pageableRequest = PageRequest.of(0, 1);
        Page<Customer> page = customerRepository.findAll(pageableRequest);
        List<Customer> customers = page.getContent();
        System.out.println(customers.toString());
        
    }

    @Test
    public void testCustomer1() {
        List<Customer> customerList = mongoTemplate.findAll(Customer.class);
        if (customerList != null && customerList.size() > 0) {
            customerList.forEach(customer -> {
                System.out.println(customer.toString());
            });
        }
    }

    @Test
    public void testFilm() {
        List<Film> filmList = mongoTemplate.findAll(Film.class);
        if (filmList != null && filmList.size() > 0) {
            filmList.forEach(film -> {
                System.out.println(film.toString());
            });
        }
    }

}