package com.spring.core.config;

import com.spring.core.service.ServiceCore;
import com.spring.core.service.Validator;
import com.spring.core.service.interfaces.IValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com.spring.core.service"})
public class ApplicationConfig {
}
