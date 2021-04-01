package com.example.coursebookings.components;

import com.example.coursebookings.models.Customer;
import com.example.coursebookings.repositories.BookingRepository;
import com.example.coursebookings.repositories.CourseRepository;
import com.example.coursebookings.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CustomerRepository customerRepository;

//    @Autowired
//    CourseRepository courseRepository;
//
//    @Autowired
//    BookingRepository bookingRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {
        Customer gregor = new Customer("Gregor", "Simpson", 29);
        Customer laureline = new Customer("Laureline", "Vaucoy", 12);
        customerRepository.save(gregor);
        customerRepository.save(laureline);

    }

}
