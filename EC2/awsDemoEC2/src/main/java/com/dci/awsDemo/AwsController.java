package com.dci.awsDemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AwsController {

    @GetMapping("/helloAws")
    public String helloAws() {
        return "Hello from EC2!";
    }
}
