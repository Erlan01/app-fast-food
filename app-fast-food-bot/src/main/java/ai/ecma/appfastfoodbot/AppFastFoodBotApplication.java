package ai.ecma.appfastfoodbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//@EnableEurekaClient
@EnableFeignClients
@SpringBootApplication
@EnableJpaRepositories(basePackages = "ai.ecma.lib.repository")
@EntityScan(basePackages = "ai.ecma.lib.entity")
public class AppFastFoodBotApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppFastFoodBotApplication.class, args);
    }

}
