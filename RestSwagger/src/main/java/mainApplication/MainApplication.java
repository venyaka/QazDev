package mainApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context =
//                new ClassPathXmlApplicationContext("applicationContext.xml");

////        settings.setMainTitle();
//        AnnotationConfigApplicationContext context =
//                new AnnotationConfigApplicationContext(config.class);

        SpringApplication.run(MainApplication.class, args);
    }
}

