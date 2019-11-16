package pl.mojprojekt.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pl.mojprojekt.demo.entity.Role;
import pl.mojprojekt.demo.entity.Uzytkownik;
import pl.mojprojekt.demo.repository.UzytkownikRepository;

@Service
@RequiredArgsConstructor
public class AppUserDetailService implements UserDetailsService {

    private final UzytkownikRepository uzytkownikRepository;

    @Override
    public UserDetails loadUserByUsername(String loginMail) throws UsernameNotFoundException {
        Uzytkownik entityUrzytkownik = uzytkownikRepository.findUzytkownikByLoginMail(loginMail)
                .orElseThrow( ()-> new UsernameNotFoundException(
                        "Urzytkownik o loginie "+loginMail+" nie istnieje"
                ));
        String [] roles = entityUrzytkownik.getRoles()
                .stream()
                .map(Role::getRole)
                .toArray(String[]::new);
        return User.withUsername(entityUrzytkownik.getLoginMail())
                .password(entityUrzytkownik.getHaslo())
                .roles(roles)
                .build();
    }
}
