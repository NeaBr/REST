package com.mytest.REST;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class InfoController {

    @GetMapping
    public String getInfo() {
        return "Tervetuloa visailupeliin! Kirjoita /quiz/question saadaksesi kysymyksen. Vastaa kysymykseen kirjoittamalla /quiz/answer?answer=vastaus" ;
    }

}
