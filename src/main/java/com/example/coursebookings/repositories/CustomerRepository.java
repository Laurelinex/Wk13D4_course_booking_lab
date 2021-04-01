package com.example.coursebookings.repositories;

import com.example.coursebookings.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findCustomersByBookingsCourseId(Long id);

    List<Customer> findCustomersByBookingsCourseTownAndBookingsCourseId(String town, Long id);

//    List<Customer> findCustomersByAgeGreaterThan(int age);

    List<Customer> findByBookingsCourseTownAndBookingsCourseIdAndAgeGreaterThan(String town, Long id, int age);
}
