package com.hisol.mpcapi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TestController {

    @Autowired
    private Prop prop;

    private static final String template = "パラメータ＝%s";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping(path = "/getList", method = RequestMethod.GET)
    public List<TestImage> greeting(@RequestParam(value="name", defaultValue="World") String name) {
        log.debug("nameは～{}", name);

        Collections.shuffle(prop.getImages());
        List<TestImage> result = new ArrayList<>();
        result.add(new TestImage(counter.incrementAndGet(), String.format(template, name), prop.getImages().get(0)));
        result.add(new TestImage(counter.incrementAndGet(), String.format(template, name), prop.getImages().get(1)));

        return result;
    }

    @RequestMapping(path = "/setListPost", method = RequestMethod.POST)
    public String setListPost(@RequestBody TestImage testImage) {
        log.info("はじまります{}", "よね");
        
        System.out.println(testImage.getId());
        System.out.println(testImage.getName());
        System.out.println(testImage.getContent());

        log.debug("おわり！{}", "のはず");
        return testImage.getId() + ":" + testImage.getName() + ":" + testImage.getContent() + "は完了";
    }
}