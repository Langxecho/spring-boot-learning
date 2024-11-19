package top.langxecho.springboot.websocket.configure.loader;

/**
 * @author 19086
 * @version 1.0
 * Create by 2024/9/23 18:31
 */

import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class CustomYamlPropertyLoader implements PropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        String sourceName = name != null ? name : resource.getResource().getFilename();
        if (sourceName != null && (sourceName.endsWith(".yml") || sourceName.endsWith(".yaml"))) {
            Properties propertiesFromYaml = loadYaml(resource);
            return new PropertiesPropertySource(sourceName, propertiesFromYaml);
        } else {
            return new org.springframework.core.io.support.DefaultPropertySourceFactory().createPropertySource(name, resource);
        }
    }

    // 加载YAML文件并将其转换为Properties
    private Properties loadYaml(EncodedResource resource) throws IOException {
        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        factory.setResources(resource.getResource());
        factory.afterPropertiesSet();
        return factory.getObject();
    }
}
