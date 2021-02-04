package com.example.mobiLelele.mobiLelele.repositoriy;

import com.example.mobiLelele.mobiLelele.model.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

}
