package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //restcontroller?
public class SiteController {

  @GetMapping("/index")
  public String indexSite() {
    return "index";
  }
}
