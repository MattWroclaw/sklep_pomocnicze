package pl.mojprojekt.demo.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import pl.mojprojekt.demo.entity.Uzytkownik;

import java.util.Optional;

public interface UzytkownikRepository extends JpaRepository<Uzytkownik, Long> {
    Optional<Uzytkownik> findUzytkownikByLoginMail(String loginMail);
    Uzytkownik findByLoginMail(String loginMail);
}
