package com.j2kb.goalkeeperautodelete;

import com.j2kb.goalkeeperautodelete.repository.GoalRepository;
import com.j2kb.goalkeeperautodelete.repository.GoalRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GoalkeeperAutodeleteApplication implements CommandLineRunner {

	@Autowired
	private GoalRepository goalRepository;
	public static void main(String[] args) {
		SpringApplication.run(GoalkeeperAutodeleteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		goalRepository.updateTimeLimitGoal();
		goalRepository.updateTimeLimitCert();
	}
}
