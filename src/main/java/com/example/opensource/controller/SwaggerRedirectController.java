package com.example.opensource.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class SwaggerRedirectController {

    @GetMapping("/swagger-ui.html")
    public void swaggerRedirect(HttpServletResponse response) throws IOException{
        response.sendRedirect("/swagger-ui/index.html");
    }
}
