package com.spring.qualifiers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class FooService {

    @Autowired
    Formatter myFormatter;

    public void format() {
        System.out.println(myFormatter.format());
    }
}
