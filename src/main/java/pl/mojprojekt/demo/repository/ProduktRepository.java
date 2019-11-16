package pl.mojprojekt.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mojprojekt.demo.entity.Produkt;

public interface ProduktRepository extends JpaRepository<Produkt, Long> {

}
