package pl.mojprojekt.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.mojprojekt.demo.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByRole(String role);
}
