package faam.boot.hocondemo;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigException;
import com.typesafe.config.ConfigFactory;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.ResourcePropertySource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Ievgen Anikushyn
 * @date 27.12.2017.
 */
public final class HoconPropertySource extends PropertySource<Config> {

    public HoconPropertySource(final String name, final Config source) throws IOException {
        super(name, source);
    }

    @Override
    public Object getProperty(final String path) {
        try {
            return this.source.getAnyRef(path);
        } catch (final ConfigException ignored) {
            return null;
        }
    }
}
