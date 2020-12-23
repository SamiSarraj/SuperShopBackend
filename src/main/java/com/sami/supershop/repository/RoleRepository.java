package com.sami.supershop.repository;

import com.sami.supershop.domain.Role;
import org.springframework.data.repository.CrudRepository;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRoleValue(String role);
}
