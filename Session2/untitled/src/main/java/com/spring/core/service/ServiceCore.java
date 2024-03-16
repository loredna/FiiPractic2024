package com.spring.core.service;

import com.spring.core.model.User;
import com.spring.core.service.interfaces.IValidator;
import org.springframework.stereotype.Service;

@Service
public class ServiceCore {

  private IValidator validator;

  public ServiceCore(IValidator validator) {
    this.validator = validator;
  }
  public void save(User user) {
    if (validator.isValid(user)) {
      System.out.println("User " + user.getName()
          + " " + user.getSurname() + " saved successfully.");
    } else {
      System.out.println("User you are trying to save contains errors.");
    }
  }


}
