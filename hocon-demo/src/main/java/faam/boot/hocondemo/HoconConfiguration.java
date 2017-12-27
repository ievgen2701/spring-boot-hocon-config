package faam.boot.hocondemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

/**
 * @author Ievgen Anikushyn
 * @date 27.12.2017.
 */
@Configuration
@PropertySource(factory = HoconPropertySourceFactory.class, value = "${config}")
public class HoconConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public Object testBean() {
        System.out.println(this.environment.getProperty("DB_DRIVER_CLASS_NAME"));
        System.out.println(this.environment.getProperty("DB_PASSWORD"));
        System.out.println(this.environment.getProperty("DB_USER"));
        System.out.println(this.environment.getProperty("BASE"));
        System.out.println(this.environment.getProperty("BASE_OPTION"));
        return new Object();
    }

}
