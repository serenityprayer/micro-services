package com.github.serenity;

import org.springframework.stereotype.Component;

@Component
public class ConsumerHystrixClient implements ConsumerClient {

    @Override
    public String consumer() {
        return "feign hystrix fallback";
    }
}
