package com.web2.pos;

import com.web2.pos.entity.User;
import com.web2.pos.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class PosApplication {

    public static void main(String[] args) {
        SpringApplication.run(PosApplication.class, args);
    }

    @Bean
    public CommandLineRunner demoData(UserRepository repo) {
        return args -> {

            User user = User.builder()
                    .id(1L)
                    .username("admin")
                    .password("admin")
                    .role(1)
                    .build();

            repo.save(user);
        };
    }

}
