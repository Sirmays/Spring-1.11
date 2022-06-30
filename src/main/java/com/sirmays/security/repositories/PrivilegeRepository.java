package com.sirmays.security.repositories;

import com.sirmays.security.entities.Privilege;
import com.sirmays.security.entities.Role;
import org.springframework.data.repository.CrudRepository;

public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {
}
