package com.lianglliu.config.p2s3;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LevelP2S3Controller {
    @Value("${levelNumber}")
    private int levelNumber;

    @GetMapping("/level/p2s3")
    public String getLevel() {
        return levelNumber < 1 ? "basic" : "advanced";
    }
}