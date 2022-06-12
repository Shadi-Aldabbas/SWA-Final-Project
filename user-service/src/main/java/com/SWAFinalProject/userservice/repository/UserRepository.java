package com.cassandra.SWAFinalProject.repository;

import com.cassandra.SWAFinalProject.model.User;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CassandraRepository<User,String > {
}
