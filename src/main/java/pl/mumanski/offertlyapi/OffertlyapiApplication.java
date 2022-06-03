package pl.mumanski.offertlyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class OffertlyapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(OffertlyapiApplication.class, args);
    }

}
