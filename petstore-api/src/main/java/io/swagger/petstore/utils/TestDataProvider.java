package io.swagger.petstore.utils;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;

@UtilityClass
@Slf4j
public class TestDataProvider {
    public static <T> T getTestData(Class<?> clazz, Class<T> tModel) {
        File file = new File(getClassLocation(clazz));
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        try {
            return om.readValue(file, tModel);
        } catch (IOException e) {
            log.warn(e.getMessage());
        }
        return null;
    }

    private static String getClassLocation(Class<?> clazz) {
        URL url = clazz.getResource(clazz.getSimpleName() + ".class");
        return Objects.requireNonNull(url).getPath()
                .replace(".class", ".yaml");
    }
}
