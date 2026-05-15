package com.codegym.demo2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class OwnerController {
    @GetMapping("/owner/{ownerId}/pets/{petId}")
    public String owner(@PathVariable("ownerId") Long ownerId, @PathVariable("petId") Long petId) {
        System.out.println("Owner ID: " + ownerId + " Pet ID: " + petId);
        return "/index";
    }

    @GetMapping("/{name:[a-z-]+}-{version:\\d\\.\\d\\.\\d}{ext:\\.[a-z]+}")
    public String get(@PathVariable("name") String name, @PathVariable("version") String version, @PathVariable("ext") String ext) {
        System.out.println("Name: " + name + " Version: " + version + " Ext: " + ext);
        return "/index";
    }
}
