package com.billion.lagola.mall.gateway;

import com.billion.lagola.mall.gateway.filter.RequestFilter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;

@Slf4j
@SpringBootApplication
public class LagolaMallGatewayApplication {

    public static void main(String[] args) {
        log.info("----------- mall-gateway start ----------");
        SpringApplication.run(LagolaMallGatewayApplication.class, args);
        log.info("----------- mall-gateway end ----------");
    }

    @Autowired
    private RequestFilter requestFilter;

    /**
     * 实际测试中发现 读取 request Body的数据 必须采用 readBody 方式， 以code路由的形式配置，否则会有数据读取不全或者重复读取前半段的情况发生，所以移除yml 路由配置
     *
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator demoRout(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        RouteLocatorBuilder.Builder serviceProvider = routes
                .route("serviceRout1", r -> r
                        .order(-1)
                        .path("/**")
                        .and()
                        .method(HttpMethod.POST)
                        .and()
                        .readBody(String.class, readBody -> {
                            log.info("request method POST, body  is:{}", readBody);
                            return true;
                        })
                        .filters(f -> {
                            f.filter(requestFilter);
                            return f;
                        })
                        .uri("http://localhost:8080/"));
//                .route("serviceRout2", r -> r
//                        .order(1)
//                        .method(HttpMethod.POST)
//                        .and()
//                        .path("/service1Path/**")
//                        .and()
//                        .readBody(String.class, readBody -> {
//                            log.info("request method POST, body  is:{}", readBody);
//                            return true;
//                        })
//                        .filters(f -> {
//                            f.filter(requestFilter);
//                            return f;
//                        })
//                        .uri("service1ServerUrl"));
        return serviceProvider.build();

    }


}
