package com.billion.lagola.admin.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class LagolaAdminGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(LagolaAdminGatewayApplication.class, args);
    }



}
