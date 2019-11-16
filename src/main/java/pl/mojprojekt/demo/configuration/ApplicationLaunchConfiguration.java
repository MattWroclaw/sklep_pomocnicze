package pl.mojprojekt.demo.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import pl.mojprojekt.demo.entity.Role;
import pl.mojprojekt.demo.repository.RoleRepository;

@RequiredArgsConstructor
@Configuration
public class ApplicationLaunchConfiguration {

    private final RoleRepository roleRepository;

    @EventListener(ApplicationReadyEvent.class)
    public void loadRoles(){
        Role roleAdmin = roleRepository.findByRole("ADMIN");
        Role roleUser = roleRepository.findByRole("USER");

        if(roleAdmin == null){
            roleAdmin = new Role(1l, "ADMIN");
            roleRepository.save(roleAdmin);
        }

        if(roleUser == null){
            roleUser = new Role(2l, "USER");
            roleRepository.save(roleUser);
        }
    }
}
