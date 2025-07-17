package com.busanit501.boot_project.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class SampleRestController {

    @GetMapping("/hiStr")
    public String[] hiStr() {
        log.info("SampleRestController에서 작업중. ");
        return new String[]{"aaa","bbb","ccc","ddd"};
    }
}