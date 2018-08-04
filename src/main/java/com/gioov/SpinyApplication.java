package com.gioov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author godcheese@outlook.com
 */
@SpringBootApplication
public class SpinyApplication {
    private static final Logger LOGGER = LoggerFactory.getLogger(SpinyApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(SpinyApplication.class, args);
//        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//        System.out.println("password={" + passwordEncoder.encode("88888888") + "}");

        LOGGER.info("==================={}===================", "程序启动成功！");
    }
}
