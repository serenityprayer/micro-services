package com.github.serenity;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    private static final Logger LOG = LoggerFactory.getLogger(HelloController.class);

    @Value("${spring.application.name}")
    String serviceId;

    @Value("${server.port}")
    String serverPort;

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        return "hello " + name + ", this is first message";
    }

    @GetMapping("/index")
    public String index() throws InterruptedException {
        LOG.info("request is coming...");
        // Thread.sleep(5000L);
        StringBuffer result = new StringBuffer("DiscoveryClient: ");
        result.append(discoveryClient.description() + discoveryClient.getServices());
        discoveryClient.getInstances(serviceId).forEach(ins -> result.append(ins.getHost() +":"+ ins.getPort()).append(";"));
        result.append("current port:" + serverPort);
        return result.toString();
    }

}
