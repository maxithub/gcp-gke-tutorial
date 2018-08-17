package max.lab.gcpgketutorial.t01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by max on 18-8-17.
 */
@RestController
@SpringBootApplication
public class SimpleJavaApp {

    @RequestMapping("/")
    String hello() {
        return "Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(SimpleJavaApp.class, args);
    }
}
