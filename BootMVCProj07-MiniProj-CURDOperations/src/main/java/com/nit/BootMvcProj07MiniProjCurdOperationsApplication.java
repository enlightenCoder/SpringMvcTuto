package com.nit;

import com.nit.dao.IEmployeeDao;
import com.nit.model.Employee;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BootMvcProj07MiniProjCurdOperationsApplication implements CommandLineRunner {

	@Autowired
	private IEmployeeDao repo;

	public static void main(String[] args) {
		SpringApplication.run(BootMvcProj07MiniProjCurdOperationsApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		repo.saveAll(List.of(new Employee("Rakesh", "Cook", 452f, 120), new Employee("Paul", "Bartender", 5000f, 120)));
	}

	@PreDestroy
	public void deleteTable() {
		repo.deleteAll();
	}
}
