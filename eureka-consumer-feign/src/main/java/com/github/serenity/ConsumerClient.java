package com.github.serenity;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(value = "eureka-client", fallback = ConsumerHystrixClient.class)
public interface ConsumerClient {

    @GetMapping("/index")
    String consumer();
}
