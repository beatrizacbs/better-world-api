package br.com.betterworld;

import br.com.betterworld.models.Event;
import br.com.betterworld.repositories.EventRepository;
import br.com.betterworld.repositories.UserRepository;
import br.com.betterworld.security.entity.User;
import br.com.betterworld.security.enums.ProfileEnun;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class ApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }

    @Bean
    CommandLineRunner init(UserRepository userRepository, PasswordEncoder passwordEncoder, EventRepository eventRepository) {
        return args -> {
            initUsers(userRepository, passwordEncoder, eventRepository);
        };

    }

    private void initUsers(UserRepository userRepository, PasswordEncoder passwordEncoder, EventRepository eventRepository){

        User admin = new User();
        admin.setEmail("admin@security.com");
        admin.setPassword(passwordEncoder.encode("123456"));

        admin.setProfile(ProfileEnun.ROLE_ADMIN);

        User find = userRepository.findByEmail("admin@security.com");
        if (find == null) {
            admin = userRepository.save(admin);
        }

        Event event = new Event();

        event.setAddress("askdhkaslçhdçalshasç");
        event.setDescription("sdfsdfsdfsdfsd");
        event.setTitle("isuydfoiusydpiofus");
        event.setDate(new Date());
        List<String> usersId = new ArrayList<>();
        usersId.add(admin.getId());
        event.setParticipants(usersId);

        eventRepository.deleteAll();
        eventRepository.save(event);

    }
}
