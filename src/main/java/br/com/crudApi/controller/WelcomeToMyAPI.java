package br.com.crudApi.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author maxjdev
 */

@RestController
@RequestMapping("/")
public class WelcomeToMyAPI {
    @GetMapping
    @Operation(summary = "Welcome")
    public String welcome() {
        return "*** WELCOME TO MY API *** \n" +
                "--|| USE THE \"/users\" RESOURCE TO CONSUME ||--";
    }
}
