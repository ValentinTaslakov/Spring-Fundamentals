package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShipController {

    @GetMapping("/ship-add")
    public String addShip(){
        return "ship-add";
    }
}
