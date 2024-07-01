package com.example.config;

import org.example.config.ShowDomainConfig;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(ShowDomainConfig.class)
@ComponentScan(basePackages = "com.example")
public class ShowApiConfig {

}
