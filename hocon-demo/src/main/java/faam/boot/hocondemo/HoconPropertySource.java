package faam.boot.hocondemo;

import com.typesafe.config.*;
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
        Object ret = null;
        try {
            final ConfigValue sourceValue = this.source.getValue(path);
            if (sourceValue.valueType() == ConfigValueType.OBJECT) {
                ret = this.source.getConfig(path);
            } else {
                ret = sourceValue.unwrapped();
            }
        } catch (final ConfigException ignored) {
            // ignored
        }
        return ret;
    }
}
