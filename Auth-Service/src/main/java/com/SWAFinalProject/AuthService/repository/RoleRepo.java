package com.SWAFinalProject.AuthService.repository;

import com.SWAFinalProject.AuthService.entity.Role;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends CassandraRepository<Role,Integer> {
}
