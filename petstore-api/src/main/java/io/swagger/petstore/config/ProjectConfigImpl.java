package io.swagger.petstore.config;

import org.aeonbits.owner.ConfigFactory;

public interface ProjectConfigImpl {
    //    ProjectConfig config = ConfigFactory.create(ProjectConfig.class);
    ProjectConfig config = ConfigFactory.create(ProjectConfig.class, System.getProperties());
}