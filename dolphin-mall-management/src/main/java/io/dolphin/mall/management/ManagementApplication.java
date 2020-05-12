package io.dolphin.mall.management;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @Description:
 * @Author: Eric Liang
 * @Since: 2020-5-12 8:26
 */
@MapperScan("io.dolphin.mall")
@SpringBootApplication
public class ManagementApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {
        SpringApplication.run(ManagementApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ManagementApplication.class);
    }
}
