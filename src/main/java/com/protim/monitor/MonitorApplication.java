package com.protim.monitor;

import com.protim.monitor.entity.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@SpringBootApplication
public class MonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MonitorApplication.class, args);
	}

	@Bean
	public RepositoryRestConfigurer repositoryRestConfigurer()
	{
		return RepositoryRestConfigurer.withConfig(config -> {
			// Setting base path /student to /api/student
			config.setBasePath("/api");

			// Spring Data REST hides IDs by default for security.
			// Exposing them for demonstration.
			config.exposeIdsFor(Student.class);

			// Disabling PATCH -
			// PATCH is unsafe HTTP update as it needs only specific fields for update.
			// PUT on the other hand replaces the entire resource, even if they are not modified.
			config.getExposureConfiguration().disablePatchOnItemResources();

			// Disabling resource creation (201 Created) using PUT
			config.getExposureConfiguration().disablePutForCreation();
		});
	}

}
