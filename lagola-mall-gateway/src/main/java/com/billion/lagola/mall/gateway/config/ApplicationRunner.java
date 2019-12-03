package com.billion.lagola.mall.gateway.config;

import com.billion.lagola.mall.gateway.util.JedisUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationRunner implements CommandLineRunner {

    @Value("${gateway.redis.address}")
    private String address;

    @Value("${gateway.redis.password}")
    private String password;

    @Override
    public void run(String... strings) throws Exception {
        JedisUtil.init(address, password);
    }
}
