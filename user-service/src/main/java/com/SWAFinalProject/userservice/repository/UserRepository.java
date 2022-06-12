package com.SWAFinalProject.userservice.repository;


import com.SWAFinalProject.userservice.model.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CassandraRepository<User, String> {
}
