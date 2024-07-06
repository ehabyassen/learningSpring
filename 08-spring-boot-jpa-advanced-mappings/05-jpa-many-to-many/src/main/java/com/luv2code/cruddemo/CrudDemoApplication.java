package com.luv2code.cruddemo;

import com.luv2code.cruddemo.entity.*;
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
			//createCourseWithStudents(repository);
			//findCourseAndStudents(repository);
			//findStudentAndCourses(repository);
			//addMoreCoursesToStudent(repository);
			//deleteCourse(repository);
			deleteStudent(repository);
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

	private void deleteInstructor(Repository repository) {
		repository.deleteInstructorById(1);
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

	private void updateInstructor(Repository repository) {
		Instructor instructor = repository.findInstructorById(1);
		System.out.println(instructor);
		instructor.setLastName("Doe");
		repository.updateInstructor(instructor);
		instructor = repository.findInstructorById(1);
		System.out.println(instructor);
	}

	private void updateCourse(Repository repository) {
		Course course = repository.findCourseById(12);
		System.out.println(course);
		course.setTitle("Chemistry");
		repository.updateCourse(course);
		course = repository.findCourseById(12);
		System.out.println(course);
	}

	private void deleteCourse(Repository repository) {
		repository.deleteCourseById(10);
	}

	private void createCourseAndReviews(Repository repository) {
		Course course = new Course("PHP");
		course.addReview(new Review("Awesome!"));
		course.addReview(new Review("Great Course."));
		repository.saveCourse(course);
	}

	private void findCourseAndReviews(Repository repository) {
		Course course = repository.findCourseByIdJoinFetch(10);
		List<Review> reviews = course.getReviews();
		System.out.println(course);
		System.out.println(reviews);
	}

	private void deleteCourseAndReviews(Repository repository) {
		repository.deleteCourseById(10);
	}

	private void createCourseWithStudents(Repository repository) {
		Course course = new Course("PHP");

        course.addStudent(new Student("John", "Doe", "john@luv2code.com"));
		course.addStudent(new Student("Maria", "Hoffmann", "maria@luv2code.com"));

		repository.saveCourse(course);

		System.out.println(course);
		System.out.println(course.getStudents());
	}

	private void findCourseAndStudents(Repository repository) {
		Course course = repository.findCourseAndStudentsByCourseId(10);
		System.out.println(course);
		System.out.println(course.getStudents());
	}

	private void findStudentAndCourses(Repository repository) {
		Student student = repository.findStudentAndCoursesByStudentId(1);
		System.out.println(student);
		System.out.println(student.getCourses());
	}

	private void addMoreCoursesToStudent(Repository repository) {
		Student student = repository.findStudentAndCoursesByStudentId(1);
		student.addCourse(new Course("Java"));
		student.addCourse(new Course("MySQL"));
		repository.updateStudent(student);
	}

	private void deleteStudent(Repository repository) {
		repository.deleteStudentById(1);
	}
}
