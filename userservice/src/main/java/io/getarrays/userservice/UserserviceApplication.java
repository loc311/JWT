package io.getarrays.userservice;

import io.getarrays.userservice.domain.Role;
import io.getarrays.userservice.domain.User;
import io.getarrays.userservice.service.UserService;
import java.util.ArrayList;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}
        
        @Bean
        PasswordEncoder passwordEncoderO(){
            return new BCryptPasswordEncoder();
        }
        
        @Bean
        CommandLineRunner run(UserService userService){
            return args -> {
                userService.saveRole(new Role(null, "ROLE_USER"));
                userService.saveRole(new Role(null, "ROLE_MANAGER"));
                userService.saveRole(new Role(null, "ROLE_ADMIN"));
                userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
                
                userService.saveUser(new User(null, "Bao Loc", "loc", "1234", new ArrayList<>()));
                userService.saveUser(new User(null, "Bao Tran", "tran", "1234", new ArrayList<>()));
                userService.saveUser(new User(null, "Thanh Vi", "vi", "1234", new ArrayList<>()));
                userService.saveUser(new User(null, "John Tra", "john", "1234", new ArrayList<>()));
                
                userService.addRoleToUser("vi", "ROLE_USER");
                userService.addRoleToUser("john", "ROLE_SUPER_ADMIN");
                userService.addRoleToUser("tran", "ROLE_MANAGER");
                userService.addRoleToUser("loc", "ROLE_ADMIN");
            };
        }
}
