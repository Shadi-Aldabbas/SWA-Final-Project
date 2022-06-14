package com.SWAFinalProject.AuthService.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    public static final String KEYSAPCE = "userKeySpace";

    @Override
    public String getKeyspaceName() {
        return KEYSAPCE;
    }

}
