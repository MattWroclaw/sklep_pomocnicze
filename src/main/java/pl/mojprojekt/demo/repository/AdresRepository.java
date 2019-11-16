package pl.mojprojekt.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mojprojekt.demo.entity.Adres;

public interface AdresRepository extends JpaRepository<Adres, Long> {
}
