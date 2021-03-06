package com.finalproject.ansewerservice.config;

import lombok.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.cassandra.config.AbstractCassandraConfiguration;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.core.cql.keyspace.CreateKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.DropKeyspaceSpecification;
import org.springframework.data.cassandra.core.cql.keyspace.KeyspaceOption;

import java.util.Arrays;
import java.util.List;

@Configuration
public class CassandraConfig extends AbstractCassandraConfiguration {

    public static final String KEYSAPCE = "mykeyspace";

    @Override
    public String getKeyspaceName() {
        return KEYSAPCE;
    }
    //    to create the table if not exist
    @Override
    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }




    //    to create the keyspace if not exist
    @Override
    protected List<CreateKeyspaceSpecification> getKeyspaceCreations() {
        CreateKeyspaceSpecification specification = CreateKeyspaceSpecification.createKeyspace(KEYSAPCE).ifNotExists()
                .with(KeyspaceOption.DURABLE_WRITES, true);

        return Arrays.asList(specification);
    }

    //    to drop the keyspace once we stop spring
    @Override
    protected List<DropKeyspaceSpecification> getKeyspaceDrops() {
        return Arrays.asList(DropKeyspaceSpecification.dropKeyspace(KEYSAPCE));
    }

    // to create the table from entity folder
    @Override
    public String[] getEntityBasePackages() {
        return new String[]{"com.finalproject.ansewerservice.model"};
    }

    @Override
    protected String getContactPoints() {
        return "host.docker.internal";
    }
}
