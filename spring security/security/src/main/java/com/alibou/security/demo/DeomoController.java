package com.alibou.security.demo;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/demo-controller")
public class DeomoController {

    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("hello from secured endpoint");
    }
}
