package com.github.serenity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsumerController {

    @Autowired
    ConsumerClient consumerClient;

    @GetMapping("/consumer")
    public String consumer() {
        return consumerClient.consumer();
    }
}
