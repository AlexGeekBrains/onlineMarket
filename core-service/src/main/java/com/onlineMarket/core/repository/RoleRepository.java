package com.onlineMarket.core.repository;

import com.onlineMarket.core.data.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
