package com.SWAFinalProject.userservice.repository;

import com.SWAFinalProject.userservice.entity.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserRepository extends CassandraRepository<User, UUID> {

    //TODO
//    User findUserByEmailAddress(String emailAddress);
}
