package be.vdab.services;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@ComponentScan("be.vdab.services")
@EnableScheduling
public class ServicesConfig {

}
