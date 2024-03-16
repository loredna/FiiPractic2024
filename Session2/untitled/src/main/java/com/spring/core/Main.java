package com.spring.core;

import com.spring.core.config.ApplicationConfig;
import com.spring.core.model.User;
import com.spring.core.service.ServiceCore;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

  public static void main(String[] args) {
    ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);

    ServiceCore serviceCore = (ServiceCore) applicationContext.getBean("serviceCore");
    User myUser = new User("Emilian", "Marian");

    serviceCore.save(myUser);
  }
}
