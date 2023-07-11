package mainApplication;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApplication {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        Settings settings = context.getBean("settings", Settings.class);

//        settings.setMainTitle();

        SpringApplication.run(MainApplication.class, args);

    }

}
