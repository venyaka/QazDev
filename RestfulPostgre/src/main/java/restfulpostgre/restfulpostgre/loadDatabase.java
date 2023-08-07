package restfulpostgre.restfulpostgre;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class loadDatabase {
    private static final Logger log = LoggerFactory.getLogger(loadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(TestInterface testInterface) {

        return args -> {
            log.info("Preloading " + testInterface.save(new Database("firstSalam")));
        };
    }
}
