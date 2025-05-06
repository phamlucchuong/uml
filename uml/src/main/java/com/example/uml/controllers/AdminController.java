package com.example.uml.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {

    @GetMapping("/admin")
    public String index() {
        return "admin/trangChu";
    }

    // @GetMapping("trangChu")
    // public String trangChu() {
    //     return "admin/trangChu";
    // }
}
