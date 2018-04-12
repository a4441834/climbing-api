package nl.redrock.climbersapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ClimbersApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClimbersApplication.class, args);
    }

}
