package com.spring.qualifiers;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("myFormatter")
public class FooFormatter implements Formatter {

    public String format() {
        return "foo";
    }
}
