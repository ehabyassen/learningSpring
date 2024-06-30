package com.luv2code.cruddemo;

import com.luv2code.cruddemo.entity.Instructor;
import com.luv2code.cruddemo.entity.InstructorDetail;
import com.luv2code.cruddemo.repository.InstructorRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorRepository repository) {
		return runner -> {
			//createInstructor(repository);
			//findInstructor(1, repository);
			//findInstructor(2, repository);
			findAllInstructors(repository);
			System.out.println("#".repeat(50));
			deleteInstructor(2, repository);
			System.out.println("#".repeat(50));
			findAllInstructors(repository);
		};
	}

	private void createInstructor(InstructorRepository repository) {
		Instructor instructor = new Instructor("John", "Doe", "john@luv2code.com");

		InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "swimming");

		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor: " + instructor);

		repository.save(instructor);

		System.out.println("Saved instructor: " + instructor);
	}

	private void findInstructor(int id, InstructorRepository repository) {
		System.out.println("Finding instructor by id: [" + id + "]");

		System.out.println("Found instructor: " + repository.findById(id));
	}

	private void findAllInstructors(InstructorRepository repository) {
		repository.findAll().forEach(System.out::println);
	}

	private void deleteInstructor(int id, InstructorRepository repository) {
		repository.deleteById(id);
	}
}
