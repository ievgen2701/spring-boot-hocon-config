package faam.boot.hocondemo;

import com.typesafe.config.ConfigBeanFactory;
import com.typesafe.config.ConfigFactory;
import com.typesafe.config.ConfigResolver;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;

/**
 * @author Ievgen Anikushyn
 * @date 27.12.2017.
 */
public final class HoconPropertySourceFactory implements PropertySourceFactory {

    @Override
    public PropertySource<?> createPropertySource(final String name, final EncodedResource encodedResource) throws IOException {
        final String resourceName = encodedResource.getResource().getFilename();
        final String sourceName = name == null ? "<3 hocon" : name;
        return new HoconPropertySource(sourceName, ConfigFactory.parseResources(resourceName));
    }
}
