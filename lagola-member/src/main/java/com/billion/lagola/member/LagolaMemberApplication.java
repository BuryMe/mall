package com.billion.lagola.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class LagolaMemberApplication {

    public static void main(String[] args) {
        SpringApplication.run(LagolaMemberApplication.class, args);
    }

}
