package training.iqgateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = "training.iqgateway")
@EnableDiscoveryClient
public class RegistrationServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegistrationServiceApplication.class, args);
    }
}