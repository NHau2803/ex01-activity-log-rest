package com.ex01.rest.activitylog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({ "classpath:/spring/applicationContext.xml" })
public class ActivityLogApplication {

    public static void main(String[] args) {
        SpringApplication.run(ActivityLogApplication.class, args);
    }

}
