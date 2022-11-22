package ru.gb.jSilver.SpringMarket.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gb.jSilver.SpringMarket.data.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}