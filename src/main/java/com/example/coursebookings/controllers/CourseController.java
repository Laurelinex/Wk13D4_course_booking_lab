package com.example.coursebookings.controllers;

import com.example.coursebookings.models.Course;
import com.example.coursebookings.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value = "/courses")
    public ResponseEntity<List<Course>> getAllCourses(
            @RequestParam(name="rating", required = false) Integer rating,
            @RequestParam(name="customer_id", required = false) Long customerId
    ) {
//        if we have the rating, do the rating query
        if(rating != null) {
            return new ResponseEntity<>(courseRepository.findCoursesByRating(rating), HttpStatus.OK);
        }
//        if we have a customer id, do the customer id query
        if(customerId != null) {
            return new ResponseEntity<>(courseRepository.findCoursesByBookingsCustomerId(customerId), HttpStatus.OK);
        }
        return new ResponseEntity<>(courseRepository.findAll(), HttpStatus.OK);
    }

}
