package com.billion.lagola.mall.gateway.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.billion.lagola.mall.gateway.util.AesUtil;
import com.billion.lagola.mall.gateway.util.TokenUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.factory.rewrite.RewriteFunction;
import org.springframework.cloud.gateway.support.BodyInserterContext;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ReactiveHttpOutputMessage;
import org.springframework.http.codec.HttpMessageReader;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpRequestDecorator;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.BodyInserter;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;


@Component
@Slf4j
public class RequestFilter implements GatewayFilter, Ordered {

    private static String TOKEN = "token";

    @Value("${aes.key}")
    private String aesKey;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {

        ServerHttpRequest request = exchange.getRequest();

        String contentType = request.getHeaders().getFirst("Content-Type");
        Optional.ofNullable(contentType).orElseThrow(() -> new IllegalArgumentException("Content-Type is null"));
        if (!HttpMethod.POST.equals(request.getMethod()) && !contentType.startsWith("multipart/form-data")) {
            throw new IllegalArgumentException("only support post request");
        }

//        token验证
        HttpHeaders headers = request.getHeaders();
        String token = headers.getFirst(TOKEN);
        if (StringUtils.isEmpty(token)) {
            throw new IllegalArgumentException("token is null");
        }
        TokenUtil.ValidRes valid;
        try {
            valid = TokenUtil.valid(token);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new IllegalArgumentException("token verification failed");
        }
        if (!valid.isValid()) {
            throw new IllegalArgumentException(valid.getMsg());
        }

//        验证 queryParam中的sign签名





//        解密body,修改body
//        String requestBody = exchange.getAttribute("cachedRequestBodyObject");
//        log.info("requestBody:{}", requestBody);
//        Optional.ofNullable(requestBody).orElseThrow(() -> new IllegalArgumentException("requestBody is null"));
//        JSONObject requestBodyJsonObj = JSONObject.parseObject(requestBody);
//        Optional.ofNullable(requestBodyJsonObj.get("data")).orElseThrow(() -> new IllegalArgumentException("requestBody's data is null"));
//        String data = requestBodyJsonObj.getString("data");
//        String decryptData;
//        try {
//            decryptData = AesUtil.decrypt(data, aesKey);
//        } catch (Exception e) {
//            log.error("fail to aes decrypt");
//            throw new IllegalArgumentException("data is error,fail to aes decrypt");
//        }
//        log.info("decryptData:{}", decryptData);
//        log.info("decryptDataJSON:{}", JSONObject.toJSONString(decryptData));
//
////        TODO  2019-12-02 Flux<RequestData> requestDataFlux = serverRequest.bodyToFlux(RequestData.class); 暂时无解解析inclass类型包装的问题
////        重写 ModifyRequestBodyGatewayFilterFactory 部分源码
//        Config config = new Config();
//        config.setInClass(JSON.class);
//        config.setOutClass(JSONObject.class);
//        config.setContentType(MediaType.APPLICATION_JSON);
//        List<HttpMessageReader<?>> messageReaders = new LinkedList<>();
//        ServerRequest serverRequest = ServerRequest.create(exchange, messageReaders);
////        demo
//        Flux<RequestData> requestDataFlux = serverRequest.bodyToFlux(RequestData.class);
//        JSONObject peek = serverRequest.bodyToMono(JSONObject.class).toProcessor().peek();
//        log.info("peek:{}", peek.toJSONString());
////        Mono<?> modifiedBody = serverRequest.bodyToMono(config.getInClass())
////                .flatMap((body) -> {
////                    decryptDataFunction(decryptData).apply(exchange, (String) o);
////                });
//        Mono<?> modifiedBody = serverRequest.bodyToMono(JSONObject.class)
//                .flatMap(body -> Mono.just(decryptData));
////        默认解码后明文为 JSONString
//        BodyInserter bodyInserter = BodyInserters.fromPublisher(modifiedBody, config.getOutClass());
//        HttpHeaders newHeaders = new HttpHeaders();
//        newHeaders.putAll(exchange.getRequest().getHeaders());
//        newHeaders.remove("Content-Length");
//        if (config.getContentType() != null) {
//            newHeaders.set("Content-Type", config.getContentType().toString());
//        }
//
//        LocalCachedBodyOutputMessage outputMessage = new LocalCachedBodyOutputMessage(exchange, newHeaders);
//        return bodyInserter.insert(outputMessage, new BodyInserterContext()).then(Mono.defer(() -> {
//            ServerHttpRequest decorator = decorate(exchange, newHeaders, outputMessage);
//            return chain.filter(exchange.mutate().request(decorator).build());
//        }));

    }

    /**
     * 添加新的body
     *
     * @param decryptData
     * @return
     */
    private RewriteFunction<String, String> decryptDataFunction(String decryptData) {
        return (exchange, resp) ->
                Mono.just(decryptData);
    }

    /**
     * 重构 request
     *
     * @param exchange
     * @param headers
     * @param outputMessage
     * @return
     */
    ServerHttpRequestDecorator decorate(ServerWebExchange exchange, HttpHeaders headers, LocalCachedBodyOutputMessage outputMessage) {
        return new ServerHttpRequestDecorator(exchange.getRequest()) {
            @Override
            public HttpHeaders getHeaders() {
                long contentLength = headers.getContentLength();
                HttpHeaders httpHeaders = new HttpHeaders();
                httpHeaders.putAll(super.getHeaders());
                if (contentLength > 0L) {
                    httpHeaders.setContentLength(contentLength);
                } else {
                    httpHeaders.set("Transfer-Encoding", "chunked");
                }
                return httpHeaders;
            }

            @Override
            public Flux<DataBuffer> getBody() {
                return outputMessage.getBody();
            }
        };
    }

    /**
     * 自定义 CachedBodyOutputMessage
     */
    class LocalCachedBodyOutputMessage implements ReactiveHttpOutputMessage {
        private final DataBufferFactory bufferFactory;
        private final HttpHeaders httpHeaders;
        private Flux<DataBuffer> body = Flux.error(new IllegalStateException("The body is not set. Did handling complete with success?"));

        LocalCachedBodyOutputMessage(ServerWebExchange exchange, HttpHeaders httpHeaders) {
            this.bufferFactory = exchange.getResponse().bufferFactory();
            this.httpHeaders = httpHeaders;
        }

        @Override
        public void beforeCommit(Supplier<? extends Mono<Void>> action) {
        }

        @Override
        public boolean isCommitted() {
            return false;
        }

        @Override
        public HttpHeaders getHeaders() {
            return this.httpHeaders;
        }

        @Override
        public DataBufferFactory bufferFactory() {
            return this.bufferFactory;
        }

        public Flux<DataBuffer> getBody() {
            return this.body;
        }

        @Override
        public Mono<Void> writeWith(Publisher<? extends DataBuffer> body) {
            this.body = Flux.from(body);
            return Mono.empty();
        }

        @Override
        public Mono<Void> writeAndFlushWith(Publisher<? extends Publisher<? extends DataBuffer>> body) {
            return this.writeWith(Flux.from(body).flatMap((p) -> p));
        }

        @Override
        public Mono<Void> setComplete() {
            return this.writeWith(Flux.empty());
        }
    }

    @Data
    public static class Config {
        private Class inClass;
        private Class outClass;
        private MediaType contentType;
        private RewriteFunction rewriteFunction;

    }


    @Data
    public static class RequestData {
        private String data;
    }

    @Override
    public int getOrder() {
        return -2;
    }
}
