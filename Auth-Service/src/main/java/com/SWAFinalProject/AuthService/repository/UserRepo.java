package com.SWAFinalProject.AuthService.repository;

import com.SWAFinalProject.AuthService.entity.User;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CassandraRepository<User, Integer> {
    @AllowFiltering
    User findByEmailAddress(String emailAddress);
}
