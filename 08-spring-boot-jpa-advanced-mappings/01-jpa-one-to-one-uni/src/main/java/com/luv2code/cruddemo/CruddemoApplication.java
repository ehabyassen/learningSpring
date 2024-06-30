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
			createInstructor(repository);
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
}
