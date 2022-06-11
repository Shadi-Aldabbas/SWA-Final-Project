package com.SWAFinalProject.AuthService.repository;

import com.SWAFinalProject.AuthService.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends CrudRepository<Role,Integer> {
}
