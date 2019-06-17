package com.qfedu.ljb.server.config;

import com.qfedu.ljb.common.util.IdGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class IdGeneratorConfig {
    @Bean
    public IdGenerator createIG(){
        return new IdGenerator();
    }

}
