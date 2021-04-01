package com.example.coursebookings.components;

import com.example.coursebookings.models.Booking;
import com.example.coursebookings.models.Course;
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

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    public DataLoader() {
    }

    public void run(ApplicationArguments args) {
        Customer gregor = new Customer("Gregor", "Simpson", 29);
        Customer laureline = new Customer("Laureline", "Vaucoy", 12);
        customerRepository.save(gregor);
        customerRepository.save(laureline);

        Course python = new Course("Intro to Python", "Glasgow", 3);
        Course javaScript = new Course("Head Bashing in JavaScript", "Glasgow", 4);
        Course java = new Course("How To Dream in Java", "Edinburgh", 4);
        courseRepository.save(python);
        courseRepository.save(javaScript);
        courseRepository.save(java);

        Booking booking1 = new Booking("01-01-2021", python, gregor);
        Booking booking2 = new Booking("15-02-2021", javaScript, laureline);
        Booking booking3 = new Booking("15-02-2021", java, laureline);
        Booking booking4 = new Booking("01-01-2021", python, laureline);
        bookingRepository.save(booking1);
        bookingRepository.save(booking2);
        bookingRepository.save(booking3);
        bookingRepository.save(booking4);

    }

}
