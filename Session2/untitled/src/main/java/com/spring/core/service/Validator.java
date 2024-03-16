package com.spring.core.service;

import com.spring.core.model.User;
import com.spring.core.service.interfaces.IValidator;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
//@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class Validator implements IValidator {

  private  String bannedName;
  private  String bannedSurname;

  public Validator(String bannedName, String bannedSurname) {
    this.bannedName = bannedName;
    this.bannedSurname = bannedSurname;
  }

  public Validator() {

  }

  public boolean isValid(User user) {
    if (user == null) {
      return false;
    }

    if (user.getName().isEmpty() || user.getSurname().isEmpty()) {
      return false;
    }

    return !user.getName().equals(bannedName) || !user.getSurname().equals(bannedSurname);
  }

}
