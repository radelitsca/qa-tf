package com.weavesocks;

import com.github.javafaker.Faker;
import com.socks.api.config.ProjectConfigImpl;
import com.socks.api.services.UserService;

import java.util.Locale;

public class BaseTest implements ProjectConfigImpl {
    protected final UserService service = new UserService();
    protected Faker faker = new Faker(new Locale(config.locale()));
}
