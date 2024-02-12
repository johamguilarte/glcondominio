package com.glcondominio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
@EnableJpaRepositories("com.glcondominio.repository")
@EntityScan("com.glcondominio.entity")
public class App {
    public static void main( String[] args )
    {
        System.out.println( "App-data" );
        SpringApplication.run(App.class, args);

    }
}
