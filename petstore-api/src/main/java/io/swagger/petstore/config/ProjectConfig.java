package io.swagger.petstore.config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Config.LoadPolicy;
import org.aeonbits.owner.Config.LoadType;

@LoadPolicy(LoadType.MERGE)
@Sources({"classpath:config.properties", "classpath:user/user.properties"})
public interface ProjectConfig extends Config {

    String env();

    @Key("${env}.base.url")
    String baseUrl();

    String version();

    @DefaultValue("de")
    String locale();

    boolean logging();
}