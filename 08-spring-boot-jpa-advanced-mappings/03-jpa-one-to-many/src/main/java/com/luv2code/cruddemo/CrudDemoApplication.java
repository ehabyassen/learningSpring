package com.luv2code.cruddemo;

import com.luv2code.cruddemo.entity.Course;
import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.repository.Repository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(Repository repository) {
		return runner -> {
			//createInstructor(repository);
			//findInstructor(1, repository);
			//findInstructor(2, repository);
			//findAllInstructors(repository);
			//System.out.println("#".repeat(50));
			//deleteInstructor(2, repository);
			//System.out.println("#".repeat(50));
			//findAllInstructors(repository);
			//findInstructorDetail(1, repository);
			//findAllInstructorDetails(repository);
			//System.out.println("#".repeat(50));
			//deleteInstructorDetailById(3, repository);
			//findAllInstructorDetails(repository);
			//createInstructorWithCourses(repository);
			//findInstructorWithCourses(repository);
			//findCoursesForInstructor(repository);
			findInstructorWithCoursesJoinFetch(repository);
		};
	}

	private void createInstructor(Repository repository) {
		Instructor instructor = new Instructor("John", "Doe", "john@luv2code.com");

		InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "swimming");

		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor: " + instructor);

		repository.saveInstructor(instructor);

		System.out.println("Saved instructor: " + instructor);
	}

	private void findInstructor(int id, Repository repository) {
		System.out.println("Finding instructor by id: [" + id + "]");

		System.out.println("Found instructor: " + repository.findInstructorById(id));
	}

	private void findAllInstructors(Repository repository) {
		repository.findAllInstructors().forEach(System.out::println);
	}

	private void deleteInstructor(int id, Repository repository) {
		repository.deleteInstructorById(id);
	}

	private void findInstructorDetail(int id, Repository repository) {
		System.out.println("Finding instructor detail by id: " + id);
		InstructorDetail instructorDetail = repository.findInstructorDetailById(1);
		System.out.println("Found Instructor Detail: " + instructorDetail);
		System.out.println("Found Instructor: " + instructorDetail.getInstructor());
	}

	private void findAllInstructorDetails(Repository repository) {
		repository.findAllInstructorDetails().forEach(instructorDetail -> {
			System.out.println(instructorDetail);
			System.out.println(instructorDetail.getInstructor());
		});
	}

	private void deleteInstructorDetailById(int id, Repository repository) {
		repository.deleteInstructorDetailById(id);
	}

	private void createInstructorWithCourses(Repository repository) {
		Instructor instructor = new Instructor("John", "Doe", "john@luv2code.com");
		InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "swimming");
		instructor.setInstructorDetail(instructorDetail);

		List<Course> courses = List.of(new Course("Java"), new Course("MySQL"), new Course("Physics"));
		courses.forEach(instructor::addCourse);

		System.out.println("Saving instructor: " + instructor);
		System.out.println("with Courses: " + instructor.getCourses());

		repository.saveInstructor(instructor);
	}

	private void findInstructorWithCourses(Repository repository) {
		Instructor instructor = repository.findInstructorById(1);
		System.out.println(instructor);
		System.out.println(instructor.getCourses());
	}

	private void findCoursesForInstructor(Repository repository) {
		Instructor instructor = repository.findInstructorById(1);
		System.out.println(instructor);

		List<Course> courses = repository.findCoursesByInstructorId(instructor.getId());
		instructor.setCourses(courses);

		System.out.println(instructor.getCourses());
	}

	private void findInstructorWithCoursesJoinFetch(Repository repository) {
		Instructor instructor = repository.findInstructorByIdJoinFetch(1);
		System.out.println(instructor);
		System.out.println(instructor.getCourses());
	}
}
