package com.example.clinica.service.Security;

import com.example.clinica.model.entity.AppUser;
import com.example.clinica.model.entity.AppUserRole;
import com.example.clinica.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode("password");
        BCryptPasswordEncoder passwordEncoder2 = new BCryptPasswordEncoder();
        String hashedPassword2 = passwordEncoder2.encode("password2");
        userRepository.save(new AppUser("Yuli", "yuli", "yuli.gonzalez@gmail.com", hashedPassword, AppUserRole.ADMIN));
        userRepository.save(new AppUser("Joseph", "joseph", "joseph.j@outlook.com", hashedPassword2, AppUserRole.USER));
    }
}
