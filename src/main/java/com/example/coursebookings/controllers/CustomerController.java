package com.example.coursebookings.controllers;

import com.example.coursebookings.models.Course;
import com.example.coursebookings.models.Customer;
import com.example.coursebookings.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value = "/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(
            @RequestParam(name="course_id", required = false) Long courseId,
            @RequestParam(name="town", required = false) String town,
            @RequestParam(name="age", required = false) Integer age
    ) {
//        if we have course id in bookings, do the course id query
        if(courseId != null) {
            return new ResponseEntity<>(customerRepository.findCustomersByBookingsCourseId(courseId), HttpStatus.OK);
        }
        if(town != null && courseId != null){
            return new ResponseEntity<>(customerRepository.findCustomersByBookingsCourseTownAndBookingsCourseId(town, courseId), HttpStatus.OK);
        }
//        if(age !=null){
//            return new ResponseEntity<>(customerRepository.findCustomersByAgeGreaterThan(age), HttpStatus.OK);
//        }
        if(age != null  && town != null && courseId != null) {
            return new ResponseEntity<>(customerRepository.findByBookingsCourseTownAndBookingsCourseIdAndAgeGreaterThan(town, courseId, age), HttpStatus.OK);
        }
        return new ResponseEntity<>(customerRepository.findAll(), HttpStatus.OK);
    }
}
