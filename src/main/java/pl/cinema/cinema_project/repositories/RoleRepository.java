package pl.cinema.cinema_project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.cinema.cinema_project.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findRoleByType(Role.Types types);
}
