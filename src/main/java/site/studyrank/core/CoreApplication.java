package site.studyrank.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import site.studyrank.core.domain.Page;
import site.studyrank.core.repository.PageRepository;
import site.studyrank.core.service.PageService;

import javax.persistence.EntityManager;

@SpringBootApplication
public class CoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreApplication.class, args);
	}

}
