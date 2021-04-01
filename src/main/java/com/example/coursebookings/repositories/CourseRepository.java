package com.example.coursebookings.repositories;

import com.example.coursebookings.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findCoursesByRating(int rating);

}
