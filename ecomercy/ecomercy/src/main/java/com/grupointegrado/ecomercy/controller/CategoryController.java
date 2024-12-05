package com.grupointegrado.ecomercy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @GetMapping("/api/dados")
    public String obterDados() {
        return "Dados do backend";
    }
}
